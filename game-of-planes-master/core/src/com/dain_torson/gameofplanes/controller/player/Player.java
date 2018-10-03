package com.dain_torson.gameofplanes.controller.player;


import com.dain_torson.gameofplanes.data.ControlsMap;
import com.dain_torson.gameofplanes.data.player.PlayerData;

import java.util.List;

public class Player {

    private PlayerData data;
    private ControlsMap controls;

    //TODO: Fix controls scheme. Add default controls scheme
    public Player(String name, List<Integer> controlValues) {
        data = new PlayerData(name);
        controls = new ControlsMap(controlValues);

    }

    public ControlsMap getControls() {
        return controls;
    }

    public String getInfo() {
        return "Name: " + String.valueOf(data.getName()) +
                " Kills: " + String.valueOf(data.getKills()) +
                " Death: " + String.valueOf(data.getDeath());
    }

    public void score() {
        data.setKills(data.getKills() + 1);
    }

    public void planeDied() {
        data.setDeath(data.getDeath() + 1);
    }
}


