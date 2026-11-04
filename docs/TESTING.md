# In-game test script

Run this once per loader per Minecraft version (`./gradlew runClient`), in a new
**Creative** world with cheats on. Tick the matching boxes in `docs/ports/<loader>-<version>.md`.

## 0. Before launching
- `./gradlew build` succeeds.
- Run datagen (`./gradlew runData` on NeoForge, `./gradlew runDatagen` on Fabric), then
  `git diff` — the generated files should barely change (they were hand-updated to match).
- Check the log for lines mentioning `rosegoldequipment` with `ERROR` or `WARN`.

## 1. Items & blocks
- Open the **Rose Gold Equipment** creative tab: every icon has a texture (no purple/black squares).
- Ingot, nugget, raw rose gold also appear in **Ingredients**; the two blocks in **Building Blocks**.
- Names show correctly; switch language to 简体中文 and check again.

## 2. Blocks
- Place rose gold block, raw block, door, trapdoor.
- Mine each **in Survival** (`/gamemode survival`) with a stone pickaxe → no drop for the blocks;
  with an iron (or rose gold) pickaxe → each drops itself. Door drops **one** door.
- Door and trapdoor open/close by hand (copper behaviour) and the see-through parts are see-through.

## 3. Recipes (Survival or crafting book)
- 2 copper + 2 gold ingots → 2 raw rose gold. Smelt raw → ingot (furnace), blast it (faster).
- Ingot ↔ nuggets, ingot ↔ block, raw ↔ raw block, door, trapdoor, all 5 tools, all 4 armor pieces.
- Foods: gilded beetroot / cookie / mushrooms (each mushroom type), omelette, jelly, rosey stew.

## 4. Tools
- Hover each tool: attack damage/speed shown. Pickaxe mines iron and diamond ore (like iron) but gets **no drop** from obsidian.
- Axe strips a log, shovel makes a dirt path, hoe tills dirt (important on 26.3 — this changed).
- Repair a damaged tool with a rose gold ingot in an anvil.

## 5. Armor
- Wear the full set: renders on the player; armor bar = 3+7+5+2 = 17 points.
- `/summon zombie ~ ~ ~ {IsBaby:1b}` and give it a helmet (or drop one for it to pick up) —
  on 26.1+ it should render on the baby.
- Enchant armor at a table / with books; repair in an anvil with an ingot.

## 6. Trims — the important part
Get templates: `/give @s coast_armor_trim_smithing_template` (any pattern).
1. **Rose gold armor + vanilla material** (e.g. diamond): icon shows the trim; worn armor shows it.
2. **Vanilla armor + rose gold ingot**: try iron, gold, diamond, netherite, chainmail, copper,
   **leather (dye it too)** and the **turtle helmet**. Each icon and the worn armor show a pink trim.
3. **Rose gold armor + rose gold ingot**: icon and worn armor both show the trim.
4. Hover a trimmed piece: the tooltip says the rose gold material name in **light rose gold** text.

## 7. Foods (Survival, take some damage first)
| Food | Expect |
|---|---|
| Rose gilded beetroot | quick heal burst (3 hearts) + Strength I 20s |
| Rosey beetroot stew | Instant Health III, Strength II 60s, Haste II 60s, Regen II 20s; leaves a bowl |
| Rose mushroom omelette | heal burst + Haste II 40s → leaves *partial* → *crumbs* → bowl |
| Rose full jelly | heal burst + Speed II 40s → leaves *half jelly* |
| Rose gilded mushroom / cookie | fast to eat, small heal burst (cookie also Speed I 15s) |
All foods can be eaten even when not hungry.

## 8. Write down anything odd
Add it under "Notes" in the version's checklist, commit, push.
