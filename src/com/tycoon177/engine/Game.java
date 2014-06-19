package com.tycoon177.engine;

import java.awt.Dimension;

import javax.swing.JFrame;

import com.tycoon177.engine.gui.Screen;

public class Game {
	private JFrame frame;
	
	/**
	 * 
	 * @param title
	 *            Title of Window
	 * @param width
	 *            Width
	 * @param height
	 *            Height
	 */
	public Game(String title, int width, int height) {
		frame = new JFrame(title);
		frame.setSize(width, height);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setFocusable(true);
		frame.setLayout(null);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
	}
	
	/**
	 * 
	 * @param s
	 *            New Screen object Changes the screen
	 */
	public void setScreen(Screen s) {
		frame.setContentPane(s);
		frame.revalidate();
	//	((Screen)frame.getContentPane()).startTicking();
	}
	
	public JFrame getFrame() {
		return frame;
	}
	
	public Dimension getDimensions() {
		return frame.getSize();
	}
	
	public void showFrame() {
		frame.setVisible(true);
	}
	
	public void hideFrame() {
		frame.setVisible(false);
	}
	
	public Screen getScreen(){
		return (Screen) this.frame.getContentPane();
	}
	
}
