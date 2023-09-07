package com.mygdx.game;

import Planet.Planet;
import Player.Player;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.ScreenUtils;

public class GameClass extends ApplicationAdapter {
	ShapeRenderer shapeRenderer ;
	static int SCREEN_WIDTH=1400;
	static int SCREEN_HEIGHT = 800;
	String backGroundImagePath= "background.jpg";
	SpriteBatch batch;
	Player player;
	Planet planet;

	InputMultiplexer inputMultiplexer = new InputMultiplexer();

	@Override
	public void create () {
		batch = new SpriteBatch();
		player = new Player();
		planet = new Planet();
		inputMultiplexer.addProcessor(player);
		Gdx.input.setInputProcessor(inputMultiplexer);
		shapeRenderer= new ShapeRenderer();
	}

	@Override
	public void render () {
		update();
		ScreenUtils.clear(1, 0, 0, 1);
		batch.begin();
		setBackground();
		player.draw(batch);
		batch.end();
		planet.draw(shapeRenderer);
	}

	private void setBackground(){
		batch.draw(new Texture(backGroundImagePath),0,0,SCREEN_WIDTH,SCREEN_HEIGHT);
	}

	public void update(){
		player.update();
		planet.update((float) 1 /3);
	}

	@Override
	public void dispose () {
		batch.dispose();
		shapeRenderer.dispose();
	}
}
