# Rose Gold Equipment: datapack version (Minecraft 26.3)

The Rose Gold Equipment mod as a **datapack + resource pack**: no mod loader needed, works on vanilla
servers and clients. It's a reduced version of the mod: everything a datapack can do, nothing more.

This branch only holds the packs. The mod itself is on the `mc/*` branches; the packs are made from
`mc/26.3` by `tools/gen_datapack.py`.

## Installing

Get the three .zip files: GitHub -> Actions -> latest "datapack" run -> Artifacts at the bottom
(or zip the folders yourself; zip the folder's *contents*, so `pack.mcmeta` is at the top of the zip).

| File | Where it goes |
|---|---|
| `rosegoldequipment-datapack-26.3-*.zip` | the world's `datapacks` folder (or "Data Packs" when creating a world) |
| `rosegoldequipment-resourcepack-26.3-*.zip` | `resourcepacks`, then turn it on in Options -> Resource Packs. **Needed**: without it every rose gold item is a purple/black square |
| `rosegoldequipment-wooden-handles-26.3-*.zip` | optional, `resourcepacks`, placed **above** the main one: brown wooden tool handles |

On a server you can set the resource pack as the server resource pack so players get it automatically.

`/function rosegoldequipment:give_all` gives every item, `/function rosegoldequipment:showcase` builds
the armor test row (same as the mod's).

## What's in it

| | Datapack | Notes |
|---|---|---|
| Rose gold ingot, nugget, raw rose gold | yes | same recipes; smelt/blast raw rose gold |
| Sword, pickaxe, shovel, axe, hoe, spear | yes | same stats as the mod: 466 durability, mining speed 10, enchantability 45, mines like iron, spear between iron and diamond |
| Helmet, chestplate, leggings, boots | yes | 3/7/5/2 armor, durability 220/320/300/260, own armor texture |
| All 9 foods, incl. omelette -> partial -> crumbs -> bowl and jelly -> half jelly | yes | same hunger, saturation and effects |
| Rose gold as an armor trim material | yes | |
| Rose gold block, raw block, door, trapdoor | **no** | datapacks can't add blocks |
| Settings (sword damage, diamond durability, food effects) | **no** | the mod's default values are built in |
| Creative tab | **no** | use `/function rosegoldequipment:give_all` |

## How it works, and its quirks

A datapack can't add items, so every rose gold item is a vanilla item with its name, model and stats
changed. Things that look at the item's *type* still see the vanilla item:

- **Ingot, nugget, raw rose gold, gilded beetroot, gilded mushroom** are built on operator-only blocks
  (command block, chain command block, repeating command block, structure block, jigsaw) and the other
  foods on the test instance block. Survival players can never get those, so a normal vanilla item can
  never be used in place of a rose gold one in a recipe. In **creative**, an op holding a rose gold
  ingot can place it as a command block.
- **Tools and armor are iron tools and armor underneath.** So:
  - **Don't repair two rose gold tools by putting them together in the crafting grid**: the game makes
    a plain iron tool from them. Use an anvil with rose gold ingots (or Mending).
  - In an anvil, a real iron tool can be used to repair a rose gold one of the same kind (and the other way round).
  - Smelting rose gold tools/armor gives **iron** nuggets.
  - Advancements for iron gear ("Isn't It Iron Pick", "Suit Up") count rose gold gear.
- Other mods/datapacks that check for "iron pickaxe" etc. will see rose gold gear as iron.
- Existing worlds: items from the mod and from the datapack are different items and don't convert into each other.

## Updating the packs after changing the mod

```
python3 tools/gen_datapack.py <path to RGE folder on mc/26.3>
python3 tools/check_packs.py
```

then commit. The GitHub check fails if the packs are out of date with `mc/26.3`, if a model or texture
is missing, or if anything fails to load on a real vanilla 26.3 server.

New Minecraft version: change `MC`, `DATA_FORMAT`, `RESOURCE_FORMAT` at the top of `tools/gen_datapack.py`
and `MC`/`MOD_BRANCH` in `.github/workflows/datapack.yml`, on a new `datapack/<version>` branch.
