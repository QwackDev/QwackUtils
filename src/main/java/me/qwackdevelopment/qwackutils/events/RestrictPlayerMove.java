package me.qwackdevelopment.qwackutils.events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class RestrictPlayerMove implements Listener {

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event) {
        Player player = event.getPlayer();
        if(player.hasPermission("qwackutils.restrictedMove")) {
            event.setCancelled(true);
        }
    }

}
