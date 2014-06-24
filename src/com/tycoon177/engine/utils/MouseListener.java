package com.tycoon177.engine.utils;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

public class MouseListener implements java.awt.event.MouseListener, MouseMotionListener, MouseWheelListener {
	private boolean clicked = false;
	public Point location;
	public static final int RIGHT = 1, LEFT = 0;
	private int mouseBtn = -1;
	private int rotation;
	public MouseListener(){
		location = new Point();
	}
	
	@Override
	public void mouseClicked(MouseEvent arg0) {
	}
	
	@Override
	public void mouseEntered(MouseEvent arg0) {
	}
	
	@Override
	public void mouseExited(MouseEvent arg0) {
	}
	
	@Override
	public void mousePressed(MouseEvent arg0) {
		clicked = true;
		location = new Point(arg0.getPoint());
		mouseBtn = arg0.getButton() == MouseEvent.BUTTON1 ? LEFT : arg0.getButton() == MouseEvent.BUTTON2 ? RIGHT : -1;
	}
	
	@Override
	public void mouseReleased(MouseEvent arg0) {
		clicked = false;
	}
	
	public boolean isMouseClicked() {
		return clicked;
	}
	
	public Point getMouseLocation() {
		return location;
	}
	
	@Override
	public void mouseDragged(MouseEvent e) {
		location.setLocation(e.getX(), e.getY());
	}
	
	@Override
	public void mouseMoved(MouseEvent e) {
		location = new Point(e.getX(), e.getY());
	}
	
	public int getMouseBtn(){
		return mouseBtn;
	}
	
	public void setMouseClicked(boolean state){
		this.clicked = state;
	}

	@Override
	public void mouseWheelMoved(MouseWheelEvent e) {
		rotation = e.getWheelRotation();
	}
	
	public int getRotation(){
		int a = rotation;
		rotation = 0;
		return a;
	}
}
