package com.uw;

import org.bukkit.Bukkit;
import org.bukkit.command.PluginCommand;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitScheduler;
import org.bukkit.scheduler.BukkitTask;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Summon extends JavaPlugin {
    private BukkitTask scheduleTask;
    private List<CommandEntry> commandEntries;

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

        // Load the schedule.yml configuration file
        File scheduleFile = new File(getDataFolder(), "schedule.yml");
        if (!scheduleFile.exists()) {
            saveResource("schedule.yml", false);
        }

        YamlConfiguration scheduleConfig = YamlConfiguration.loadConfiguration(scheduleFile);

        // Initialize command entries list
        commandEntries = new ArrayList<>();

        // Extract command entries from the configuration
        ConfigurationSection scheduleSection = scheduleConfig.getConfigurationSection("schedule");
        if (scheduleSection != null) {
            for (String entryKey : scheduleSection.getKeys(false)) {
                ConfigurationSection entrySection = scheduleSection.getConfigurationSection(entryKey);
                if (entrySection != null) {
                    String command = entrySection.getString("command");
                    int delay = entrySection.getInt("delay");

                    CommandEntry commandEntry = new CommandEntry(command, delay);
                    commandEntries.add(commandEntry);
                }
            }
        }

        // Schedule the commands for execution
        if (scheduleTask != null) {
            scheduleTask.cancel();
        }

        BukkitScheduler scheduler = getServer().getScheduler();
        scheduleTask = new BukkitRunnable() {
            private int currentIndex = 0;

            @Override
            public void run() {
                CommandEntry entry = commandEntries.get(currentIndex);
                String command = entry.getCommand();
                // Hide command output from the console
                Bukkit.getServer().getLogger().info("UW:Checking for Multiblock Structures");
                Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), command);

                currentIndex++;
                if (currentIndex >= commandEntries.size()) {
                    currentIndex = 0; // Reset the index to repeat the commands
                }

                CommandEntry nextEntry = commandEntries.get(currentIndex);
                int delay = nextEntry.getDelay();
                //getLogger().info("Next command in " + delay + " ticks");
                scheduler.runTaskLater(Summon.this, () -> run(), delay);
            }
        }.runTaskLater(this, 0);
    }

    @Override
    public void onDisable() {
        if (scheduleTask != null) {
            scheduleTask.cancel();
        }
        // Save any plugin data or perform cleanup tasks
    }

    private static class CommandEntry {
        private final String command;
        private final int delay;

        public CommandEntry(String command, int delay) {
            this.command = command;
            this.delay = delay;
        }

        public String getCommand() {
            return command;
        }

        public int getDelay() {
            return delay;
        }
    }
}