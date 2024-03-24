package me.rob.speak;

import org.bukkit.command.PluginCommand;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;

public class Speak extends JavaPlugin {

    @Override
    public void onEnable() {
        // Create the entities.yml configuration file if it doesn't exist
        File configFile = new File(getDataFolder(), "entities.yml");
        if (!configFile.exists()) {
            saveResource("entities.yml", false);
        }

        // Load the configuration file
        YamlConfiguration config = YamlConfiguration.loadConfiguration(configFile);

        // Register the spawnentity command
        PluginCommand spawnEntityCommand = getCommand("spawnentity");
        if (spawnEntityCommand != null) {
            spawnEntityCommand.setExecutor(new SpawnEntitiesCommand(config));
            getLogger().info("spawnentity command registered successfully!");
        } else {
            getLogger().warning("Failed to register the spawnentity command.");
        }
    }

    @Override
    public void onDisable() {
        // Save any plugin data or perform cleanup tasks
    }
}