package com.dain_torson.gameofplanes.controller.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Align;
import com.dain_torson.gameofplanes.GameOfPlanes;

public class WelcomeScreen implements Screen {

    private GameOfPlanes game;
    private BitmapFont font;
    private float totalDelta;

    public WelcomeScreen(GameOfPlanes game) {
        this.game = game;
        font = game.generateFont(GameOfPlanes.FontType.MAIN, 54);
        font.setColor(Color.BLACK);
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {

        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        SpriteBatch batch = game.getBatch();
        batch.begin();

        font.draw(batch, "Welcome to the Game of Planes!", Gdx.graphics.getWidth() / 2,
                Gdx.graphics.getHeight() / 2 + 100, 0, Align.center, true);

        if(totalDelta < 1) {
            font.draw(batch, "(Press any key to continue)", Gdx.graphics.getWidth() / 2,
                    Gdx.graphics.getHeight() / 2, 0, Align.center, true);
        }

        batch.end();

        if(Gdx.input.isTouched() || Gdx.input.isKeyPressed(Input.Keys.ANY_KEY)) {
            game.setScreen(new MainMenuScreen(game));
            dispose();
        }

        totalDelta += delta;
        if(totalDelta > 2)
        {
            totalDelta = 0;
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
        font.dispose();
    }
}
