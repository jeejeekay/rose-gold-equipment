# Port checklist — NeoForge 1.21.11 → 26.1


**Loader:** NeoForge  **From:** 1.21.11  **To:** 26.1  **Branch:** `mc/26.1`

## 1. Before touching code
- [x] Branch created from the previous version's branch (`git switch mc/<old>` → `git switch -c mc/<new>`)
- [x] Read the loader's release/porting notes for this version (NeoForge blog "NeoForge for Minecraft X", Fabric docs "Porting to X")
- [x] Read the vanilla migration primer for this version (ChampionAsh5357's primers, linked from both)
- [x] Looked up current versions: Minecraft, loader, API (Fabric API), mappings, Gradle plugin (MDG / Loom), Gradle, required Java

## 2. Build files
- [x] `gradle.properties`: minecraft / loader / API / mappings versions bumped
- [x] `gradle-wrapper.properties`: Gradle version bumped if the plugin needs it
- [x] `build.gradle`: plugin version bumped, Java version correct
- [x] Minecraft version range updated (`neoforge.mods.toml` `minecraft_version_range` / `fabric.mod.json` `depends.minecraft`)
- [x] Mod version bumped (`mod_version`)
- [x] `./gradlew build` gets past the configuration step (Minecraft downloads + decompiles)

## 3. Compile errors, file by file
- [x] Main mod class / entrypoints
- [x] ModItems (registration, item properties)
- [x] ModBlocks (blocks, door, trapdoor, block items)
- [x] ModArmorMaterials / equipment asset
- [x] ModToolMaterials / ModToolTiers
- [x] ModFoodComponents / ModFoodProperties
- [x] ModTrimMaterials
- [x] ModItemGroups / ModCreativeModeTabs
- [x] ModTags
- [x] Datagen providers (models, block tags, item tags, registry/datapack)
- [x] Mixins (if any)
- [x] `./gradlew build` succeeds with no errors

## 4. Datagen and resources
- [x] Ran datagen (`runData` / `runDatagen`)
- [x] Diffed generated files against the previous version (`git diff`): nothing unexpectedly missing
- [x] Hand-written JSON (recipes, loot tables, atlases, vanilla item overrides) still matches this version's format

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

## Notes / what changed
- NeoForge 26.1.2.125, ModDevGradle 2.0.141, Gradle 9.2.1, Java 25
- Parchment removed (26.1 ships official parameter names); mods.toml no longer lists modLoader/loaderVersion
- Door/trapdoor render-layer code deleted (26.1 detects cutout from the texture)
- Trim datagen helper: textures are `Material` objects now
- New `humanoid_baby` armor layer + texture (recoloured from vanilla baby gold armor)

**Status:** builds, datagen matches, all automated GameTests pass (GitHub Actions).
Next: the 2-minute visual pass in `docs/TESTING.md` (`/function rosegoldequipment:showcase`).
