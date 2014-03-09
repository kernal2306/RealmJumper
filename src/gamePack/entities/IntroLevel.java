package gamePack.entities;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import gamePack.Game;
import gamePack.Physics;
import gamePack.gfx.ImageManager;
import gamePack.gfx.SpriteSheet;
import java.awt.Rectangle;

public class IntroLevel
{
	public int x;
	public int y;
	private int t;
	double count = 1;
	int tickCount = 1;
	private ImageManager im;
	Physics p = new Physics();
	private SpriteSheet ss;
	
	public IntroLevel(int x, int y, ImageManager im, SpriteSheet ss)
	{
		this.x = x;
		this.y = y;
		this.im = im;
		this.ss = ss;
	}
	
	public Rectangle bounds()
	{
		return(new Rectangle(x, y, 32, 32));
	}
}