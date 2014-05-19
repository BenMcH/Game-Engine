package com.tycoon177.engine;

import java.awt.Dimension;

import javax.swing.JFrame;

public class Game {
    private JFrame frame;
    private Screen currentPane;

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
	frame.setLocationRelativeTo(null);
    }

    /**
     * 
     * @param s
     *            New Screen object Changes the screen
     */
    public void setScreen(Screen s) {
	if (currentPane != null)
	    frame.remove(currentPane);
	currentPane = s;
	frame.add(currentPane);
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

}
