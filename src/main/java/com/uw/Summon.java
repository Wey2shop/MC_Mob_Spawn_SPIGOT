package com.uw;

import org.bukkit.command.PluginCommand;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

public class Summon extends JavaPlugin {

    @Override
    public void onEnable() {
        // Create the entities.yml configuration file if it doesn't exist
        File configFile = new File(getDataFolder(), "entities.yml");
        if (!configFile.exists()) {
            saveResource("entities.yml", false);
        }

        // Load the configuration file
        YamlConfiguration config = YamlConfiguration.loadConfiguration(configFile);

        // Register the UW command
        PluginCommand spawnEntityCommand = getCommand("UW");
        if (spawnEntityCommand != null) {
            spawnEntityCommand.setExecutor(new SpawnEntitiesCommand(config));
            getLogger().info("UW command registered successfully!");
        } else {
            getLogger().warning("Failed to register the UW command.");
        }
    }

    @Override
    public void onDisable() {
        // Save any plugin data or perform cleanup tasks
    }
}