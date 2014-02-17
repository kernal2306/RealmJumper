package gamePack.gfx;

import java.awt.image.BufferedImage;

public class ImageManager 
{
	public BufferedImage player;
	
	public ImageManager(SpriteSheet ss)
	{
		player = ss.crop(0, 0, 32, 32);
	}
	public void Forward(SpriteSheet ss, int count)
	{
		player = ss.crop(0, 1, 32, 32);
	}
	public void Backwards(SpriteSheet ss)
	{
		player = ss.crop(1, 0, 32, 32);

	}
}
