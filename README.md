# Rose Gold Equipment

A Minecraft mod adding rose gold tools, armor, blocks, trims and food. By IGoByJake.

## Layout

Each loader is its own separate Gradle project. They are **not** combined; open each folder
on its own in IntelliJ.

| Folder      | Loader   |
|-------------|----------|
| `neoforge/` | NeoForge |
| `fabric/`   | Fabric   |

## Branches = Minecraft versions

| Branch               | What's on it                         |
|----------------------|--------------------------------------|
| `mc/1.21.11`         | Current release, both loaders        |
| `mc/26.1`, `mc/26.2` | Ports (created as they're worked on) |
| `archive/1.20-fabric`| The original 2024 Fabric 1.20 code   |

To work on a version: `git switch mc/<version>`.

## Porting

Every port gets a checklist copied from `docs/port-checklist.md` into `docs/ports/`.
