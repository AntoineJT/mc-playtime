package com.antoinejt.playtime.api;

import com.antoinejt.playtime.PlayTimePlugin;
import org.bukkit.entity.Player;

import java.time.Duration;

@SuppressWarnings("unused")
public class PlayTime {
    // we will see if that's useful in the future
    private final Player player;

    public PlayTime(Player player) {
        this.player = player;
    }

    public Duration get() {
        return PlayTimePlugin.getPlayTimeData().getPlayTime(player.getUniqueId());
    }
}
