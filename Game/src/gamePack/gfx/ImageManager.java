package gamePack.gfx;

import java.awt.image.BufferedImage;

public class ImageManager 
{
	public BufferedImage player;
	
	public ImageManager(SpriteSheet ss)
	{
		player = ss.crop(0, 0, 32, 32);
	}
}
