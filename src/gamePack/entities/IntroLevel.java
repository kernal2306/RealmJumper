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
	Line2D introObjects[];
	public Line2D floorLine = new Line2D.Float();
	public Line2D rtLine = new Line2D.Float();
	public Line2D upLine = new Line2D.Float();
	public Line2D downLine = new Line2D.Float();
	public Line2D platform1Top = new Line2D.Float();
	public Line2D platform1Bottom = new Line2D.Float();
	public Line2D platform1Right = new Line2D.Float();
	public Line2D platform1Left = new Line2D.Float();
	
	//bounds for platforms
	
	public int floor = 640;
	public int p1up = 500;
	public int p1down = 560;
	public int p1Left = 100;
	public int p1Right = 300;	
	//bounds for platforms

	
	public IntroLevel(int x, int y, ImageManager im, SpriteSheet ss)
	{
		this.x = x;
		this.y = y;
		this.im = im;
		this.ss = ss;
		floorLine.setLine(-100, floor, 1024, floor);

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

		floorLine.setLine(-100, floor, 1024, floor);
		return floorLine;
	}
	public Line2D platform1TopBounds()
	{
		platform1Top.setLine(p1Left, p1up, p1Right, p1up);
		return platform1Top;
	}
	public Line2D platform1BottomBounds()
	{
		platform1Bottom.setLine(p1Left, p1down, p1Right, p1down);
		return platform1Bottom;
	}
	public Line2D platform1LeftBounds()
	{
		return platform1Right;
	}
	public Line2D platform1RightBounds()
	{
		return platform1Left;
	}

	
	public Line2D platform2TopBounds()
	{
		platform1Top.setLine(p1Left, p1up, p1Right, p1up);
		return platform1Top;
	}
	public Line2D platform2BottomBounds()
	{
		platform1Bottom.setLine(p1Left, p1down, p1Right, p1down);
		return platform1Bottom;
	}
	public Line2D platform2LeftBounds()
	{
		return platform1Right;
	}
	public Line2D platform2RightBounds()
	{
		return platform1Left;
	}
	
	public void render(Graphics g)
	{
		g.drawImage(im.intro, x, y, 32*Game.SCALE, 32*Game.SCALE, null);
		g.drawLine(-100, floor, 1024, floor);
		g.drawLine(100, 500, 300,500);
		g.drawLine(100, 560, 300, 560);
		g.drawLine(100, 500, 100, 560);
		g.drawLine(300, 500, 300, 560);
	}
}