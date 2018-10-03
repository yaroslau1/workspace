package com.dain_torson.gameofplanes.data.objects;

import com.badlogic.gdx.math.Vector2;

public class SpacePlaneData extends SpaceObjectData{

    private float engineForce;
    private float rotationSpeed;
    private int rocketsCount;

    public SpacePlaneData(Vector2 pos, float angle, float force, float rotSpeed, int rCount) {
        super(pos, new Vector2(0, 0), angle);
        engineForce = force;
        rotationSpeed = rotSpeed;
        rocketsCount = rCount;
    }

    public float getEngineForce() {
        return engineForce;
    }

    public float getRotationSpeed() {
        return rotationSpeed;
    }

    public int getRocketsCount() {
        return rocketsCount;
    }

    public void setRocketsCount(int rocketsCount) {
        this.rocketsCount = rocketsCount;
    }
}
