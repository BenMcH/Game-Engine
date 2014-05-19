package com.tycoon177.engine;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyboardListener implements KeyListener {
    
    boolean keys[] = new boolean[62000];
    
    @Override
    public void keyPressed(KeyEvent e) {
	keys[e.getKeyCode()] = true;
    }

    @Override
    public void keyReleased(KeyEvent e) {
	keys[e.getKeyCode()] = false;
    }

    @Override
    public void keyTyped(KeyEvent e) {}
   
    public boolean isKeyPressed(int keyEventKeyCode){
	return keys[(int)keyEventKeyCode];
    }
    
}