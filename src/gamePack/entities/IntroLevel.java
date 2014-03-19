package gamePack.entities;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import gamePack.Game;
import gamePack.Physics;
import gamePack.gfx.ImageManager;
import gamePack.gfx.SpriteSheet;

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
	
	public void tick()
	{
		
	}
	
	public void floor()
	{
		

	}
	
	public Rectangle floorBounds()
	{
		return(new Rectangle(0, 664, 200, 32));
	}
	
	public void render(Graphics g)
	{
		g.drawImage(im.intro, x, y, 32*Game.SCALE, 32*Game.SCALE, null);
	
	}
}