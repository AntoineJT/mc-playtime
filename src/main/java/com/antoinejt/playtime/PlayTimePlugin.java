package com.antoinejt.playtime;

import com.antoinejt.playtime.events.PlayerConnectionListener;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

public class PlayTimePlugin extends JavaPlugin {
    private static FileConfiguration cfgFile;
    private static PlayerJoinData playerJoinData;
    private static PlayTimeData playTimeData;
    private static JavaPlugin instance;

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
        playTimeData = PlayTimeData.get();

        this.getServer().getPluginManager().registerEvents(new PlayerConnectionListener(), this);

        this.saveDefaultConfig();
    }

    public FileConfiguration getCfgFile() {
        return cfgFile;
    }

    public static PlayerJoinData getPlayerJoinData() {
        return playerJoinData;
    }

    public static PlayTimeData getPlayTimeData() {
        return playTimeData;
    }

    public static Logger getConsoleLogger() {
        return instance.getLogger();
    }
}
