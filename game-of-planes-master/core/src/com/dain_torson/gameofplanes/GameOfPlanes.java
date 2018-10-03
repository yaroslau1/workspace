package com.dain_torson.gameofplanes;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.dain_torson.gameofplanes.controller.screens.GameScreen;
import com.dain_torson.gameofplanes.controller.screens.WelcomeScreen;

public class GameOfPlanes extends Game {

    private SpriteBatch batch;

	@Override
	public void create () {
		batch = new SpriteBatch();
        //this.setScreen(new WelcomeScreen(this));
        this.setScreen(new GameScreen(this));
	}

	@Override
	public void render () {
		super.render();
	}

    @Override
    public void dispose() {
        super.dispose();
        batch.dispose();
    }

    public SpriteBatch getBatch() {
        return batch;
    }

    public BitmapFont generateFont(FontType fontType, int size) {

        FreeTypeFontGenerator generator;

        if(fontType == FontType.MAIN) {
            generator = new FreeTypeFontGenerator(Gdx.files.internal("fonts/SISTEMAS.ttf"));
        } else {
            generator = new FreeTypeFontGenerator(Gdx.files.internal("fonts/SISTEMAS.ttf"));
        }

        FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        parameter.size = size;

        BitmapFont font = generator.generateFont(parameter);
        generator.dispose();

        return font;
    }

    public enum FontType {MAIN, TEXT}
}
