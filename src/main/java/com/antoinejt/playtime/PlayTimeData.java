package com.antoinejt.playtime;

import com.google.gson.Gson;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.logging.Level;

public class PlayTimeData {
    private final Map<UUID, Duration> data;
    private static final File file = new File("plugins/PlayTime/data.json");

    public PlayTimeData() {
        this.data = new HashMap<>();
    }

    public Duration getPlayTime(Player player) {
        return data.get(player.getUniqueId());
    }

    public void addPlayTime(Player player, Duration duration) {
        UUID uuid = player.getUniqueId();
        Duration total = data.containsKey(uuid)
                ? data.get(uuid).plus(duration)
                : duration;
        data.put(uuid, total);
    }

    public void persistOnDisk() {
        try (FileWriter fw = new FileWriter(file)) {
            fw.write(new Gson().toJson(this));
        } catch (IOException e) {
            PlayTimePlugin.getConsoleLogger().log(Level.WARNING,
                    "Can't persist playtime on disk! Error: " + e.getMessage());
        }
    }
}
