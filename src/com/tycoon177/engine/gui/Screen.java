package com.tycoon177.engine.gui;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.Timer;

import com.tycoon177.engine.Game;

public abstract class Screen extends JPanel {
	// private int maxFPS = 60;
	// private double optimalTime = 1000000000 / maxFPS;
	private Thread gameThread;
	private Game game;
	private boolean isRunning;
	protected boolean paused;
	private Timer fpsTimer, tickTimer;
	private Graphics2D g;
	// private long lastTime, updateTime;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1543778229183915887L;
	
	/**
	 * Creates a screen object
	 * 
	 * @param game
	 */
	public Screen(Game game) {
		super();
		setSize(game.getDimensions());
		this.game = game;
		onCreate();
		// gameThread = new Thread(this, this.getClass().getName());
		setFocusable(true);
		setupTimer(60);
		// setupUpdateTimer(120);
		this.isRunning = true;
		this.setTickTime(100);
		this.setDoubleBuffered(true);
	}
	
	private void setupTimer(int fps) {
		if (!(fpsTimer == null) && fpsTimer.isRunning()) fpsTimer.stop();
		fpsTimer = new Timer(fps, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				repaint();
			}
		});
		fpsTimer.start();
	}
	
	/**
	 * Called after initialization of the Screen object
	 */
	public abstract void onCreate();
	
	/**
	 * Called each cycle with painting
	 * 
	 * @param g2
	 */
	public abstract void onDraw(Graphics g2);
	
	/**
	 * This method is called as often as possible. Do not render in here. All updates involving movement or time should be multiplied by updateTime before being used so that it runs fairly well on all computers.
	 * 
	 * @param d
	 * 
	 * @param updateTime
	 */
	public abstract void onTick(double d);
	
	@Override
	public void paintComponent(Graphics graphics) {
		super.paintComponent(graphics);
		;
		g = (Graphics2D) graphics;
		
		// super.paintComponent(graphics);
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,
				RenderingHints.VALUE_TEXT_ANTIALIAS_LCD_VRGB);
		onDraw(g);
		if (paused) drawOnPause(g);
	}
	
	/*
	 * @Override public void run() { long lastTime = System.nanoTime(); long updateTime; //System.out.println("Here"); while (isRunning) { if (!paused) { updateTime = System.nanoTime() - lastTime; onTick((double) updateTime / this.optimalTime); } } }
	 */
	
	public void setPaused(boolean active) {
		paused = active;
	}
	
	public void destroyScreen() {
		isRunning = false;
		try {
			gameThread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		// game.setScreen(null);
	}
	
	public void setMaxFps(int fps) {
		setupTimer(fps);
	}
	
	public void setOnTickUsed(boolean used) {
		isRunning = used;
	}
	
	public Game getGame() {
		return game;
	}
	
	/**
	 * Will be drawn over the game, while the game is still rendered
	 */
	public void drawOnPause(Graphics g) {
	}
	
	public void setTickTime(int ups) {
		if (this.tickTimer != null && this.tickTimer.isRunning()) this.tickTimer.stop();
		this.tickTimer = new Timer(1000 / ups, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (isRunning) onTick(1);
			}
		});
		this.tickTimer.start();
	}
	
	public boolean isPaused() {
		return paused;
	}
	
	public void startTicking() {
	}
	
	public void stopTime(){
		if(fpsTimer.isRunning())fpsTimer.stop();
		if(tickTimer.isRunning()) tickTimer.stop();
		
	}
	
}
