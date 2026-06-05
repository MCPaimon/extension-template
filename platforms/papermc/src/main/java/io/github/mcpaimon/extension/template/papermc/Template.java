package io.github.mcpaimon.extension.template.papermc;

import io.github.mcpaimon.extension.template.tools.GetPlayerName;
import io.github.mcpaimon.extension.template.tools.GetPlayerUuid;
import io.github.mcpaimon.mcextension.api.IMCExtension;
import io.github.mcpaimon.papermc.MCAIPlugin;

import org.bukkit.plugin.java.JavaPlugin;

import java.util.concurrent.Executor;

/**
 * Main extension class for PaperMC platform.
 */
public class Template implements IMCExtension {

    @Override
    public void onLoad(Object plugin, Executor executor) {
        // Check if the plugin is an instance of MCAIPlugin
        if (plugin instanceof MCAIPlugin mcaiPlugin) {
            
            // Create the custom categories
            mcaiPlugin.getProvider().createCategory("custom", "This is custom category");
            mcaiPlugin.getProvider().createCategory("player", "Tools for player information and management");
            
            // Register your custom tools here
            mcaiPlugin.getProvider().registerTool(new GetPlayerName());
            mcaiPlugin.getProvider().registerTool(new GetPlayerUuid());
            
            mcaiPlugin.getLogger().info("Template extension loaded successfully on PaperMC. Tools registered.");
            
        } else if (plugin instanceof JavaPlugin javaPlugin) {
            // Fallback to JavaPlugin logger if it is not MCAIPlugin
            javaPlugin.getLogger().severe("Failed to load Template extension: Host plugin is not MCAIPlugin.");
        }
    }

    @Override
    public void onDisable(Object plugin, Executor executor) {
        // Safe check and cast to JavaPlugin to use getLogger()
        if (plugin instanceof JavaPlugin javaPlugin) {
            javaPlugin.getLogger().info("Template extension has been disabled on PaperMC.");
        }
    }
}
