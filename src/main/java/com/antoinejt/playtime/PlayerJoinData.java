package com.antoinejt.playtime;

import java.util.*;

public class PlayerJoinData {
    private final Map<UUID, Date> data;

    public PlayerJoinData() {
        this.data = new HashMap<>();
    }

    public Date getJoinTime(UUID uuid) {
        return data.get(uuid);
    }

    public void registerPlayerJoin(UUID uuid) {
        data.put(uuid, new Date());
    }

    /*
    public boolean setJoinTime(UUID uuid, Date joinTime) {
        return Objects.equals(data.put(uuid, joinTime), joinTime);
    }
     */

    public Date pop(UUID uuid) {
        return data.remove(uuid);
    }
}
