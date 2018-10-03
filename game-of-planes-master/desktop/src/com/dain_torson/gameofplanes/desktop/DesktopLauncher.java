package com.dain_torson.gameofplanes.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.dain_torson.gameofplanes.GameOfPlanes;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		new LwjglApplication(new GameOfPlanes(), config);
        config.width = 1024;
        config.height = 768;
	}
}
