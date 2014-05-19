package com.tycoon177.engine;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class MouseListener implements java.awt.event.MouseListener, MouseMotionListener {
    private boolean clicked = false;
    private Point location;
    
    @Override
    public void mouseClicked(MouseEvent arg0) {}

    @Override
    public void mouseEntered(MouseEvent arg0) {}

    @Override
    public void mouseExited(MouseEvent arg0) {}

    @Override
    public void mousePressed(MouseEvent arg0) {
	clicked = true;
    }

    @Override
    public void mouseReleased(MouseEvent arg0) {
	clicked = false;
    }
    
    public boolean isMouseClicked(){
	return clicked;
    }
    
    public Point getMouseLocation(){
	return location;
    }

    @Override
    public void mouseDragged(MouseEvent e) {}

    @Override
    public void mouseMoved(MouseEvent e) {
	location = e.getLocationOnScreen();
    }
}
