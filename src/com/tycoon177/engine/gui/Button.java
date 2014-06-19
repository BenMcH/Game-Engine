package com.tycoon177.engine.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;

import javax.swing.JButton;

public class Button extends JButton {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2642717620010158942L;
	
	private String text;
	private Rectangle2D.Double dim;
	private Color txt = Color.white, bg = Color.darkGray;
	
	public Button(int x, int y, int width, int height, String text) {
		super(text);
		this.setBounds(x, y, width, height);
		this.text = text;
		setSize(this.getWidth(), getHeight());
		dim = new Rectangle2D.Double(x, y, width, height);
	}
	
	public Button(double x, double y, String text) {
		super(text);
		Graphics graphics = new BufferedImage(1000, 1000, BufferedImage.TYPE_3BYTE_BGR).createGraphics();
		Rectangle2D r = graphics.getFontMetrics().getStringBounds(text, graphics);
		r = new Rectangle2D.Double(x, y, r.getWidth() * 2, r.getHeight() * 1.5);
		this.setBounds(r.getBounds().x, r.getBounds().y, (int) r.getWidth(), (int) r.getHeight());
		this.text = text;
		setSize(this.getWidth(), getHeight());
		dim = new Rectangle2D.Double(x, y, this.getWidth(), this.getHeight());
	}
	
	@Override
	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		FontMetrics fm = g2.getFontMetrics();
		Rectangle2D r2 = fm.getStringBounds(text, g2);
		int x = (int) (getBounds().getWidth() / 2 - (int) r2.getWidth() / 2);
		int y = (this.getHeight() / 2 - (int) r2.getHeight() / 2);
		g2.setColor(bg);
		g2.fillRect((int) dim.getX(), (int) dim.getY(), this.getBounds().width, this.getBounds().height);
		g2.setColor(txt);
		g2.drawString(this.text, x, y);
	}
	
	/*
	 * @Override public void paintBorder(Graphics g){
	 * 
	 * }
	 */
	
	@Override
	public void setSize(int width, int height) {
		super.setSize(width, height);
		super.setPreferredSize(new Dimension(width, height));
		super.setMinimumSize(new Dimension(width, height));
	}
	
	public Rectangle2D getDim() {
		return dim;
	}
	
	public void setColors(Color txt, Color bg) {
		this.txt = txt;
		this.bg = bg;
	}
}
