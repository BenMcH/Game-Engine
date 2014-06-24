package com.tycoon177.engine.utils;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashMap;

public class KeyboardListener implements KeyListener {
	
	HashMap<Integer, Boolean> keys = new HashMap<>();
	
	@Override
	public void keyPressed(KeyEvent e) {
		keys.put(e.getKeyCode(), true);
	}
	
	@Override
	public void keyReleased(KeyEvent e) {
		keys.put(e.getKeyCode(), false);
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
	}
	
	public boolean isKeyPressed(int keyEventKeyCode) {
		if(keys.get(keyEventKeyCode) == null) return false;
		return keys.get(keyEventKeyCode);
	}
	
	public void setKeyPressed(int keyCode, boolean state){
		keys.put(keyCode, state);
	}
	
}
