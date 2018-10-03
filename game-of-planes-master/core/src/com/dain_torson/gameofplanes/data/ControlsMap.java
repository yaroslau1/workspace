package com.dain_torson.gameofplanes.data;

import java.util.HashMap;
import java.util.List;

public class ControlsMap extends HashMap<String, Integer>{

    private String [] keys = {"up", "right", "left", "fire"};

    public ControlsMap(List<Integer> values) {
        initialize(values);
    }

    private void initialize(List<Integer> values) {
        for(int index = 0; index < keys.length; ++index) {
            put(keys[index], values.get(index));
        }
    }
}
