#!/usr/bin/env python3
"""
Checks the packs without starting Minecraft:
  - every JSON file parses
  - every item_model the datapack uses has resourcepack/assets/<ns>/items/<name>.json
  - every model / texture the resource packs point at exists (vanilla "minecraft:" ones are assumed to exist)
  - the wooden-handles pack only replaces textures that exist in the main resource pack
Exit code 1 if anything is wrong.
"""
import json, os, re, sys

ROOT = os.path.dirname(os.path.dirname(os.path.abspath(__file__)))
problems = []


def load(path):
    try:
        with open(path, encoding="utf-8") as f:
            return json.load(f)
    except Exception as e:  # noqa: BLE001
        problems.append(f"{os.path.relpath(path, ROOT)}: not valid JSON ({e})")
        return None


def files(folder, ext):
    for dirpath, _, names in os.walk(os.path.join(ROOT, folder)):
        for n in names:
            if n.endswith(ext):
                yield os.path.join(dirpath, n)


def split(ref, default_ns="minecraft"):
    ns, _, path = ref.partition(":") if ":" in ref else (default_ns, "", ref)
    return ns, path


def res(pack, kind, ref, ext):
    ns, path = split(ref)
    return ns, os.path.join(ROOT, pack, "assets", ns, kind, path + ext)


def walk(o, fn):
    if isinstance(o, dict):
        for k, v in o.items():
            fn(k, v)
            walk(v, fn)
    elif isinstance(o, list):
        for v in o:
            walk(v, fn)


for f in list(files("datapack", ".json")) + list(files("resourcepack", ".json")) + list(files("resourcepack-wooden-handles", ".json")) \
        + list(files("datapack", ".mcmeta")) + list(files("resourcepack", ".mcmeta")) + list(files("resourcepack-wooden-handles", ".mcmeta")):
    load(f)

# 1. item models used by the datapack
used_models = set()
for f in files("datapack", ".json"):
    d = load(f)
    if d is not None:
        walk(d, lambda k, v: used_models.add(v) if k == "minecraft:item_model" else None)
for f in files("datapack", ".mcfunction"):
    with open(f, encoding="utf-8") as fh:
        used_models.update(re.findall(r'"minecraft:item_model":"([a-z0-9_.:/-]+)"', fh.read()))
for m in sorted(used_models):
    ns, p = res("resourcepack", "items", m, ".json")
    if ns != "minecraft" and not os.path.exists(p):
        problems.append(f"datapack uses item_model {m} but resourcepack has no items/{split(m)[1]}.json")

# 2. references inside the resource pack
def check_ref(kind, ref, ext, where):
    ns, p = res("resourcepack", kind, ref, ext)
    if ns != "minecraft" and not os.path.exists(p):
        problems.append(f"{where}: points at missing {kind}/{split(ref)[1]}{ext} ({ref})")

for f in files("resourcepack/assets", ".json"):
    rel = os.path.relpath(f, ROOT)
    d = load(f)
    if d is None:
        continue
    if "/items/" in rel.replace(os.sep, "/"):
        walk(d, lambda k, v: check_ref("models", v, ".json", rel) if k == "model" and isinstance(v, str) else None)
    elif "/models/" in rel.replace(os.sep, "/"):
        if isinstance(d.get("parent"), str):
            check_ref("models", d["parent"], ".json", rel)
        for t in (d.get("textures") or {}).values():
            if isinstance(t, str) and not t.startswith("#"):
                check_ref("textures", t, ".png", rel)
    elif "/equipment/" in rel.replace(os.sep, "/"):
        for layer, entries in d.get("layers", {}).items():
            for e in entries:
                check_ref(f"textures/entity/equipment/{layer}", e["texture"], ".png", rel)
    elif "/atlases/" in rel.replace(os.sep, "/"):
        for s in d.get("sources", []):
            for v in (s.get("permutations") or {}).values():
                check_ref("textures/palettes", v, ".png", rel)

# 3. trim palette for the datapack's trim material
trim = load(os.path.join(ROOT, "datapack/data/rosegoldequipment/trim_material/rose_gold.json"))
if trim:
    check_ref("textures/palettes", trim["palette_id"], ".png", "datapack trim_material/rose_gold.json")

# 4. wooden handles replaces existing textures only
for f in files("resourcepack-wooden-handles/assets", ".png"):
    rel = os.path.relpath(f, os.path.join(ROOT, "resourcepack-wooden-handles"))
    if not os.path.exists(os.path.join(ROOT, "resourcepack", rel)):
        problems.append(f"wooden handles: {rel} doesn't replace anything in resourcepack/")

if problems:
    print("\n".join("PROBLEM: " + p for p in problems))
    sys.exit(1)
print(f"packs OK ({len(used_models)} item models checked)")
