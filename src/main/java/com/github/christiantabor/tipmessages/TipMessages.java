package com.github.christiantabor.tipmessages;

import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class TipMessages extends JavaPlugin {

    private static TipMessages instance;

    public static TipMessages getPlugin() {
        return instance;
    }

    @Override
    public void onEnable() {
        this.getConfig().options().copyDefaults(true);
        this.saveDefaultConfig();
        saveConfig();
        registerEvents();
        instance = this;
    }

    @Override
    public void onDisable() {

    }

    private void registerEvents() {
        PluginManager pm = getServer().getPluginManager();
        pm.registerEvents(new PlayerListener(), this);
    }

}
