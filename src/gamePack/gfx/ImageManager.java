package gamePack.gfx;

import gamePack.entities.IntroLevel;
import java.awt.image.BufferedImage;

public class ImageManager 
{
	public BufferedImage player, lady, intro;
	public int floorLength;
	SpriteSheet character[];
	SpriteSheet objects[];
	public BufferedImage floor[];
	public int x;
	public int y;
	public int width = 32;
	public int hieght = 32;
	
	public ImageManager(SpriteSheet ss)
	{
		player = ss.crop(0, 0, 32, 32);
		lady = ss.crop(0, 0, 32,32);
		intro = ss.crop(2, 0, 32, 32);
	}
	
	public void intro(SpriteSheet ss)
	{
		for (int i = 0; i <= floorLength; i++)
		{
			x += 32;
			y += 32;
			intro = ss.crop(y, x, width, hieght);
			floor[i] = intro;
		}

	}
}
