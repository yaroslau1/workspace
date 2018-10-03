package com.dain_torson.gameofplanes.data.player;

public class PlayerData {

    private int kills = 0;
    private int death = 0;
    private String name;

    public PlayerData(String name) {
        this.name = name;
    }

    public int getKills() {
        return kills;
    }

    public int getDeath() {
        return death;
    }

    public void setKills(int kills) {
        this.kills = kills;
    }

    public void setDeath(int death) {
        this.death = death;
    }

    public String getName() {
        return name;
    }
}
