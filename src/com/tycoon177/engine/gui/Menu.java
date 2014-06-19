package com.tycoon177.engine.gui;

import java.awt.Graphics;

import com.tycoon177.engine.Game;

public class Menu extends Screen {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6560221327325934468L;
	
	public Menu(Game game) {
		super(game);
		this.setOnTickUsed(false);
		this.setMaxFps(10);
		this.setOnTickUsed(false);
	}
	
	@Override
	public void onCreate() {
	}
	
	@Override
	public void onDraw(Graphics g2) {
	}
	
	@Override
	public void onTick(double onTick) {
	}

	@Override
	public void drawOnPause(Graphics g) {
		// TODO Auto-generated method stub
		
	}
	
}
