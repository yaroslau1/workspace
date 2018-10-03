package com.dain_torson.gameofplanes.data.objects;

import com.badlogic.gdx.math.Vector2;

public class SpaceObjectData {

    private Vector2 initPos;
    private Vector2 initSpeed;
    private float initAngle;

    public SpaceObjectData(Vector2 pos, Vector2 speed, float angle) {
        initPos = pos;
        initAngle = angle;
        initSpeed = speed;
    }

    public Vector2 getInitSpeed() {
        return initSpeed;
    }

    public Vector2 getInitPos() {
        return initPos;
    }

    public float getInitAngle() {
        return initAngle;
    }
}
