# Rose Gold Equipment

A Minecraft mod adding rose gold tools, armor, blocks, trims and food. By IGoByJake.

## Layout

Each loader is its own separate Gradle project — open each folder on its own in IntelliJ.

| Folder      | Loader   |
|-------------|----------|
| `neoforge/` | NeoForge |
| `fabric/`   | Fabric   |

## Branches = Minecraft versions

| Branch                | Minecraft | NeoForge   | Fabric API     | Java | Status |
|-----------------------|-----------|------------|----------------|------|--------|
| `mc/1.21.11`          | 1.21.11   | 21.11.48   | 0.141.6        | 21   | bug-fix release 1.10.0 — needs a build + test |
| `mc/26.1`             | 26.1.2    | 26.1.2.125 | 0.155.3        | 25   | ported — needs a build + test |
| `mc/26.2`             | 26.2      | 26.2.0.66  | 0.161.0        | 25   | ported — needs a build + test |
| `mc/26.3`             | 26.3      | 26.3.0.100 | 0.165.2        | 25   | ported — needs a build + test |
| `archive/1.20-fabric` | 1.20      | –          | –              | 17   | original 2024 code, kept for history |

Each branch was made from the one above it, so `git log` on a branch shows its whole story.

To work on a version: `git switch mc/<version>` (IntelliJ: bottom-right branch menu).

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
