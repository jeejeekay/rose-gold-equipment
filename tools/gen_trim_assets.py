#!/usr/bin/env python3
"""
Generate the resource files that let rose gold be used as an armor-trim material
on VANILLA armor (iron, gold, leather, turtle helmet, ...).

Why this exists
---------------
Minecraft only knows how to draw trims for the materials it ships with. For a
modded trim material, three things have to be added by hand, and the exact
format changes between Minecraft versions:

  1. Atlas entries   - tell the game to build rose-gold-coloured trim sprites
                       (assets/minecraft/atlases/*.json)
  2. Item definitions - add a "rose gold" case to every vanilla armor item's
                       icon selector (assets/minecraft/items/<armor>.json)
  3. Item models     - the actual "iron_helmet + rose gold trim" icon models
                       (assets/rosegoldequipment/models/item/<armor>_rose_gold_trim.json)
  plus the palette PNG in whatever folder that version expects.

Rather than hand-editing ~60 JSON files per version, this script copies vanilla's
own "quartz" trim files for the target version and swaps quartz -> rose_gold.
That way the output always matches that version's format exactly.

Rose gold ARMOR (our own items) is handled in datagen instead
(datagen/TrimmedArmorModels.java), not here.

Usage
-----
    python3 tools/gen_trim_assets.py --vanilla <minecraft.jar or extracted folder> \
        --out <loader>/src/main/resources --palette <rose_gold palette png>

Where to find the jar on Windows:
    %APPDATA%\\.minecraft\\versions\\<version>\\<version>.jar
(launch that version once in the normal launcher so it's downloaded).

Run it for each loader folder (fabric/ and neoforge/) whenever you port to a new
Minecraft version, then commit the result.
"""
import argparse
import copy
import json
import os
import re
import sys
import zipfile

ARMOR_RE = re.compile(r"^assets/minecraft/items/([a-z0-9_]+)\.json$")


class Vanilla:
    """Read-only view over either a client .jar or an extracted folder."""

    def __init__(self, path):
        self.zip = zipfile.ZipFile(path) if os.path.isfile(path) else None
        self.root = None if self.zip else path

    def names(self):
        if self.zip:
            return self.zip.namelist()
        out = []
        for dirpath, _, files in os.walk(self.root):
            for f in files:
                out.append(os.path.relpath(os.path.join(dirpath, f), self.root).replace(os.sep, "/"))
        return out

    def exists(self, name):
        if self.zip:
            try:
                self.zip.getinfo(name)
                return True
            except KeyError:
                return False
        return os.path.isfile(os.path.join(self.root, name))

    def json(self, name):
        if self.zip:
            return json.loads(self.zip.read(name))
        with open(os.path.join(self.root, name), encoding="utf-8") as fh:
            return json.load(fh)


def write_json(path, data):
    os.makedirs(os.path.dirname(path), exist_ok=True)
    with open(path, "w", encoding="utf-8", newline="\n") as fh:
        json.dump(data, fh, indent=2)
        fh.write("\n")


def swap_material(value, modid, material):
    """'minecraft:trims/color_palettes/quartz' -> 'rosegoldequipment:trims/color_palettes/rose_gold'."""
    ns, path = value.split(":", 1) if ":" in value else ("minecraft", value)
    head, _, last = path.rpartition("/")
    assert last == "quartz", value
    return f"{modid}:{head + '/' if head else ''}{material}"


def find_trim_select(node):
    """Find the {"type": "minecraft:select", "property": "minecraft:trim_material"} block."""
    if isinstance(node, dict):
        if node.get("type") == "minecraft:select" and node.get("property") == "minecraft:trim_material":
            return node
        for v in node.values():
            hit = find_trim_select(v)
            if hit:
                return hit
    elif isinstance(node, list):
        for v in node:
            hit = find_trim_select(v)
            if hit:
                return hit
    return None


def main():
    ap = argparse.ArgumentParser(description=__doc__, formatter_class=argparse.RawDescriptionHelpFormatter)
    ap.add_argument("--vanilla", required=True, help="Minecraft client .jar, or a folder containing assets/minecraft/...")
    ap.add_argument("--out", required=True, help="resources folder to write into (e.g. neoforge/src/main/resources)")
    ap.add_argument("--palette", required=True, help="8x1 rose gold palette PNG")
    ap.add_argument("--modid", default="rosegoldequipment")
    ap.add_argument("--material", default="rose_gold")
    args = ap.parse_args()

    v = Vanilla(args.vanilla)
    names = v.names()
    when_value = f"{args.modid}:{args.material}"
    written = []

    # 1) Atlases + palette location ------------------------------------------------
    palette_dests = set()
    for name in sorted(n for n in names if n.startswith("assets/minecraft/atlases/") and n.endswith(".json")):
        atlas = v.json(name)
        sources = []
        for src in atlas.get("sources", []):
            if "paletted_permutations" in src.get("type", "") and "quartz" in src.get("permutations", {}):
                new_value = swap_material(src["permutations"]["quartz"], args.modid, args.material)
                sources.append({
                    "type": src["type"],
                    "palette_key": src["palette_key"],
                    "permutations": {args.material: new_value},
                    "textures": src["textures"],
                })
                # Where does vanilla keep the quartz palette PNG for this value?
                qpath = src["permutations"]["quartz"].split(":", 1)[-1]
                for prefix in ("textures/", "textures/palettes/"):
                    if v.exists(f"assets/minecraft/{prefix}{qpath}.png"):
                        palette_dests.add(f"assets/{args.modid}/{prefix}{new_value.split(':', 1)[1]}.png")
                        break
                else:
                    sys.exit(f"Could not find vanilla palette file for {src['permutations']['quartz']}")
        if sources:
            out = os.path.join(args.out, name)
            write_json(out, {"sources": sources})
            written.append(out)

    # 26.3+: entity trims use textures/palettes/<palette_id>.png with no atlas entry.
    if v.exists("assets/minecraft/textures/palettes/trim/quartz.png"):
        palette_dests.add(f"assets/{args.modid}/textures/palettes/trim/{args.material}.png")

    with open(args.palette, "rb") as fh:
        palette_bytes = fh.read()
    for dest in sorted(palette_dests):
        out = os.path.join(args.out, dest)
        os.makedirs(os.path.dirname(out), exist_ok=True)
        with open(out, "wb") as fh:
            fh.write(palette_bytes)
        written.append(out)

    # 2) + 3) Vanilla armor item definitions and trim models ------------------------
    armor_count = 0
    for name in sorted(names):
        m = ARMOR_RE.match(name)
        if not m:
            continue
        item_id = m.group(1)
        definition = v.json(name)
        select = find_trim_select(definition)
        if not select:
            continue
        cases = select["cases"]
        cases[:] = [c for c in cases if c.get("when") != when_value]  # idempotent
        quartz = next(c for c in cases if c.get("when") == "minecraft:quartz")
        new_case = copy.deepcopy(quartz)
        new_case["when"] = when_value

        # Point the copied case at our new model.
        model_id = f"{args.modid}:item/{item_id}_{args.material}_trim"

        def retarget(node):
            if isinstance(node, dict):
                if node.get("type") == "minecraft:model" and str(node.get("model", "")).endswith("_quartz_trim"):
                    quartz_model = node["model"]
                    node["model"] = model_id
                    return quartz_model
                for val in node.values():
                    found = retarget(val)
                    if found:
                        return found
            return None

        quartz_model = retarget(new_case["model"])
        if not quartz_model:
            sys.exit(f"{item_id}: could not find quartz trim model in {quartz}")
        cases.append(new_case)
        out = os.path.join(args.out, name)
        write_json(out, definition)
        written.append(out)

        # Model: vanilla quartz model with the trim layer swapped to rose gold.
        qm_path = "assets/minecraft/models/item/" + quartz_model.split(":", 1)[-1].split("/", 1)[1] + ".json"
        model = v.json(qm_path)
        for key, tex in model.get("textures", {}).items():
            if isinstance(tex, str) and tex.endswith("_quartz") and "trims/items/" in tex:
                model["textures"][key] = tex[: -len("quartz")] + args.material
        out = os.path.join(args.out, f"assets/{args.modid}/models/item/{item_id}_{args.material}_trim.json")
        write_json(out, model)
        written.append(out)
        armor_count += 1

    print(f"Patched {armor_count} vanilla armor items; wrote {len(written)} files into {args.out}")


if __name__ == "__main__":
    main()
