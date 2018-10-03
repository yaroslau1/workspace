package com.dain_torson.gameofplanes.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.scenes.scene2d.*;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Align;
import com.dain_torson.gameofplanes.GameOfPlanes;
import com.dain_torson.gameofplanes.controller.screens.GameScreen;


public class UITable extends Table{


    public UITable(GameOfPlanes game, Stage stage, UISkin skin, Screen parentScreen) {

        setWidth(stage.getWidth());
        align(Align.center | Align.top);
        setPosition(0, Gdx.graphics.getHeight());

        TextButton newGameButton = new TextButton("New game", skin, "defaultTB");
        TextButton exitGameButton = new TextButton("Exit game", skin, "defaultTB");

        newGameButton.setWidth(200);
        newGameButton.setHeight(50);

        exitGameButton.setWidth(200);
        exitGameButton.setHeight(50);

        padTop(Gdx.graphics.getHeight() / 2 - 100);
        add(newGameButton).padBottom(30);
        row();
        add(exitGameButton);

        newGameButton.addListener(new ClickListener() {
            public void clicked(InputEvent event, float x, float y) {
                game.setScreen(new GameScreen(game));
                parentScreen.dispose();
            }
        });

        exitGameButton.addListener(new ClickListener() {
            public void clicked(InputEvent event, float x, float y) {
                parentScreen.dispose();
                game.dispose();
                Gdx.app.exit();
            }
        });
    }
}
