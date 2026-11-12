# Rose Gold Equipment

A Minecraft mod adding rose gold tools, armor, blocks, trims and food. By IGoByJake.

## Layout

Each loader is its own separate Gradle project — open each folder on its own in IntelliJ.

| Folder      | Loader   |
|-------------|----------|
| `neoforge/` | NeoForge |
| `fabric/`   | Fabric   |

## Settings

In game: **Mods -> Rose Gold Equipment -> Config**. NeoForge has this screen built in; on Fabric it needs
[Mod Menu](https://modrinth.com/mod/modmenu) + [Cloth Config](https://modrinth.com/mod/cloth-config)
(optional - without them, edit the file). Files: NeoForge `config/rosegoldequipment-startup.toml`,
Fabric `config/rosegoldequipment.json`.

These are read when the game starts, before the items exist, so **restart Minecraft after changing them**,
and use the same values on a server and on every player's game.

| Setting | Default | |
|---|---|---|
| Sword attack damage | 6 | as shown in the sword's tooltip (iron 6, diamond 7, netherite 8) |
| Diamond durability | off | on = tools 1561 uses instead of 466, armor x33 instead of x20 |
| Food effects | on | off = rose gold foods only fill hunger |

## Branches = Minecraft versions

| Branch                | Minecraft | NeoForge   | Fabric API     | Java | Status |
|-----------------------|-----------|------------|----------------|------|--------|
| `mc/1.21.11`          | 1.21.11   | 21.11.48   | 0.141.6        | 21   | builds + automated tests pass; needs visual check |
| `mc/26.1`             | 26.1.2    | 26.1.2.125 | 0.155.3        | 25   | builds + automated tests pass; needs visual check |
| `mc/26.2`             | 26.2      | 26.2.0.66  | 0.161.0        | 25   | builds + automated tests pass; needs visual check |
| `mc/26.3`             | 26.3      | 26.3.0.100 | 0.165.2        | 25   | builds + automated tests pass; needs visual check |
| `archive/1.20-fabric` | 1.20      | –          | –              | 17   | original 2024 code, kept for history |

Each branch was made from the one above it, so `git log` on a branch shows its whole story.

To work on a version: `git switch mc/<version>` (IntelliJ: bottom-right branch menu).

## Testing
Every push is built and tested automatically: GitHub → **Actions** tab. See `docs/TESTING.md`.

## Docs
- `docs/TESTING.md` — the in-game test script (trims, foods, tools, …)
- `docs/ports/` — one checklist per loader per version, with what changed
- `docs/port-checklist.md` — blank template for the next Minecraft version
- `docs/review-and-port-plan.md` — the original code review

## Porting to the next version
1. `git switch mc/<newest>` then `git switch -c mc/<next>`
2. Copy `docs/port-checklist.md` to `docs/ports/` for each loader and work through it.
3. Re-run the trim asset generator against the new Minecraft jar:
   `python tools/gen_trim_assets.py --vanilla <path to <version>.jar> --out <loader>/src/main/resources --palette <palette png>`
   (palette: `assets/rosegoldequipment/textures/palettes/trim/rose_gold.png`, or `textures/trims/color_palettes/` before 26.3)
