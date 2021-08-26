package com.antoinejt.playtime;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public class PlayTimePlugin extends JavaPlugin {
    private static FileConfiguration cfgFile;

    @Override
    @SuppressWarnings("java:S2696")
    // Sonarlint java:S2696 - Instance methods should not write to "static" fields
    //   Plugins are written this way, and I need to access ConfigData
    //   from outside this class.
    //   onEnable is called only when starting the server and (maybe?) when
    //   restarting it.
    public void onEnable() {
        cfgFile = getConfig();

        this.saveDefaultConfig();
    }

    public FileConfiguration getCfgFile() {
        return cfgFile;
    }
}
