package gamePack.gfx;

import java.awt.image.BufferedImage;

public class ImageManager 
{
	public BufferedImage player;
	
	public ImageManager(SpriteSheet ss)
	{
		SpriteSheet character[];
		SpriteSheet objects[];
		player = ss.crop(0, 0, 32, 32);
		
		
	}

}
