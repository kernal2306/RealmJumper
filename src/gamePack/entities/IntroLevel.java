package gamePack.entities;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.geom.Line2D;
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
	int numTiles = 50;
	double count = 1;
	int tickCount = 1;
	private ImageManager im;
	Physics p = new Physics();
	private SpriteSheet ss;
	public Line2D floorLine = new Line2D.Float();
	public Line2D rtLine = new Line2D.Float();
	public Line2D upLine = new Line2D.Float();
	public Line2D downLine = new Line2D.Float();
	
	//bounds for platforms
	public int floor = 640;
	
	public IntroLevel(int x, int y, ImageManager im, SpriteSheet ss)
	{
		this.x = x;
		this.y = y;
		this.im = im;
		this.ss = ss;
		floorLine.setLine(-100, floor, 1024, floor);
//		rtLine.setLine();
//		upLine.setLine();
//		downLine.setLine();
	}
	
	public void tick()
	{
		drawLevel();
	}
	
	public void drawLevel()
	{
		//floor
		this.x += 32;
		if(count <= 1024)
		{
		im.intro = ss.crop(1,2,32,32);
		}
	}
	
	public void floor()
	{
		im.intro = ss.crop(0, 0, 32, 32);

	}
	
	//create lines for collision detection on intro level
	public Line2D floorBounds()
	{
		return floorLine;
		
	}
	
	public void render(Graphics g)
	{
		g.drawImage(im.intro, x, y, 32*Game.SCALE, 32*Game.SCALE, null);
	
	}
}