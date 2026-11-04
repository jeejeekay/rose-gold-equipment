# Port checklist — Fabric 1.21.11 → 26.1


**Loader:** Fabric  **From:** 1.21.11  **To:** 26.1  **Branch:** `mc/26.1`

## 1. Before touching code
- [ ] (Fabric only) Yarn → Mojang mappings migration done on mc/1.21.11 first
- [ ] Branch created from the previous version's branch (`git switch mc/<old>` → `git switch -c mc/<new>`)
- [ ] Read the loader's release/porting notes for this version (NeoForge blog "NeoForge for Minecraft X", Fabric docs "Porting to X")
- [ ] Read the vanilla migration primer for this version (ChampionAsh5357's primers, linked from both)
- [ ] Looked up current versions: Minecraft, loader, API (Fabric API), mappings, Gradle plugin (MDG / Loom), Gradle, required Java

## 2. Build files
- [ ] `gradle.properties`: minecraft / loader / API / mappings versions bumped
- [ ] `gradle-wrapper.properties`: Gradle version bumped if the plugin needs it
- [ ] `build.gradle`: plugin version bumped, Java version correct
- [ ] Minecraft version range updated (`neoforge.mods.toml` `minecraft_version_range` / `fabric.mod.json` `depends.minecraft`)
- [ ] Mod version bumped (`mod_version`)
- [ ] `./gradlew build` gets past the configuration step (Minecraft downloads + decompiles)

## 3. Compile errors, file by file
- [ ] Main mod class / entrypoints
- [ ] ModItems (registration, item properties)
- [ ] ModBlocks (blocks, door, trapdoor, block items)
- [ ] ModArmorMaterials / equipment asset
- [ ] ModToolMaterials / ModToolTiers
- [ ] ModFoodComponents / ModFoodProperties
- [ ] ModTrimMaterials
- [ ] ModItemGroups / ModCreativeModeTabs
- [ ] ModTags
- [ ] Datagen providers (models, block tags, item tags, registry/datapack)
- [ ] Mixins (if any)
- [ ] `./gradlew build` succeeds with no errors

## 4. Datagen and resources
- [ ] Ran datagen (`runData` / `runDatagen`)
- [ ] Diffed generated files against the previous version (`git diff`): nothing unexpectedly missing
- [ ] Hand-written JSON (recipes, loot tables, atlases, vanilla item overrides) still matches this version's format

## 5. In-game test (only you can do this part)
- [ ] Game launches, no errors in log mentioning `rosegoldequipment`
- [ ] Every item and block appears in the creative tab with a texture (no purple/black)
- [ ] Blocks: placeable, mine with the right tool, drop themselves; door and trapdoor open/close
- [ ] Recipes: crafting, smelting, blasting all work
- [ ] Tools: correct mining speed/durability; attack damage looks right
- [ ] Armor: renders on the player, correct protection values
- [ ] Trims: vanilla trims on rose gold armor; rose gold trim on vanilla armor
- [ ] Food items: edible, correct effects
- [ ] Languages: en_us and zh_cn names show up

## 6. Release
- [ ] Commit, then tag: `git tag <loader>-<mc>-<mod version>`
- [ ] `git push` and `git push --tags`
- [ ] Built jar from `build/libs/` uploaded (Modrinth / CurseForge)

## Notes / mistakes found
-
