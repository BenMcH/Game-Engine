/*    */ package com.tycoon177.engine.utils.images;
/*    */ 
/*    */ import java.awt.Image;
/*    */ import java.awt.image.BufferedImage;
/*    */ import java.io.IOException;
/*    */ import javax.imageio.ImageIO;
/*    */ 
/*    */ public class Sprite
/*    */ {
/*    */   BufferedImage sprite;
/*    */   
/*    */   public Sprite(String path)
/*    */   {
/*    */     try
/*    */     {
/* 13 */       this.sprite = ImageIO.read(getClass().getResource(path));
/*    */     }
/*    */     catch (IOException e)
/*    */     {
/* 15 */       e.printStackTrace();
/*    */     }
/*    */   }
/*    */   
/*    */   public BufferedImage getSprite()
/*    */   {
/* 20 */     return this.sprite;
/*    */   }
/*    */   
/*    */   public Image getSpriteAtSize(int width, int height)
/*    */   {
/* 24 */     return this.sprite.getScaledInstance(width, height, 1);
/*    */   }
/*    */ }


/* Location:           C:\Users\Ben\Dropbox\Mineabound.jar
 * Qualified Name:     com.tycoon177.engine.utils.images.Sprite
 * JD-Core Version:    0.7.0.1
 */