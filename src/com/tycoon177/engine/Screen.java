package com.tycoon177.engine;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public abstract class Screen extends JPanel implements Runnable {
    private int maxFPS = 60;
    private double optimalTime = 1000000000 / maxFPS;
    private Thread gameThread;
    private Game game;
    private boolean isRunning, paused;
    private Timer timer;
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
	gameThread = new Thread(this);
	setFocusable(true);
	setLayout(null);
	setupTimer(60);
    }

    private void setupTimer(int fps) {
    	if(!(timer == null) && timer.isRunning())timer.stop();
    	timer = new Timer(fps, new ActionListener(){
    		@Override
    		public void actionPerformed(ActionEvent e) {
    			repaint();
    		}
    	});
    	timer.start();
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
     * This method is called as often as possible. Do not render in here.
     * All updates involving movement or time should be multiplied by updateTime before being used so that it runs fairly well on all computers.
     * @param updateTime 
     */
    public abstract void onTick(double updateTime);

    @Override
    public void paint(Graphics graphics) {
	Graphics2D g2 = (Graphics2D) graphics;
	super.paint(graphics);
	g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
		RenderingHints.VALUE_ANTIALIAS_ON);
	g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,
		RenderingHints.VALUE_TEXT_ANTIALIAS_LCD_VRGB);
	onDraw(g2);
    }

    @Override
    public void run() {
	long lastTime = System.nanoTime();
	long updateTime;
	while (isRunning) {
	    if (!paused){
		updateTime = System.nanoTime() - lastTime;
		onTick((double)updateTime/this.optimalTime);
	    }
	}
    }

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
	game.setScreen(null);
    }
    
    public void setMaxFps(int fps){
    	setupTimer(fps);
    }
    
    public void setOnTickUsed(boolean used){
    	isRunning = used;
    }
    
}
