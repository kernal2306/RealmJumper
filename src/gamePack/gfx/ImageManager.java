package gamePack.gfx;

import java.awt.image.BufferedImage;

public class ImageManager 
{
	public BufferedImage player;
	public int size;
	
	public ImageManager(SpriteSheet ss)
	{
		SpriteSheet character[];
		SpriteSheet objects[];
		player = ss.crop(0, 0, 32, 32);
		
		
		for (int i = 0; i <= size; i++)
		{
			
		}
		
	}

}
