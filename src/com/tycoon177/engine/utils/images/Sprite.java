package com.tycoon177.engine.utils.images;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Sprite {
	BufferedImage sprite;
	public Sprite(String path) {
		try {
			sprite = ImageIO.read(this.getClass().getResource(path));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public BufferedImage getSprite(){
		return sprite;
	}
	
	public Image getSpriteAtSize(int width, int height){
		return sprite.getScaledInstance(width, height, BufferedImage.SCALE_DEFAULT);
	}
	
}
