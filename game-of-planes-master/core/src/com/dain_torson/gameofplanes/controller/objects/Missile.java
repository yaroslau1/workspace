package com.dain_torson.gameofplanes.controller.objects;


import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.physics.box2d.World;
import com.dain_torson.gameofplanes.data.objects.SpaceObjectData;

public class Missile extends SpaceObject{

    private float curTime = 0;
    private float lifeTime = 5;
    private SpacePlane creator;

    public Missile(Texture texture, World world, SpaceObjectData data, SpacePlane creator) {
        super(texture, world, data);
        this.creator = creator;
        getBody().setBullet(true);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
        curTime += 1f / 60f;
        if(curTime > lifeTime) {
            dispose();
        }
    }

    public SpacePlane getCreator() {
        return creator;
    }
}
