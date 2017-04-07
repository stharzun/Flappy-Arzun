package com.arjun.dird.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;

import java.util.Random;

/**
 * Created by arzun on 4/7/17.
 */

public class Tube {
    private static final int FLUCTUATION=130;
    public static final int TUBE_WIDTH=52;
    private static final int TUBE_GAP=100;
    private static final int LOWEST_OPENING=120;
    private Texture topTube,bottomTube;
    private Vector2 posTopTube,posBotTube;
    private Rectangle boundsTop,boundBot;
    private Random random;

    public Tube(float x){
        topTube=new Texture("toptube.png");
        bottomTube=new Texture("bottomtube.png");

        random=new Random();

        posTopTube=new Vector2(x,random.nextInt(FLUCTUATION)+TUBE_GAP+LOWEST_OPENING);
        posBotTube=new Vector2(x,posTopTube.y-TUBE_GAP-bottomTube.getHeight());

        boundsTop=new Rectangle(posTopTube.x,posTopTube.y,topTube.getWidth(),topTube.getHeight());
        boundBot=new Rectangle(posBotTube.x,posBotTube.y,bottomTube.getWidth(),bottomTube.getHeight());
        boundsTop.setPosition(posTopTube.x,posTopTube.y);
        boundBot.setPosition(posBotTube.x,posBotTube.y);
    }

    public Texture getTopTube() {
        return topTube;
    }

    public Texture getBottomTube() {
        return bottomTube;
    }

    public Vector2 getPosTopTube() {
        return posTopTube;
    }

    public Vector2 getPosBotTube() {
        return posBotTube;
    }
    public void reposition(float x){
        posTopTube.set(x,random.nextInt(FLUCTUATION)+TUBE_GAP+LOWEST_OPENING);
        posBotTube.set(x,posTopTube.y-TUBE_GAP-bottomTube.getHeight());
    }
    public  boolean collides(Rectangle player){
        return player.overlaps(boundsTop)||player.overlaps(boundBot);
    }
}
