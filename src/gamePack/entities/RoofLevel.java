package gamePack.entities;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.geom.Line2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

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
	CollRect cRect;
	private SpriteSheet ss;
	private Player player;
	File cFile = new File("res/rooftopNewCoord.txt");
	public ArrayList<CollRect> roofObjects = new ArrayList<CollRect>();
	
	public Line2D floorLine = new Line2D.Float();

	

	//bounds for floor
	public int floor = 700;
	
	public RoofLevel(int x, int y, ImageManager im, SpriteSheet ss, Player plyr)
	{
		this.im = im;
		this.ss = ss;
		player = plyr;
		fillArray();
				
	}
	
	public void tick()
	{
		for(CollRect rect: roofObjects)
		{
			if(player.DownCollision(rect.top()))
			{
				player.y = rect.y - 73;
				System.out.println("Collision");
			}
			if(player.UpCollision(rect.bottom()))
			{
				player.jump = false;
				player.p.falling(y, x, count);
				System.out.println("up Collision");
			}
		}
		
		if (player.y >= this.floorBounds().getY1() - 73)
		{
			player.y = floor -73;
			Game.dialogShow = true;
			//System.out.println("DownCollision");
			
		}
		player.tick();
	}
	
	public void fillArray()
	{
		
		try
		{
			int tmp[] = {0,0,0,0};
			Scanner scan = new Scanner(cFile);
			
			while(scan.hasNextLine())
			{
				String line = scan.nextLine();
				
				Scanner scan2 = new Scanner(line);
				scan2.useDelimiter(",");
				int count = 0;
				while(scan2.hasNextInt())
				{
					for(int i = 0; i <= 3; i++)
					{
						//System.out.println(scan2.nextInt());
						tmp[i] = scan2.nextInt();
						//System.out.println(tmp[i]);
					}
					//System.out.println();
					roofObjects.add(new CollRect(tmp[0], tmp[1], tmp[2], tmp[3]));
					count++;
				}
			}	
			printArray();
				
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	
	public void printArray()
	{
		for(CollRect rect: roofObjects)
		{
			System.out.println(rect.x);
			System.out.println(rect.y);
			System.out.println(rect.height);
			System.out.println(rect.width);
			System.out.println();
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
	
	
	//-----------------------------------------------------------	
	
//		//area2 rooftop platforms
//		public Line2D platform1LTopBounds()
//		{
//			platform1LTop.setLine(0, 96, 384, 384);
//			return platform1LTop;
//		}
//		public Line2D platform2TopBounds()
//		{
//			platform2Top.setLine(256, 256,736, 256);
//			return platform2Top;
//		}
//		public Line2D platform0LTopBounds()
//		{
//			platform0LTop.setLine(736, 832, 448, 448);
//			return platform1LTop;
//		}
//		
//		public Line2D platform1RTopBounds()
//		{
//			platform1LTop.setLine(928, 1024, 288, 288);
//			return platform1LTop;
//		}
//		public Line2D platform2RTopBounds()
//		{
//			platform2RTop.setLine(960, 1024, 608, 608);
//			return platform2RTop;
//		}
//		public Line2D enemyRightBounds()
//		{
//			platform1LTop.setLine(512,512,320,736);
//			return enemyRight;
//		}
//		public Line2D enemyLeftBounds()
//		{
//			platform2RTop.setLine(960, 1024, 608, 608);
//			return enemyLeft;
//		}
		
	//----------------------------------------------------

	
	public void render(Graphics g)
	{
		g.drawImage(im.roof, x, y, 32*Game.SCALE, 32*Game.SCALE, null);
	}

}