package com.antoinejt.playtime.events;

import com.antoinejt.playtime.PlayTimeData;
import com.antoinejt.playtime.PlayTimePlugin;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerKickEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import java.time.Duration;
import java.util.Date;

public class PlayerConnectionListener implements Listener {
    @EventHandler
    public void onPlayerJoinEvent(PlayerJoinEvent event) {
        PlayTimePlugin.getPlayerJoinData().registerPlayerJoin(event.getPlayer().getUniqueId());
    }

    @EventHandler
    public void onPlayerQuitEvent(PlayerQuitEvent event) {
        handleDisconnect(event);
    }

    @EventHandler
    public void onPlayerKickEvent(PlayerKickEvent event) {
        handleDisconnect(event);
    }

    private void handleDisconnect(PlayerEvent event) {
        Date disconnectDate = new Date();
        Date joinDate = PlayTimePlugin.getPlayerJoinData().pop(event.getPlayer().getUniqueId());
        Duration sessionDuration = Duration.between(joinDate.toInstant(), disconnectDate.toInstant());

        PlayTimeData data = PlayTimePlugin.getPlayTimeData();
        data.addPlayTime(event.getPlayer().getUniqueId(), sessionDuration);
        data.persistOnDisk();
    }
}
