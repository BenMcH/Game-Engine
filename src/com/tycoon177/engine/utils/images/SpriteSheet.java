package com.tycoon177.engine.utils.images;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

public class SpriteSheet {
	BufferedImage spriteSheet;
	
	public SpriteSheet(String relativePath) {
		URL u = this.getClass().getResource(relativePath);
		try {
			spriteSheet = ImageIO.read(u);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public BufferedImage getSprite(int x, int y, int width, int height){
		return spriteSheet.getSubimage(x, y, width, height);
	}
}
