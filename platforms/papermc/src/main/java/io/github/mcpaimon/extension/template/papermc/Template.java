package io.github.mcpaimon.extension.template.papermc;

import io.github.mcpaimon.extension.template.tools.GetPlayerName;
import io.github.mcpaimon.extension.template.tools.GetPlayerUuid;
import io.github.mcpaimon.mcextension.api.IMCExtension;
import io.github.mcpaimon.papermc.MCAgentsPlugin;

import org.bukkit.plugin.java.JavaPlugin;

import java.util.concurrent.Executor;

/**
 * Main extension class for PaperMC platform.
 */
public class Template implements IMCExtension {

    @Override
    public void onLoad(Object plugin, Executor executor) {
        // Check if the plugin is an instance of MCAgentsPlugin
        if (plugin instanceof MCAgentsPlugin mcagentsPlugin) {
            
            // Create the custom categories
            mcagentsPlugin.getProvider().createCategory("custom", "This is custom category");
            mcagentsPlugin.getProvider().createCategory("player", "Tools for player information and management");
            
            // Register your custom tools here
            mcagentsPlugin.getProvider().registerTool(new GetPlayerName());
            mcagentsPlugin.getProvider().registerTool(new GetPlayerUuid());
            
            mcagentsPlugin.getLogger().info("Template extension loaded successfully on PaperMC. Tools registered.");
            
        } else if (plugin instanceof JavaPlugin javaPlugin) {
            // Fallback to JavaPlugin logger if it is not MCAgentsPlugin
            javaPlugin.getLogger().severe("Failed to load Template extension: Host plugin is not MCAgentsPlugin.");
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
