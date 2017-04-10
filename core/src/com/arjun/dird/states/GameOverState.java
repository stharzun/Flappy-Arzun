package com.arjun.dird.states;

import com.arjun.dird.ArjunBird;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Created by arzun on 4/10/17.
 */
public class GameOverState extends State {
    Texture background,gameover,playBtn;
    public GameOverState(GameStateManager gsm) {
        super(gsm);
        cam.setToOrtho(false, ArjunBird.WIDTH/2,ArjunBird.HEIGHT/2);
        background= new Texture("bg.png");
        gameover= new Texture("gameover.png");
        playBtn=new Texture("retry.png");
    }

    @Override
    protected void handleInput() {
        if(Gdx.input.justTouched()){
            gsm.set(new PlayState(gsm));
        }

    }

    @Override
    public void update(float dt) {
        handleInput();

    }

    @Override
    public void render(SpriteBatch sb) {
        sb.setProjectionMatrix(cam.combined);
        sb.begin();
        sb.draw(background, 0,0);
        sb.draw(gameover, cam.position.x - gameover.getWidth() / 2, cam.position.y);
        sb.draw(playBtn,cam.position.x-playBtn.getWidth()/2,cam.position.y-playBtn.getHeight());
        sb.end();
    }

    @Override
    public void dispose() {
        background.dispose();
        gameover.dispose();
        playBtn.dispose();
        System.out.println("Game over Disposed");

    }
}
