package gamePack.entities;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.geom.Line2D;
import java.awt.image.BufferedImage;

import gamePack.CurrentLevel;
import gamePack.Game;
import gamePack.Physics;
import gamePack.gfx.ImageManager;
import gamePack.gfx.SpriteSheet;

public class RoofLevel implements CurrentLevel
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
	private Player player;
	Line2D introObjects[];
	public Line2D floorLine = new Line2D.Float();
	public Line2D rtLine = new Line2D.Float();
	public Line2D upLine = new Line2D.Float();
	public Line2D downLine = new Line2D.Float();
	public Line2D platform1Top = new Line2D.Float();
	public Line2D platform0RTop = new Line2D.Float();
	public Line2D platform0LTop = new Line2D.Float();
	public Line2D platform1RTop = new Line2D.Float();
	public Line2D platform1LTop = new Line2D.Float();
	public Line2D platform2RTop = new Line2D.Float();
	public Line2D platform2LTop = new Line2D.Float();
	public Line2D platform3LTop = new Line2D.Float();
	public Line2D platform2Top = new Line2D.Float();
	public Line2D platform3Top = new Line2D.Float();
	public Line2D platform4Top = new Line2D.Float();
	public Line2D platform5Top = new Line2D.Float();
	public Line2D platform1Bottom = new Line2D.Float();
	public Line2D platform1Right = new Line2D.Float();
	public Line2D platform1Left = new Line2D.Float();
	public Line2D door1Line = new Line2D.Float();
	
	
	public RoofLevel(int x, int y, ImageManager im, SpriteSheet ss, Player plyr)
	{
		this.im = im;
		this.ss = ss;
		player = plyr;
				
	}
	
	
	public void tick()
	{
		
	}
	
	//-----------------------------------------------------------	
	
		//area2 rooftop platforms
		public Line2D platform1LTopBounds()
		{
			platform1LTop.setLine(0, 96, 384, 384);
			return platform1LTop;
		}
		public Line2D platform2LTopBounds()
		{
			platform2LTop.setLine(256, 736, 256, 256);
			return platform2LTop;
		}
		public Line2D platform0LTopBounds()
		{
			platform0LTop.setLine(736, 832, 448, 448);
			return platform1LTop;
		}
		
		public Line2D platform1RTopBounds()
		{
			platform1LTop.setLine(928, 1024, 288, 288);
			return platform1LTop;
		}
		public Line2D platform2RTopBounds()
		{
			platform2RTop.setLine(960, 1024, 608, 608);
			return platform2RTop;
		}
		
	//----------------------------------------------------

	
	public void render(Graphics g)
	{
		g.drawImage(im.roof, x, y, 32*Game.SCALE, 32*Game.SCALE, null);
	}

}