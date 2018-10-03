package com.dain_torson.gameofplanes.controller;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.dain_torson.gameofplanes.controller.objects.AmmoCrate;
import com.dain_torson.gameofplanes.controller.objects.SpaceObject;
import com.dain_torson.gameofplanes.controller.objects.SpacePlane;
import com.dain_torson.gameofplanes.controller.player.Player;
import com.dain_torson.gameofplanes.controller.screens.GameScreen;
import com.dain_torson.gameofplanes.data.objects.SpaceObjectData;
import com.dain_torson.gameofplanes.data.objects.SpacePlaneData;

import java.util.List;

public class GameStage extends Stage{

    private InputMultiplexer inputMultiplexer;
    private List<Player> players;
    private World world;

    private boolean crateSpawn = false;

    public GameStage(Viewport viewport, List<Player> players, World world) {
        super(viewport);
        this.players = players;
        this.world = world;
        inputMultiplexer = new InputMultiplexer();
        inputMultiplexer.addProcessor(this);
    }

    @Override
    public void addActor(Actor actor) {
        super.addActor(actor);
        if(actor instanceof SpacePlane) {
            inputMultiplexer.addProcessor((SpacePlane)actor);
        }
    }

    //TODO: Move to another thread. Rewrite relocation
    private void checkBoundaries() {

        OrthographicCamera camera = (OrthographicCamera)getCamera();
        for (Actor actor : getActors()) {
            if(actor instanceof SpaceObject) {
                SpaceObject object = (SpaceObject)actor;
                Vector2 center = object.getCenterCoordinates();

                if(!camera.frustum.pointInFrustum(center.x, center.y, 0f)) {

                    float posX = object.getBody().getPosition().x;
                    float posY = object.getBody().getPosition().y;

                    float height = camera.viewportHeight / 2;
                    float width = camera.viewportWidth / 2;

                    posX = center.x < -width || center.x > width ? -posX : posX;
                    posY = center.y < -height || center.y > height ? -posY : posY;

                    object.relocate(posX, posY, object.getBody().getAngle(), true);
                }
            }
        }
    }

    //TODO: Move to another thread. Rewrite.
    private void checkObjectsStatus() {
        for(Actor actor : getActors()) {
            if(actor instanceof SpaceObject) {
                SpaceObject object = (SpaceObject) actor;
                if (object.isDestroyed()) {
                    if(object instanceof SpacePlane){
                        SpacePlane plane = (SpacePlane) object;
                        getInputMultiplexer().removeProcessor(plane);
                        Player player = plane.getPlayer();
                        Vector2 initPos = generateRandPos();
                        float initAngle = MathUtils.random(0, 2 * MathUtils.PI);
                        plane.dispose();
                        addActor(new SpacePlane(new Texture(Gdx.files.internal("textures/temp_scaled2.png")),
                                world, new SpacePlaneData(initPos, initAngle, 4f, 3f, 5), player));
                        for (Player gamer : players) {
                            System.out.println(gamer.getInfo());
                        }
                    }
                    else {
                        object.dispose();
                    }
                }
            }
        }
    }

    private Vector2 generateRandPos() {

        float x = MathUtils.random(-((GameScreen.WORLD_SIZE - 100) / 2), ((GameScreen.WORLD_SIZE - 100) / 2));
        float y = MathUtils.random(-((GameScreen.WORLD_SIZE - 100) / 2), ((GameScreen.WORLD_SIZE - 100) / 2));

        return new Vector2(x, y);
    }

    private void spawnCrate() {
        if(!crateSpawn) {
            AmmoCrate crate = new AmmoCrate(new Texture(Gdx.files.internal("textures/ammoCrate.jpg")),
                    world, new SpaceObjectData(generateRandPos(), new Vector2(0, 0), 0), 5);
            addActor(crate);
            crateSpawn = true;
        }
    }

    public void setCrateSpawn(boolean crateSpawn) {
        this.crateSpawn = crateSpawn;
    }

    @Override
    public void act(float delta) {
        super.act(delta);
        spawnCrate();
        checkObjectsStatus();
        checkBoundaries();
    }

    public InputMultiplexer getInputMultiplexer() {
        return inputMultiplexer;
    }
}
