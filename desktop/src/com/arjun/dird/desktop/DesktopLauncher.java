package com.arjun.dird.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.arjun.dird.ArjunBird;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width=ArjunBird.WIDTH;
		config.height=ArjunBird.HEIGHT;
		config.title=ArjunBird.TITTLE;
		new LwjglApplication(new ArjunBird(), config);
	}
}
