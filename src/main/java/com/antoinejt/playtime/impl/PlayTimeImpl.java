package com.antoinejt.playtime.impl;

import com.antoinejt.playtime.api.PlayTime;
import org.bukkit.entity.Player;

import java.util.UUID;

public class PlayTimeImpl implements PlayTime {
    private final UUID uuid;

    public PlayTimeImpl(Player player) {
        this.uuid = player.getUniqueId();
    }
}
