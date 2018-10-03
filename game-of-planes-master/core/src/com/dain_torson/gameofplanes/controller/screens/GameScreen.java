package com.dain_torson.gameofplanes.controller.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.dain_torson.gameofplanes.GameOfPlanes;
import com.dain_torson.gameofplanes.controller.CollisionListener;
import com.dain_torson.gameofplanes.controller.GameStage;
import com.dain_torson.gameofplanes.controller.objects.SpaceObject;
import com.dain_torson.gameofplanes.controller.objects.SpacePlane;
import com.dain_torson.gameofplanes.controller.player.Player;
import com.dain_torson.gameofplanes.data.objects.SpacePlaneData;
import com.dain_torson.gameofplanes.data.player.PlayerData;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class GameScreen implements Screen{

    public static final float WORLD_SIZE = 1300;

    public static float UNITS_PER_METER = 50;
    public static boolean DEBUG = false;

    private int crateNum = 0;

    private GameOfPlanes game;
    private GameStage stage;
    private World world;
    private OrthographicCamera camera;

    private List<Player> players;

    private Box2DDebugRenderer debugRenderer;

    public GameScreen(GameOfPlanes game) {
        this.game = game;
        float aspectRatio = (float) Gdx.graphics.getWidth() / (float) Gdx.graphics.getHeight();
        players = new ArrayList<>();
        world = new World(new Vector2(0, 0), true);
        stage = new GameStage(new FitViewport(WORLD_SIZE * aspectRatio, WORLD_SIZE), players, world);

        newGame();

        Gdx.input.setInputProcessor(stage.getInputMultiplexer());

        debugRenderer = new Box2DDebugRenderer();
        camera = new OrthographicCamera();

        stage.getViewport().setCamera(camera);
        stage.getViewport().apply();
        world.setContactListener(new CollisionListener(stage));
    }

    public void newGame() {

       players.clear();

        players.add(new Player("Player1", Arrays.asList(new Integer [] {Input.Keys.UP, Input.Keys.RIGHT,
                Input.Keys.LEFT, Input.Keys.J})));
        players.add(new Player("Player2", Arrays.asList(new Integer [] {Input.Keys.W, Input.Keys.D,
                Input.Keys.A, Input.Keys.CONTROL_LEFT})));

        SpacePlane spacePlane1 = new SpacePlane(new Texture(Gdx.files.internal("textures/temp_scaled2.png")),
                world, new SpacePlaneData(new Vector2(-200, 0), 0, 4f, 3f, 5), players.get(1));
        SpacePlane spacePlane2 = new SpacePlane(new Texture(Gdx.files.internal("textures/temp_scaled2.png")),
                world, new SpacePlaneData(new Vector2(200, 0), 3.14f, 4f, 3f, 5), players.get(0));
        stage.addActor(spacePlane1);
        stage.addActor(spacePlane2);
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        camera.update();
        world.step(1f / 60f, 6, 2);

        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act(Gdx.graphics.getDeltaTime());
        stage.draw();

        if(DEBUG) {
            Matrix4 debugMatrix = stage.getViewport().getCamera().combined.cpy()
                    .scale(UNITS_PER_METER, UNITS_PER_METER, 0);
            debugRenderer.render(world, debugMatrix);
        }
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        world.dispose();
    }
}
