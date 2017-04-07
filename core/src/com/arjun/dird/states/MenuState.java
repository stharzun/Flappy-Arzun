package com.arjun.dird.states;

import com.arjun.dird.ArjunBird;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Created by arzun on 4/7/17.
 */

public class MenuState extends State {
    private Texture background;
    private Texture playBtn;
    public MenuState(GameStateManager gsm) {
        super(gsm);
        background=new Texture("bg.png");
        playBtn=new Texture("playbtn.png");
    }

    @Override
    public void dispose() {
        background.dispose();
        playBtn.dispose();
    }

    @Override
    public void handleInput() {
        if (Gdx.input.justTouched()){
            gsm.set(new PlayState(gsm));
            dispose();
        }
    }

    @Override
    public void update(float dt) {
        handleInput();
    }

    @Override
    public void render(SpriteBatch sb) {
        sb.begin();
        sb.draw(background,0,0, ArjunBird.WIDTH,ArjunBird.HEIGHT);
        sb.draw(playBtn,(ArjunBird.WIDTH/2)-(playBtn.getWidth()/2),ArjunBird.HEIGHT/2);
        sb.end();
    }
}
