package com.dain_torson.gameofplanes.controller.objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;
import com.dain_torson.gameofplanes.controller.KeyHandler;
import com.dain_torson.gameofplanes.controller.player.Player;
import com.dain_torson.gameofplanes.controller.screens.GameScreen;
import com.dain_torson.gameofplanes.data.ControlsMap;
import com.dain_torson.gameofplanes.data.objects.SpaceObjectData;
import com.dain_torson.gameofplanes.data.objects.SpacePlaneData;

import java.util.HashMap;
import java.util.Map;

public class SpacePlane extends SpaceObject implements InputProcessor{

    private MoveController moveController;
    private Map<Integer, KeyHandler> keyDownHandlerMap;
    private Map<Integer, KeyHandler> keyUpHandlerMap;
    private Player player;

    public SpacePlane(Texture texture, World world, SpacePlaneData data, Player player) {
        super(texture, world, data);
        this.player = player;

        setBody(createBody(getSprite(), data.getInitAngle()));
        moveController = new MoveController(data, getBody(), 0.5f);

        initControls();
    }

    @Override
    protected Body createBody(Sprite sprite, float angle) {

        Body body;
        BodyDef bodyDef = new BodyDef();
        bodyDef.type = BodyDef.BodyType.DynamicBody;

        float ppm = GameScreen.UNITS_PER_METER;

        PolygonShape shape = new PolygonShape();
        shape.setAsBox(sprite.getWidth()/ 2 / ppm, sprite.getHeight()
                / 2 / ppm);

        FixtureDef fixtureDef = new FixtureDef();
        fixtureDef.density = 0.1f;

        body = super.createBody(sprite, bodyDef, shape, fixtureDef, angle);
        shape.dispose();

        return body;
    }

    @Override
    public void act(float delta) {
        super.act(delta);
        moveController.act();
    }

    private void fire() {

        SpacePlaneData data = (SpacePlaneData) getData();

        if(data.getRocketsCount() < 1) {
            return;
        }

        float angle = getBody().getAngle();
        Vector2 center = getCenterCoordinates();

        float x = center.x + (getSprite().getWidth() / 2 + 50) * (float)Math.cos(angle);
        float y = center.y + (getSprite().getHeight() / 2 + 50) * (float)Math.sin(angle);

        float missileSpeed = 100;
        float xSpeed = missileSpeed * (float) Math.cos(angle) + getBody().getLinearVelocity().x * 10;
        float ySpeed = missileSpeed * (float) Math.sin(angle) + getBody().getLinearVelocity().y * 10;

        Missile missile = new Missile(new Texture(Gdx.files.internal("textures/missile.png")),
                getWorld(), new SpaceObjectData(new Vector2(x, y), new Vector2(xSpeed, ySpeed), angle), this);
        getStage().addActor(missile);

        data.setRocketsCount(data.getRocketsCount() - 1);
    }

    private void initControls() {
        keyDownHandlerMap = new HashMap<>();
        keyUpHandlerMap = new HashMap<>();

        ControlsMap controlsMap = player.getControls();

        keyDownHandlerMap.put(controlsMap.get("up"), () -> moveController.startAcceleration(true));
        keyDownHandlerMap.put(controlsMap.get("right"), () -> moveController.startRotation(true));
        keyDownHandlerMap.put(controlsMap.get("left"), () -> moveController.startRotation(false));
        keyDownHandlerMap.put(controlsMap.get("fire"), () -> fire());
        keyDownHandlerMap.put(Input.Keys.ESCAPE, () -> resetPosition());

        keyUpHandlerMap.put(controlsMap.get("up"), () -> moveController.stopAcceleration());
        keyUpHandlerMap.put(controlsMap.get("right"), () -> moveController.stopRotation());
        keyUpHandlerMap.put(controlsMap.get("left"), () -> moveController.stopRotation());

    }

    private void resetPosition() {
        getBody().setTransform(0, 0, 0);
        getBody().setAwake(false);
    }

    @Override
    public boolean keyDown(int keycode) {
        KeyHandler handler = keyDownHandlerMap.get(keycode);
        if(handler != null) {
            handler.handle();
            return true;
        }
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        KeyHandler handler = keyUpHandlerMap.get(keycode);
        if(handler != null) {
            handler.handle();
            return true;
        }
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }

    public Player getPlayer() {
        return player;
    }

    private class MoveController {

        private boolean accelerationApplied;
        private int rotationMultiplier = 1;
        private int accelerationMultiplier = 1;

        private SpacePlaneData planeData;
        private Body planeBody;

        public MoveController(SpacePlaneData planeData, Body planeBody, float delay) {
            this.planeData = planeData;
            this.planeBody = planeBody;
        }

        public void startRotation(boolean clockwise) {
            if(clockwise) {
                rotationMultiplier = -1;
            }
            planeBody.setAwake(true);
            planeBody.setAngularVelocity(planeData.getRotationSpeed() * rotationMultiplier);
        }

        public void stopRotation() {
            rotationMultiplier = 1;
            planeBody.setAngularVelocity(0);
        }

        public void startAcceleration(boolean forward) {
            accelerationApplied = true;
            if(!forward) {
                accelerationMultiplier = -1;
            }
        }

        public void stopAcceleration() {
            accelerationApplied = false;
            accelerationMultiplier = 1;
        }

        public void act() {

            if(accelerationApplied) {
                SpacePlane.this.applyForceInCurrentDirection(planeData.getEngineForce() * accelerationMultiplier);
            }
        }
    }
}

