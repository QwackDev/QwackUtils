package me.qwackdevelopment.qwackutils.commands;

import me.qwackdevelopment.qwackutils.QwackUtils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public class Fly implements CommandExecutor {

    private QwackUtils plugin;

    private ArrayList<Player> list_of_fly_players = new ArrayList<>();

    public Fly(QwackUtils plugin) {
        this.plugin = plugin;
    }



    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(sender instanceof Player) {
            Player player = (Player) sender;
            if(args.length == 0) {

                flyMethodSelf(player);

            } else if(args.length == 1) {
                Player target = Bukkit.getPlayer(args[0]);
                flyMethodOthers(target);
            }

        }
        return true;
    }

    private void flyMethodSelf(Player player) {

        if(player.hasPermission("qwackutils.fly")) {
            if(list_of_fly_players.contains(player)) {
                list_of_fly_players.remove(player);
                player.setFlying(false);
                player.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("fly-onDisable")));

            } else if(!list_of_fly_players.contains(player)) {
                list_of_fly_players.add(player);
                player.setFlying(true);
                player.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("fly-onEnable")));
            }


        } else {
            player.sendMessage(ChatColor.RED + "You do not have permission to do that");
        }

    }

    private void flyMethodOthers(Player player) {

        if(player.hasPermission("qwackutils.fly.others")) {
            if(list_of_fly_players.contains(player)) {
                list_of_fly_players.remove(player);
                player.setFlying(false);
                player.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("fly-onDisable")));

            } else if(!list_of_fly_players.contains(player)) {
                list_of_fly_players.add(player);
                player.setFlying(true);
                player.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("fly-onEnable")));
            }


        } else {
            player.sendMessage(ChatColor.RED + "You do not have permission to do that");
        }

    }

}
