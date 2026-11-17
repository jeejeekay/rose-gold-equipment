#!/usr/bin/env python3
"""
Builds the Rose Gold Equipment DATAPACK + RESOURCE PACKS for one Minecraft version from the mod's source.

    python3 tools/gen_datapack.py <path to an RGE checkout on the matching mc/<version> branch>

Writes (and replaces) these folders next to tools/:
    datapack/                       the data pack (recipes, item stats, trim material, functions)
    resourcepack/                   textures, models and names (needed - without it items show as missing textures)
    resourcepack-wooden-handles/    optional: tools with normal brown wooden handles (put it ABOVE resourcepack)

How it works: a datapack can't add new items, so every rose gold item is a VANILLA item with its
stats, name and model changed (item components). The vanilla item each one is built on is in BASE below.
Items that are used IN a recipe (ingot, nugget, raw rose gold, gilded beetroot, gilded mushroom) are built
on operator-only blocks (command blocks etc.) that survival players can never get, so a normal vanilla
item can never stand in for them in a recipe. Operator blocks can't be placed outside creative, and an
edible one is eaten instead of placed.
"""
import json, os, shutil, sys

# ------------------------------------------------------------------------------------------------ version
MC = "26.3"
DATA_FORMAT = 121          # data pack format of this Minecraft version
RESOURCE_FORMAT = 97       # resource pack format (26.3 is 97.1; a whole number here means "any 97.x")
VERSION = "1.11.0"         # the mod version this pack matches
NS = "rosegoldequipment"

HERE = os.path.dirname(os.path.abspath(__file__))
ROOT = os.path.dirname(HERE)
OUT_DATA = os.path.join(ROOT, "datapack")
OUT_RES = os.path.join(ROOT, "resourcepack")
OUT_WOOD = os.path.join(ROOT, "resourcepack-wooden-handles")

# ------------------------------------------------------------------------------------------------ items
# The vanilla item each rose gold item is built on.
BASE = {
    # used in recipes -> each needs its OWN item that survival players can never get
    "rose_gold_ingot": "minecraft:command_block",
    "rose_gold_nugget": "minecraft:chain_command_block",
    "raw_rose_gold": "minecraft:repeating_command_block",
    "rose_gilded_beetroot": "minecraft:structure_block",
    "rose_gilded_mushroom": "minecraft:jigsaw",
    # never used in a recipe -> can share one
    "rose_gilded_cookie": "minecraft:test_instance_block",
    "rosey_beetroot_stew": "minecraft:test_instance_block",
    "rose_mushroom_omelette": "minecraft:test_instance_block",
    "rose_mushroom_partial": "minecraft:test_instance_block",
    "rose_mushroom_crumbs": "minecraft:test_instance_block",
    "rose_full_jelly": "minecraft:test_instance_block",
    "rose_half_jelly": "minecraft:test_instance_block",
    # tools and armor: the iron version, so axes strip logs, hoes till, the spear is a spear, enchanting works
    "rose_golden_sword": "minecraft:iron_sword",
    "rose_golden_spear": "minecraft:iron_spear",
    "rose_golden_pickaxe": "minecraft:iron_pickaxe",
    "rose_golden_shovel": "minecraft:iron_shovel",
    "rose_golden_axe": "minecraft:iron_axe",
    "rose_golden_hoe": "minecraft:iron_hoe",
    "rose_golden_helmet": "minecraft:iron_helmet",
    "rose_golden_chestplate": "minecraft:iron_chestplate",
    "rose_golden_leggings": "minecraft:iron_leggings",
    "rose_golden_boots": "minecraft:iron_boots",
}
REPAIR = BASE["rose_gold_ingot"]

# Mod content a datapack can't make (no new blocks).
LEFT_OUT = ["rose_gold_block", "raw_rose_gold_block", "rose_gold_door", "rose_gold_trapdoor"]

# Stats, copied from the mod (item/ModItems.java, ModToolTiers.java, ModArmorMaterials.java, ModFoodProperties.java).
TOOL_DURABILITY = 466        # mod setting diamond_durability=false
TOOL_SPEED = 10.0
ENCHANTABILITY = 45
ARMOR = {  # name: (slot, armor points, durability = 20 x vanilla base)
    "rose_golden_helmet": ("head", 3, 20 * 11),
    "rose_golden_chestplate": ("chest", 7, 20 * 16),
    "rose_golden_leggings": ("legs", 5, 20 * 15),
    "rose_golden_boots": ("feet", 2, 20 * 13),
}
MINEABLE = {"rose_golden_pickaxe": "pickaxe", "rose_golden_shovel": "shovel", "rose_golden_axe": "axe", "rose_golden_hoe": "hoe"}

REGEN_BURST = ("regeneration", 6, 10)
OMELETTE_FX = [REGEN_BURST, ("haste", 800, 1)]
JELLY_FX = [REGEN_BURST, ("speed", 800, 1)]
FOOD = {  # name: (nutrition, saturation modifier, effects (id, ticks, amplifier), eat seconds, stack size, left behind)
    "rose_gilded_beetroot": (6, 0.6, [REGEN_BURST, ("strength", 400, 0)], 1.6, 64, None),
    "rosey_beetroot_stew": (14, 1.0, [("instant_health", 1, 2), ("strength", 1200, 1), ("haste", 1200, 1), ("regeneration", 400, 1)], 1.6, 1, "minecraft:bowl"),
    "rose_gilded_cookie": (2, 0.4, [("regeneration", 2, 10), ("speed", 300, 0)], 0.8, 64, None),
    "rose_gilded_mushroom": (2, 0.2, [("regeneration", 2, 10)], 0.8, 64, None),
    "rose_mushroom_omelette": (5, 0.4, OMELETTE_FX, 1.6, 1, "rose_mushroom_partial"),
    "rose_mushroom_partial": (5, 0.4, OMELETTE_FX, 1.6, 1, "rose_mushroom_crumbs"),
    "rose_mushroom_crumbs": (5, 0.4, OMELETTE_FX, 1.6, 1, "minecraft:bowl"),
    "rose_full_jelly": (8, 1.2, JELLY_FX, 1.6, 1, "rose_half_jelly"),
    "rose_half_jelly": (8, 1.2, JELLY_FX, 1.6, 1, None),
}


def names(mod):
    with open(os.path.join(mod, "neoforge/src/main/resources/assets", NS, "lang/en_us.json"), encoding="utf-8") as f:
        return json.load(f)


def components(item, lang):
    """The item components that turn BASE[item] into the rose gold item."""
    c = {
        "minecraft:item_name": {"translate": f"item.{NS}.{item}", "fallback": lang[f"item.{NS}.{item}"]},
        "minecraft:item_model": f"{NS}:{item}",
    }
    if BASE[item].endswith(("command_block", "structure_block", "jigsaw", "test_instance_block")):
        c["minecraft:rarity"] = "common"  # operator blocks have a purple name
    if item == "rose_gold_ingot":
        c["minecraft:provides_trim_material"] = f"{NS}:rose_gold"
    if item in FOOD:
        nutrition, sat_mod, effects, seconds, stack, left = FOOD[item]
        c["minecraft:max_stack_size"] = stack
        c["minecraft:food"] = {"nutrition": nutrition, "saturation": round(nutrition * sat_mod * 2, 4), "can_always_eat": True}
        c["minecraft:consumable"] = {
            "consume_seconds": seconds, "animation": "eat", "sound": "minecraft:entity.generic.eat",
            "has_consume_particles": True,
            "on_consume_effects": [{"type": "minecraft:apply_effects", "probability": 1.0, "effects": [
                {"id": f"minecraft:{e}", "duration": d, "amplifier": a} for e, d, a in effects]}]}
        if left:
            c["minecraft:use_remainder"] = {"id": left} if left.startswith("minecraft:") else stack_of(left, lang)
    if item.startswith("rose_golden_"):
        c["minecraft:max_damage"] = ARMOR[item][2] if item in ARMOR else TOOL_DURABILITY
        c["minecraft:enchantable"] = {"value": ENCHANTABILITY}
        c["minecraft:repairable"] = {"items": REPAIR}
    if item in MINEABLE:
        c["minecraft:tool"] = {"rules": [
            {"blocks": f"#{NS}:incorrect_for_rose_gold_tool", "correct_for_drops": False},
            {"blocks": f"#minecraft:mineable/{MINEABLE[item]}", "correct_for_drops": True, "speed": TOOL_SPEED}]}
    # sword: same damage/speed/cobweb rules as iron, so only durability etc. change
    if item == "rose_golden_spear":
        # jab 3 damage, 1.0 s cooldown; charge x1.0 after 0.55 s (11 ticks); dismount 2.75 s (speed 10.5),
        # knockback until 6.75 s (5.1), damage until 11 s (relative speed 4.6). Between the iron and diamond spears.
        c["minecraft:attribute_modifiers"] = [
            {"type": "minecraft:attack_damage", "amount": 2.0, "id": "minecraft:base_attack_damage", "operation": "add_value", "slot": "mainhand"},
            {"type": "minecraft:attack_speed", "amount": -3.0, "id": "minecraft:base_attack_speed", "operation": "add_value", "slot": "mainhand"}]
        c["minecraft:attack_animation"] = {"type": "stab", "duration": 20}
        c["minecraft:kinetic_weapon"] = {
            "delay_ticks": 11, "damage_multiplier": 1.0, "forward_movement": 0.38,
            "dismount_conditions": {"max_duration_ticks": 55, "min_speed": 10.5},
            "knockback_conditions": {"max_duration_ticks": 135, "min_speed": 5.1},
            "damage_conditions": {"max_duration_ticks": 220, "min_relative_speed": 4.6},
            "sound": "minecraft:item.spear.use", "hit_sound": "minecraft:item.spear.hit"}
    if item in ARMOR:
        slot, points, _ = ARMOR[item]
        piece = item.split("_")[-1]
        c["minecraft:attribute_modifiers"] = [
            {"type": "minecraft:armor", "amount": float(points), "id": f"minecraft:armor.{piece}", "operation": "add_value", "slot": slot},
            {"type": "minecraft:armor_toughness", "amount": 0.0, "id": f"minecraft:armor.{piece}", "operation": "add_value", "slot": slot}]
        c["minecraft:equippable"] = {"slot": slot, "asset_id": f"{NS}:rose_gold", "equip_sound": "minecraft:item.armor.equip_gold"}
    return c


def stack_of(item, lang, count=1):
    s = {"id": BASE[item], "components": components(item, lang)}
    if count != 1:
        s["count"] = count
    return s


# ------------------------------------------------------------------------------------------------ writing
def write(path, data):
    os.makedirs(os.path.dirname(path), exist_ok=True)
    with open(path, "w", encoding="utf-8", newline="\n") as f:
        if isinstance(data, str):
            f.write(data)
        else:
            json.dump(data, f, indent=2, ensure_ascii=False)
            f.write("\n")


def fresh(folder):
    if os.path.isdir(folder):
        shutil.rmtree(folder)
    os.makedirs(folder)


def mod_id(x):
    return isinstance(x, str) and x.startswith(NS + ":")


def convert_recipe(r, lang):
    """Mod recipe -> datapack recipe: mod items in ingredients become their base item; the result gets its components."""
    def ing(x):
        if isinstance(x, list):
            return [ing(i) for i in x]
        if mod_id(x):
            return BASE[x.split(":")[1]]
        return x
    r = json.loads(json.dumps(r))
    for k in ("ingredient", "base", "addition", "template"):
        if k in r:
            r[k] = ing(r[k])
    if "ingredients" in r:
        r["ingredients"] = [ing(i) for i in r["ingredients"]]
    if "key" in r:
        r["key"] = {k: ing(v) for k, v in r["key"].items()}
    res = r["result"]
    if mod_id(res.get("id")):
        r["result"] = stack_of(res["id"].split(":")[1], lang, res.get("count", 1))
    if r.get("group", "").startswith(NS + ":") or r.get("group") == "rose_gold_ingot":
        r["group"] = f"{NS}:rose_gold_ingot"
    return r


def build_datapack(mod, lang):
    fresh(OUT_DATA)
    d = lambda *p: os.path.join(OUT_DATA, *p)
    write(d("pack.mcmeta"), {"pack": {
        "description": [{"text": "Rose Gold Equipment ", "color": "#FFBBB6"}, {"text": f"datapack {VERSION} for {MC}\nNeeds the resource pack too", "color": "gray"}],
        "min_format": DATA_FORMAT, "max_format": DATA_FORMAT}})

    src = os.path.join(mod, "neoforge/src/main/resources/data", NS, "recipe")
    skipped = []
    for fn in sorted(os.listdir(src)):
        with open(os.path.join(src, fn), encoding="utf-8") as f:
            r = json.load(f)
        text = json.dumps(r)
        if any(f"{NS}:{b}" in text for b in LEFT_OUT):
            skipped.append(fn)
            continue
        write(d("data", NS, "recipe", fn), convert_recipe(r, lang))

    gen = os.path.join(mod, "neoforge/src/generated/resources/data")
    with open(os.path.join(gen, NS, "trim_material/rose_gold.json"), encoding="utf-8") as f:
        trim = json.load(f)
    trim["description"]["fallback"] = lang[f"trim_material.{NS}.rose_gold"]
    write(d("data", NS, "trim_material", "rose_gold.json"), trim)
    write(d("data", NS, "tags/block/incorrect_for_rose_gold_tool.json"), {"values": ["#minecraft:incorrect_for_iron_tool"]})
    write(d("data/minecraft/tags/item/trim_materials.json"), {"values": [BASE["rose_gold_ingot"]]})

    # One loot table per item (26.3 format: "modifier" with "type"; older versions used "functions" with "function"): "/loot give @s loot rosegoldequipment:item/<name>" gives it.
    for item in BASE:
        write(d("data", NS, "loot_table/item", item + ".json"), {"type": "minecraft:command", "pools": [{"rolls": 1, "entries": [
            {"type": "minecraft:item", "name": BASE[item], "modifier": {"type": "minecraft:set_components", "components": components(item, lang)}}]}]})
    write(d("data", NS, "function/give_all.mcfunction"),
          "# Gives every rose gold item. /function rosegoldequipment:give_all\n"
          + "".join(f"loot give @s loot {NS}:item/{i}\n" for i in BASE))

    # Item modifiers for the showcase: put a trim on a piece already worn.
    trims = ["rosegoldequipment:rose_gold", "minecraft:quartz", "minecraft:iron", "minecraft:netherite", "minecraft:redstone", "minecraft:copper",
             "minecraft:gold", "minecraft:emerald", "minecraft:diamond", "minecraft:lapis", "minecraft:amethyst", "minecraft:resin"]
    for t in trims:
        write(d("data", NS, "item_modifier/trim", t.split(":")[1] + ".json"),
              {"type": "minecraft:set_components", "components": {"minecraft:trim": {"material": t, "pattern": "minecraft:coast"}}})
    write(d("data", NS, "function/showcase.mcfunction"), showcase(trims))
    write(d("data", NS, "function/test/selftest.mcfunction"), selftest())
    return skipped


def showcase(trims):
    out = ["# Rose Gold Equipment visual check. Run in a Creative world: /function rosegoldequipment:showcase",
           "# Look for: purple/black textures, missing trims, wrong colours. Builds east (+X) of where you stand.",
           "fill ~-1 ~-1 ~-2 ~40 ~-1 ~10 minecraft:smooth_stone", "fill ~-1 ~ ~-2 ~40 ~4 ~10 minecraft:air",
           "kill @e[type=minecraft:armor_stand,distance=..60]", "# Row 1: vanilla armor with a rose gold trim"]
    for i, m in enumerate(["leather", "chainmail", "iron", "golden", "diamond", "netherite", "copper"]):
        eq = ",".join(f'{s}:{{id:"minecraft:{m}_{p}",count:1,components:{{"minecraft:trim":{{material:"{NS}:rose_gold",pattern:"minecraft:coast"}}}}}}'
                      for s, p in [("head", "helmet"), ("chest", "chestplate"), ("legs", "leggings"), ("feet", "boots")])
        out.append(f'summon minecraft:armor_stand ~{i * 3} ~ ~0 {{NoGravity:1b,ShowArms:1b,CustomNameVisible:1b,CustomName:"{m} + rose gold trim",Rotation:[180f,0f],equipment:{{{eq}}}}}')
    out.append("# Row 2: rose gold armor, untrimmed and with every trim material")
    for i, t in enumerate([None] + trims):
        label = "rose gold, no trim" if t is None else f"rose gold + {t.split(':')[1].replace('_', ' ')} trim"
        out.append(f'summon minecraft:armor_stand ~{i * 3} ~ ~6 {{NoGravity:1b,ShowArms:1b,CustomNameVisible:1b,CustomName:"{label}",Rotation:[180f,0f],Tags:["rge_new"]}}')
        for slot, piece in [("head", "helmet"), ("chest", "chestplate"), ("legs", "leggings"), ("feet", "boots")]:
            out.append(f"loot replace entity @n[tag=rge_new] armor.{slot} loot {NS}:item/rose_golden_{piece}")
            if t:
                out.append(f"item modify entity @n[tag=rge_new] armor.{slot} {NS}:trim/{t.split(':')[1]}")
        out.append("tag @n[tag=rge_new] remove rge_new")
    out += ["# Every item", "clear @s", f"function {NS}:give_all",
            "give @s minecraft:coast_armor_trim_smithing_template 4", "give @s minecraft:smithing_table",
            'tellraw @s {"text":"Rose Gold showcase built. Check every armor stand and your inventory icons.","color":"#FFBBB6"}']
    return "\n".join(out) + "\n"


def selftest():
    """Run from the server console by CI: makes every item and says SELFTEST-OK <name> for each one that comes out right."""
    out = ["# Used by the automatic test (GitHub Actions). Harmless to run yourself.", "forceload add 0 0"]
    for item in BASE:
        out += ["kill @e[type=minecraft:item,x=0,y=-64,z=0,distance=..400]",
                f"execute positioned 0 100 0 run loot spawn ~ ~ ~ loot {NS}:item/{item}",
                f'execute if entity @e[type=minecraft:item,x=0,y=-64,z=0,distance=..400,nbt={{Item:{{id:"{BASE[item]}",components:{{"minecraft:item_model":"{NS}:{item}"}}}}}}] run say SELFTEST-OK {item}']
    out += ["kill @e[type=minecraft:item,x=0,y=-64,z=0,distance=..400]", "forceload remove 0 0", f"say SELFTEST-DONE {len(BASE)}"]
    return "\n".join(out) + "\n"


# ------------------------------------------------------------------------------------------------ resource packs
def is_block_asset(rel):
    return ("/blockstates/" in rel or "/models/block/" in rel or "/textures/block/" in rel
            or any(os.path.splitext(os.path.basename(rel))[0] == b for b in LEFT_OUT))


def build_resourcepacks(mod, lang):
    fresh(OUT_RES)
    icon = os.path.join(mod, "neoforge/src/main/resources/assets", NS, "icon.png")
    write(os.path.join(OUT_RES, "pack.mcmeta"), {"pack": {
        "description": [{"text": "Rose Gold Equipment ", "color": "#FFBBB6"}, {"text": f"textures {VERSION} for {MC}\nUse with the datapack", "color": "gray"}],
        "min_format": RESOURCE_FORMAT, "max_format": RESOURCE_FORMAT}})
    shutil.copyfile(icon, os.path.join(OUT_RES, "pack.png"))
    copied = 0
    for top in ("neoforge/src/main/resources/assets", "neoforge/src/generated/resources/assets"):
        base = os.path.join(mod, top)
        for dirpath, _, files in os.walk(base):
            for fn in files:
                src = os.path.join(dirpath, fn)
                rel = os.path.relpath(src, base).replace(os.sep, "/")
                if is_block_asset("/" + rel) or rel == f"{NS}/icon.png" or "/lang/" in "/" + rel:
                    continue
                dst = os.path.join(OUT_RES, "assets", rel)
                os.makedirs(os.path.dirname(dst), exist_ok=True)
                shutil.copyfile(src, dst)
                copied += 1
    # Names: only the keys the datapack uses (no blocks, settings screen or creative tab).
    keep = lambda k: k.startswith(("item.", "trim_material.")) and not any(b in k for b in LEFT_OUT)
    for code in ("en_us", "zh_cn"):
        with open(os.path.join(mod, "neoforge/src/main/resources/assets", NS, f"lang/{code}.json"), encoding="utf-8") as f:
            write(os.path.join(OUT_RES, "assets", NS, f"lang/{code}.json"), {k: v for k, v in json.load(f).items() if keep(k)})

    fresh(OUT_WOOD)
    wood = os.path.join(mod, "neoforge/src/main/resources/resourcepacks/wooden_handles")
    shutil.copytree(os.path.join(wood, "assets"), os.path.join(OUT_WOOD, "assets"))
    shutil.copyfile(icon, os.path.join(OUT_WOOD, "pack.png"))
    write(os.path.join(OUT_WOOD, "pack.mcmeta"), {"pack": {
        "description": "Rose gold tools with normal wooden handles. Put it above the Rose Gold Equipment pack.",
        "min_format": RESOURCE_FORMAT, "max_format": RESOURCE_FORMAT}})
    return copied


if __name__ == "__main__":
    if len(sys.argv) != 2:
        sys.exit(__doc__)
    mod = sys.argv[1]
    lang = names(mod)
    skipped = build_datapack(mod, lang)
    copied = build_resourcepacks(mod, lang)
    print(f"datapack: {len(BASE)} items; left out recipes: {', '.join(skipped)}")
    print(f"resource pack: {copied} files copied from the mod")
