package com.antoinejt.playtime;

import com.antoinejt.playtime.events.PlayerConnectionListener;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public class PlayTimePlugin extends JavaPlugin {
    private static FileConfiguration cfgFile;
    private static PlayerJoinData playerJoinData;

    @Override
    @SuppressWarnings("java:S2696")
    // Sonarlint java:S2696 - Instance methods should not write to "static" fields
    //   Plugins are written this way, and I need to access ConfigData
    //   from outside this class.
    //   onEnable is called only when starting the server and (maybe?) when
    //   restarting it.
    public void onEnable() {
        cfgFile = getConfig();
        playerJoinData = new PlayerJoinData();

        this.getServer().getPluginManager().registerEvents(new PlayerConnectionListener(), this);

        this.saveDefaultConfig();
    }

    public FileConfiguration getCfgFile() {
        return cfgFile;
    }

    public static PlayerJoinData getPlayerJoinData() {
        return playerJoinData;
    }
}
