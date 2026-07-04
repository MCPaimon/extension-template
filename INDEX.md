# Repository Index

This file is the entry point for any agent working in this repository. Read it first, then [`AGENTS.md`](AGENTS.md) and [`README.md`](README.md).

`extension-template` is a Gradle multi project boilerplate for building custom extensions for the MCAgents plugin. Copy it to start a new extension that supports PaperMC, SpigotMC, and FoliaMC. Keep this index accurate whenever files or directories are added, removed, or restructured.

## Root Files

| Path | Purpose |
|---|---|
| AGENTS.md | Primary agent instruction set; routes to `agents/`. |
| README.md | Project overview and instructions for using the template. |
| LICENSE | License. |
| settings.gradle | Multi project definition and module includes. |
| build.gradle | Root build: shared repositories, publishing, and Shadow JAR merge. |
| gradle.properties | Project identity (`project-name`, `project-group`) and versioning. |
| gradlew / gradlew.bat / gradle/ | Gradle wrapper and version catalog. |

## Modules

| Path | Module | Purpose |
|---|---|---|
| tools/ | `tools` | Example AI tools (`get_player_name`, `get_player_uuid`) shared by all platforms. |
| platforms/papermc/ | `platforms:papermc` | PaperMC entry point (`Template`). |
| platforms/spigotmc/ | `platforms:spigotmc` | SpigotMC entry point (`Template`). |
| platforms/foliamc/ | `platforms:foliamc` | FoliaMC entry point (`Template`). |

## Resources

| Path | Purpose |
|---|---|
| src/main/resources/extension.yml | Extension descriptor: name, version, and per platform main classes. |

## Other Directories

| Path | Purpose |
|---|---|
| agents/ | Specialized agent instructions (credentials, git, gradle, rules). See `agents/README.md`. |
| .devcontainer/ | Development container definition. |
