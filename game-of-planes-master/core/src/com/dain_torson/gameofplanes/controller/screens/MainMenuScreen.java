package com.dain_torson.gameofplanes.controller.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.dain_torson.gameofplanes.GameOfPlanes;
import com.dain_torson.gameofplanes.view.UISkin;
import com.dain_torson.gameofplanes.view.UITable;


public class MainMenuScreen implements Screen{

    private GameOfPlanes game;
    private Stage stage;
    private UISkin skin;
    private Table table;

    public MainMenuScreen(GameOfPlanes game) {
        this.game = game;
        skin = new UISkin(game);
        stage = new Stage(new ScreenViewport());
        table = new UITable(game, stage, skin, this);
        stage.addActor(table);

        Gdx.input.setInputProcessor(stage);
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.draw();
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
        stage.dispose();
    }
}
