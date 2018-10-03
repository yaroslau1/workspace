package com.dain_torson.gameofplanes.controller.objects;


import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.physics.box2d.World;
import com.dain_torson.gameofplanes.data.objects.SpaceObjectData;

public class AmmoCrate extends SpaceObject{

    private int capacity;

    public AmmoCrate(Texture texture, World world, SpaceObjectData data, int capacity) {
        super(texture, world, data);
        this.capacity = capacity;
    }

    public int getCapacity() {
        return capacity;
    }
}
