package com.uw;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

public class SpawnEntitiesCommand implements CommandExecutor {

    private final YamlConfiguration config;

    public SpawnEntitiesCommand(YamlConfiguration config) {
        this.config = config;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("This command can only be executed by a player.");
            return true;
        }

        Player player = (Player) sender;

        // Check if the command has the correct number of arguments
        if (args.length != 1) {
            player.sendMessage("Usage: /UW <entityType>");
            return true;
        }

        String entityTypeArg = args[0];

        // Check if the entity type exists in the configuration
        if (!config.contains("entities." + entityTypeArg)) {
            player.sendMessage("Invalid entity type: " + entityTypeArg);
            return true;
        }

        String summonCommand = config.getString("entities." + entityTypeArg);

        // Execute the summon command
        //player.performCommand(summonCommand);
        player.getServer().dispatchCommand(player, summonCommand);

        // Debug lines
        //player.sendMessage("Summoning entity type: " + entityTypeArg);
        //player.sendMessage("Summon command: " + summonCommand);
        System.out.println("Summoning entity type: " + entityTypeArg);
        System.out.println("Summon command: " + summonCommand);

        return true;
    }
}