package com.dain_torson.gameofplanes.controller.objects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.utils.Disposable;
import com.dain_torson.gameofplanes.controller.screens.GameScreen;
import com.dain_torson.gameofplanes.data.objects.SpaceObjectData;

public class SpaceObject extends Actor implements Disposable {

    private Sprite sprite;
    private SpaceObjectData data;
    private World world;
    private Body body;

    private boolean destroyed = false;

    public SpaceObject(Texture texture, World world,  SpaceObjectData data) {
        this.world = world;
        this.data = data;

        sprite = new Sprite(texture);
        sprite.setPosition(data.getInitPos().x -sprite.getWidth()/2,
                data.getInitPos().y -sprite.getHeight()/2);

        body = createBody(sprite, data.getInitAngle());
        body.applyForceToCenter(data.getInitSpeed(), true);

    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        sprite.draw(batch);
    }

    @Override
    public void act(float delta) {
        sprite.setPosition((body.getPosition().x * GameScreen.UNITS_PER_METER)  - sprite.getWidth()/2,
                (body.getPosition().y * GameScreen.UNITS_PER_METER)  - sprite.getHeight()/2);
        sprite.setRotation((float)Math.toDegrees(body.getAngle()));
    }

    protected Body createBody(Sprite sprite, float angle) {

        BodyDef bodyDef = new BodyDef();
        bodyDef.type = BodyDef.BodyType.DynamicBody;

        bodyDef.position.set((sprite.getX() + sprite.getWidth()/2) / GameScreen.UNITS_PER_METER,
                (sprite.getY() + sprite.getHeight()/2) / GameScreen.UNITS_PER_METER);
        bodyDef.angle = angle;

        Body body = world.createBody(bodyDef);

        float ppm = GameScreen.UNITS_PER_METER;

        PolygonShape shape = new PolygonShape();
        shape.setAsBox(sprite.getWidth()/ 2 / ppm, sprite.getHeight()
                / 2 / ppm);

        FixtureDef fixtureDef = new FixtureDef();
        fixtureDef.shape = shape;
        fixtureDef.density = 0.1f;

        body.createFixture(fixtureDef);
        shape.dispose();

        return body;
    }

    protected Body createBody(Sprite sprite, BodyDef bodyDef, Shape shape, FixtureDef fixtureDef, float angle) {

        bodyDef.position.set((sprite.getX() + sprite.getWidth()/2) / GameScreen.UNITS_PER_METER,
                (sprite.getY() + sprite.getHeight()/2) / GameScreen.UNITS_PER_METER);
        bodyDef.angle = angle;

        Body body = world.createBody(bodyDef);

        fixtureDef.shape = shape;
        body.createFixture(fixtureDef);

        return body;
    }

    public void applyForceInCurrentDirection(float force) {
        float angle = body.getAngle();

        float x = (float) Math.cos(angle) * force;
        float y = (float) Math.sin(angle) * force;

        body.applyForceToCenter(x, y, true);
        body.setLinearVelocity(body.getLinearVelocity().clamp(0, 15));
    }

    public Vector2 getCenterCoordinates() {

        float centerX = getSprite().getX() + getSprite().getWidth() / 2;
        float centerY = getSprite().getY() + getSprite().getHeight() / 2;

        return new Vector2(centerX, centerY);

    }

    public void relocate(float x, float y, float angle, boolean wakeUp) {
        body.setTransform(x, y, angle);
        body.setAwake(wakeUp);
    }

    public SpaceObjectData getData() {
        return data;
    }

    public void setData(SpaceObjectData data) {
        this.data = data;
    }

    public Body getBody() {
        return body;
    }

    public void setBody(Body body) {
        world.destroyBody(this.body);
        this.body = body;
    }

    public Sprite getSprite() {
        return sprite;
    }

    public World getWorld() {
        return world;
    }

    public boolean isDestroyed() {
        return destroyed;
    }

    public void setDestroyed(boolean destroyed) {
        this.destroyed = destroyed;
    }

    @Override
    public void dispose() {
        world.destroyBody(this.body);
        sprite.getTexture().dispose();
        remove();
    }
}
