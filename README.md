# MCPaimon Template Extension

This project serves as a boilerplate for developers creating custom extensions and tools for the MCPaimon AI Plugin. It uses a multi-module Gradle setup to support different platforms (starting with PaperMC).

## Project Structure

* **`papermc/`**: Contains the PaperMC-specific implementation and tools.
* **`src/main/resources/`**: Contains the global `extension.yml` configuration.

## Features & AI Tools

This template includes basic examples of how to register custom tools:

* **`get_player_name`**: Returns the name of the player interacting with the AI.
* **`get_player_uuid`**: Returns the UUID of the player interacting with the AI.

## How to Use

1. Copy this template directory to start your new extension project.
2. Update `gradle.properties` with your project's name, group, and version.
3. If adding new platforms, create a new submodule and update `settings.gradle` and the root `build.gradle`.
4. Update `src/main/resources/extension.yml` to point to your main classes for each platform.
5. Implement your custom tools in the respective modules and register them in your main extension class.

## Requirements

* Java 25
* MCPaimon AI Plugin Core

## Build Instructions

To build the extension and create a merged JAR containing all platform implementations:

```bash
./gradlew build
```

The compiled artifact (Shadow JAR) will be located in `build/libs/`.
