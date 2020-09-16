package me.qwackdevelopment.qwackutils;

import me.qwackdevelopment.qwackutils.commands.Feed;
import me.qwackdevelopment.qwackutils.commands.Fly;
import me.qwackdevelopment.qwackutils.commands.God;
import me.qwackdevelopment.qwackutils.commands.Kill;
import me.qwackdevelopment.qwackutils.events.OnPlayerJoin;
import me.qwackdevelopment.qwackutils.events.OnPlayerLeave;
import me.qwackdevelopment.qwackutils.events.OnPlayerSleep;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public final class QwackUtils extends JavaPlugin {

    @Override
    public void onEnable() {

        getConfig().options().copyDefaults();
        saveDefaultConfig();

        getLogger().info(ChatColor.GREEN + "QwackUtils is started.");

        // Events
        getServer().getPluginManager().registerEvents(new OnPlayerSleep(), this);
        getServer().getPluginManager().registerEvents(new OnPlayerJoin(), this);
        getServer().getPluginManager().registerEvents(new OnPlayerLeave(), this);

        // Commands
        getCommand("god").setExecutor(new God(this));
        getCommand("feed").setExecutor(new Feed());
        getCommand("kill").setExecutor(new Kill());
        getCommand("fly").setExecutor(new Fly(this));

        // Config
        getConfig().options().copyDefaults();
        saveDefaultConfig();

    }

    @Override
    public void onDisable() {
        getLogger().info(ChatColor.RED + "QwackUtils is disabled.");
    }
}
