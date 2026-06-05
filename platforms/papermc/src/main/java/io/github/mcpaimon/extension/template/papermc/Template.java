package io.github.mcpaimon.extension.template.papermc;

import io.github.mcpaimon.extension.template.tools.GetPlayerName;
import io.github.mcpaimon.extension.template.tools.GetPlayerUuid;
import io.github.mcpaimon.mcextension.api.IMCExtension;
import io.github.mcpaimon.papermc.MCAIPlugin;

import org.bukkit.plugin.java.JavaPlugin;

import java.util.concurrent.Executor;

public class Template implements IMCExtension {

    @Override
    public void onLoad(Object plugin, Executor executor) {
        // Check if the plugin is an instance of MCAIPlugin
        if (plugin instanceof MCAIPlugin mcaiPlugin) {
            
            // Create the custom categories
            mcaiPlugin.getManager().createCategory("custom", "This is custom category");
            mcaiPlugin.getManager().createCategory("player", "Tools for player information and management");
            
            // Register your custom tools here
            mcaiPlugin.getManager().registerTool(new GetPlayerName());
            mcaiPlugin.getManager().registerTool(new GetPlayerUuid());
            
            mcaiPlugin.getLogger().info("Template extension loaded successfully. Tools registered.");
            
        } else if (plugin instanceof JavaPlugin javaPlugin) {
            // Fallback to JavaPlugin logger if it is not MCAIPlugin
            javaPlugin.getLogger().severe("Failed to load Template extension: Host plugin is not MCAIPlugin.");
        }
    }

    @Override
    public void onDisable(Object plugin, Executor executor) {
        // Safe check and cast to JavaPlugin to use getLogger()
        if (plugin instanceof JavaPlugin javaPlugin) {
            javaPlugin.getLogger().info("Template extension has been disabled.");
        }
    }
}
