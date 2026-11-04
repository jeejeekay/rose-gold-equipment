# Code review + porting plan

_Last updated 2026-11-04. **Update:** all bugs below are fixed on `mc/1.21.11` and the ports to 26.1, 26.2 and 26.3 are done (not yet built/tested) — see README and `docs/ports/`._

Extra bugs found once the NeoForge code arrived (also fixed): rose gold ingot not usable as a trim material on NeoForge; door/trapdoor dropped nothing on both loaders; NeoForge cookie used beetroot food values; crumbs didn't return the bowl; NeoForge vanilla-armor trim models used the pre-1.21.4 format; leather (3 pieces) and turtle helmet had no rose gold trim icon; leather boots trim model was missing its overlay layer; rose gold armor + rose gold trim showed no trim on the icon.

## What the mod contains (Fabric 1.21.11, mod version 1.9)

| Area | Contents |
|---|---|
| Materials | rose gold ingot, nugget, raw rose gold |
| Blocks | rose gold block, raw rose gold block, door, trapdoor (copper sounds/behaviour) |
| Tools | sword, pickaxe, shovel, axe, hoe: 466 durability, speed 10, enchantability 45, mines like iron |
| Armor | helmet 3 / chest 7 / legs 5 / boots 2, durability multiplier 20, enchantability 45 |
| Food | 9 foods incl. multi-stage ones (omelette → partial → crumbs → bowl, full jelly → half jelly) |
| Trims | rose gold as a trim material; rose gold armor is trimmable |
| Other | own creative tab, en_us + zh_cn, datagen for models/tags/trim material |

Every item and block has a texture and both translations. Good shape overall.

## Bugs / leftovers found (fix on 1.21.11 first, so every port inherits the fix)

1. **Trim colour mismatch.** `ModTrimMaterials.java` says `#b03fe0` (purple), but the generated
   `trim_material/rose_gold.json` the game actually loads says `#031CFC` (blue) and still has the old
   pre-1.21.5 fields `ingredient` and `item_model_index`. That file is stale or hand-edited. Pick the
   colour you want (rose gold is roughly `#B76E79`), set it in Java, rerun datagen.
2. **`incorrect_for_rose_gold_tool.json` references `#tutorialmod:needs_rose_gold_tool`.** Tutorial
   leftover; that tag doesn't exist and `remove` isn't a vanilla tag field. Harmless today; delete the
   `remove` block.
3. **`ExampleMixin` injects into `MinecraftServer.loadWorld` and does nothing.** With
   `defaultRequire: 1`, it will **crash the game** on any version where that method is renamed (likely in
   26.1). Delete the mixin and empty the mixins list (or remove the mixins file entirely).
4. **`fabric.mod.json`**: `"minecraft": "~1.21"` claims every 1.21.x; should be `"~1.21.11"` (or exact per
   version). `contact` links point to Fabric's example mod; point them at your GitHub/Modrinth.
5. **Mappings mismatch**: `yarn_mappings=1.21.10+build.2` with Minecraft 1.21.11. Becomes moot after
   the Mojang-mappings migration below.
6. **Dead code**: `registerBlockWithoutBlockItem`, `ModTags.Items.TRANSFORMABLE_ITEMS`,
   `ModTags.Blocks.NEEDS_ROSE_GOLD_TOOL`, and `ModRegistryDataGenerator` exporting
   enchantment/feature/trim-pattern registries the mod doesn't add. `getName()` returns `""`.
7. **Lowercase class names** (`rosegoldequipment`, `rosegoldequipmentclient`) work but break Java
   convention. Easiest to rename during the mappings migration (also update `fabric.mod.json`).
8. Worth a quick in-game sanity check (may be intentional): food Regeneration effects are
   `Regeneration XI for 6 ticks` (0.3 s); nugget/crumbs/partial/half-jelly aren't in the creative tab.

## Version targets

| Minecraft | Released | Java | Notes |
|---|---|---|---|
| 1.21.11 | Dec 2025 | 21 | current (both loaders) |
| 26.1 (.1, .2) | Mar 24 2026 | 25 | **big jump**: game unobfuscated, Yarn gone |
| 26.2 | Jun 16 2026 | 25 | rendering + GUI renames (Gui→Hud); small impact for this mod |
| 26.3 | Sep 15 2026 | 25 | Fabric API 0.165.0+26.3 / Loader 0.19.5 exist; confirm NeoForge build before starting |

One branch per Minecraft drop: `mc/26.1` targets 26.1.2 (the last 26.1 hotfix) and declares
`26.1–26.1.2` support; then `mc/26.2`, `mc/26.3`, each branched from the previous one.

## Fabric path

**Step 0, on `mc/1.21.11`: Yarn → Mojang mappings.** Fabric requires this before 26.1. Loom has a
`migrateMappings` task that rewrites your source to Mojang names automatically (see Fabric docs
"Migrating Mappings"). Expect renames such as `Item.Settings`→`Item.Properties`,
`RegistryKey`→`ResourceKey`, `RegistryKeys`→`Registries`, `Registries`→`BuiltInRegistries`,
`FoodComponent`→`FoodProperties`, `ConsumableComponent`→`Consumable`, `StatusEffectInstance`→`MobEffectInstance`,
`ItemGroup`→`CreativeModeTab`, `Text`→`Component`, `BlockSoundGroup`→`SoundType`,
`BlockStateModelGenerator`→`BlockModelGenerators`, `Models`→`ModelTemplates`. Build + test still on 1.21.11
so a mistake here isn't mixed up with 26.1 changes. This is also the point where NeoForge and Fabric
code start using the same names, so they become much easier to keep in sync.

**26.1** (Fabric docs "Porting to 26.1"): plugin id `fabric-loom` → `net.fabricmc.fabric-loom`, delete the
`mappings` line, `modImplementation` → `implementation`, Java 21 → 25 (also `compatibilityLevel` in the
mixins file if kept), `remapJar` → `jar`, update Gradle with `./gradlew wrapper --gradle-version latest`.
IntelliJ must be 2025.3+. Then fix compile errors using the Fabric API 26.1 porting guide and the
1.21.11→26.1 primer.

**26.2 / 26.3**: version bumps + whatever the primers flag. This mod has no GUI/rendering code beyond
the door/trapdoor render layer, so these should be small.

## NeoForge path

NeoForge already uses Mojang names, so no mappings step. **26.1**: update ModDevGradle to the 26.1-era
version, `neo_version` to `26.1.2.x`, delete the two `parchment_*` lines (no longer needed), Java 25,
`minecraft_version_range=[26.1,26.2)`, bump the Gradle wrapper (currently 8.9, very old). Also fix
`mod_version` 1.7.8 → match Fabric. Then the same file-by-file compile pass. **26.2/26.3** as Fabric.

## Order of work

1. Get NeoForge 1.21.11 source into git (still missing).
2. Fix bugs 1–4 on `mc/1.21.11`, both loaders; build; quick in-game test.
3. Fabric mappings migration on `mc/1.21.11`.
4. `mc/26.1`: NeoForge first, then Fabric, each with its checklist in `docs/ports/`.
5. `mc/26.2`, then `mc/26.3`.

## Sources
- NeoForge for Minecraft 26.1: https://neoforged.net/news/26.1release/
- Fabric: Porting to 26.1 / 26.2: https://docs.fabricmc.net/develop/porting/
- 26.1 → 26.2 primer: https://a51a17a7.neoforged-docs-previews.pages.dev/primer/docs/26.2/
- 26.3 release: https://www.gamingonlinux.com/2026/09/minecraft-java-edition-26-3-wilderness-bound-update-released/
- Fabric 26.3 component versions (from a published port): https://github.com/simontrost/YUNGs-API/releases/tag/fabric-26.3
