package com.arjun.dird;

import com.arjun.dird.states.GameStateManager;
import com.arjun.dird.states.MenuState;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class ArjunBird extends ApplicationAdapter {
	public static final int WIDTH= 400;
	public static final int HEIGHT=800;

	public static final String TITTLE="Flappy ArZun";

	private GameStateManager gsm;

	private  SpriteBatch batch;
	Texture img;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		gsm=new GameStateManager();
		img = new Texture("badlogic.jpg");

		Gdx.gl.glClearColor(1, 0, 0, 1);

		gsm.push(new MenuState(gsm));
	}

	@Override
	public void render () {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		gsm.update(Gdx.graphics.getDeltaTime());
		gsm.render(batch);
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}
}
