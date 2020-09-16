package me.qwackdevelopment.qwackutils.events;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerBedEnterEvent;

public class OnPlayerSleep implements Listener {

    @EventHandler
    public void onPlayerSleep(PlayerBedEnterEvent e) {

        e.getPlayer().sendMessage(ChatColor.BLUE + "Good night.");

    }

}
