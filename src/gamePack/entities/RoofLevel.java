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
	public Line2D enemyRight = new Line2D.Float();
	public Line2D enemyLeft= new Line2D.Float();
	public Line2D friendRight = new Line2D.Float();
	

	//bounds for floor
	public int floor = 700;
	
	public RoofLevel(int x, int y, ImageManager im, SpriteSheet ss, Player plyr)
	{
		this.im = im;
		this.ss = ss;
		player = plyr;
				
	}
	
	public void tick()
	{
		
		if (player.y >= this.floorBounds().getY1() - 73)
		{
			player.y = floor -73;
			//Game.dialogShow = true;
			//System.out.println("DownCollision");
			
		}
		if(player.LeftCollision(enemyRightBounds()))
		{
			player.x = (int) (enemyRight.getX1() - 73);
			//Game.dialogShow = true;
			System.out.println("Enemy Collision");
		}

		if(player.rightCollision(enemyLeftBounds()))
		{
			player.x =  (int)(enemyLeft.getX1() - 73);
			//Game.dialogShow = true;
			System.out.println("Enemy Collision");
		}
		
		if(player.DownCollision(this.platform2TopBounds()))
		{
			player.y = 256;
			//Game.dialogShow = true;
			//System.out.println("Down Collision");
		}
		
		if(Game.player.rightCollision(this.enemyRight()))
		{
			System.out.print("Enemy being hit");
			Game.dialogShow2 = true;
			Game.player.x = 512;
			Game.dialogCount = 4;
			Game.dialog.dialogDisplay2(24, 27);
		}
		
		/*if((Game.player.x < 512 && (Game.player.y < 736 || Game.player.y > 700)))
		{
			System.out.println("You are winning!");
			Game.dialogShow2 = true;
			Game.player.x = 512;
			Game.dialogCount = 4;
			Game.dialog.dialogDisplay2(24, 27);
		}*/
		
		player.tick();
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
	
	
	//-----------------------------------------------------------	
	
		//area2 rooftop platforms
		public Line2D platform1LTopBounds()
		{
			platform1LTop.setLine(0, 96, 384, 384);
			return platform1LTop;
		}
		public Line2D platform2TopBounds()
		{
			platform2Top.setLine(256, 256,736, 256);
			return platform2Top;
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
		public Line2D enemyRightBounds()
		{
			platform1LTop.setLine(512,512,320,736);
			return enemyRight;
		}
		public Line2D enemyLeftBounds()
		{
			platform2RTop.setLine(960, 1024, 608, 608);
			return enemyLeft;
		}
		
		//collison lines for rooftop dialog
		public Line2D enemyRight()
		{
			enemyRight.setLine(512, 320, 512, 736);
			return enemyRight;
		}
		
		public Line2D enemyLeft()
		{
			enemyLeft.setLine(448, 320, 448, 736);
			return enemyLeft;
		}
		
		public Line2D friendRight()
		{
			friendRight.setLine(192, 672, 192, 736);
			return friendRight;
		}
		
	//----------------------------------------------------

	
	public void render(Graphics g)
	{
		g.drawImage(im.roof, x, y, 32*Game.SCALE, 32*Game.SCALE, null);
	}

}