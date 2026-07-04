# MCPaimon Template Extension

This project is the boilerplate for developers creating custom extensions and tools for the MCAgents plugin. It mirrors the structure of the [Core extension](https://github.com/MCPaimon/extension-core) and uses a multi-module Gradle setup that supports all three platforms: PaperMC, SpigotMC, and FoliaMC.

> **Note:** This extension only adds tools to the MCAgents plugin. It does not need its own route on the central API server ([`MCEngine/server-expressjs`](https://github.com/MCEngine/server-expressjs)); all persistence goes through the plugin's `/api/mcagents` route.

## Project Structure

* **`tools/`**: Platform-neutral AI tools shared by every platform module.
* **`platforms/papermc/`**: PaperMC entry point (`Template`).
* **`platforms/spigotmc/`**: SpigotMC entry point (`Template`).
* **`platforms/foliamc/`**: FoliaMC entry point (`Template`).
* **`src/main/resources/`**: The global `extension.yml` descriptor with the per platform main classes.

## Features & AI Tools

This template includes basic examples of how to register custom tools:

* **`get_player_name`**: Returns the name of the player interacting with the AI.
* **`get_player_uuid`**: Returns the UUID of the player interacting with the AI.

## How to Use

1. Copy this template directory to start your new extension project.
2. Update `gradle.properties` with your project's name, group, and version.
3. Update `src/main/resources/extension.yml` so the `mains` entries point to your main classes for each platform.
4. Implement your custom tools in the `tools/` module and register them in each platform's main extension class.
5. Use the [Core extension](https://github.com/MCPaimon/extension-core) as the reference for advanced patterns (commands, listeners, categories, custom tool loading).

## Requirements

* Java 25
* MCAgents Plugin (`io.github.mcpaimon` artifacts, version 2026.0.7-8)

## Build Instructions

To build the extension and create a merged JAR containing all platform implementations:

```bash
./gradlew build
```

The compiled artifact (Shadow JAR) will be located in `build/libs/`.
