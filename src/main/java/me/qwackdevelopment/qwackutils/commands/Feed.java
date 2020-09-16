package me.qwackdevelopment.qwackutils.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Feed implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(sender instanceof Player){
            Player player = (Player) sender;
            if(player.hasPermission("qwackutils.feed")) {
                player.setFoodLevel(20);
            } else {
                player.sendMessage(ChatColor.RED + "You do not have the required permission to run this command.");
            }

        } else {
            System.out.println("You cant run that command as a console");
        }

        return false;
    }
}
