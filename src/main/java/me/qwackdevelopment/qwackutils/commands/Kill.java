package me.qwackdevelopment.qwackutils.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Kill implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(sender instanceof Player) {
            Player player = (Player) sender;
            if(sender.hasPermission("qwackutils.kill")) {
                if (args.length == 0) {
                    player.sendMessage(ChatColor.RED + "RIP, you just killed yourself");
                    player.setHealth(0);
                } else {
                    Player target = Bukkit.getPlayerExact(args[0]);
                    if(target instanceof Player) {
                        player.sendMessage(ChatColor.RED + "You just ruined " + target.getDisplayName() + "'s life.");
                        target.sendMessage(ChatColor.RED + "RIP, you got /killed by someone");
                        target.setHealth(0);
                    } else {
                        player.sendMessage(ChatColor.RED + "That player does not exist.");
                    }
                }
            } else {
                player.sendMessage(ChatColor.RED + "You do not have permission to do that!");
            }
        }

        return false;
    }
}
