package com.dain_torson.gameofplanes.view;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.dain_torson.gameofplanes.GameOfPlanes;


public class UISkin extends Skin {

    public UISkin(GameOfPlanes game) {

        TextButtonStyle buttonStyle = new TextButtonStyle();
        buttonStyle.font = game.generateFont(GameOfPlanes.FontType.MAIN, 54);
        buttonStyle.fontColor = Color.BLACK;
        buttonStyle.downFontColor = Color.RED;
        add("defaultTB", buttonStyle);
    }

    @Override
    public void dispose() {
        super.dispose();
    }
}
