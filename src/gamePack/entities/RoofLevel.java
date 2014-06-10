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
	private int t, count;
	private ImageManager im;
	Physics p = new Physics();
	CollRect rect;
	private SpriteSheet ss;
	private Player player;
	File cFile = new File("res/rooftopNewCoord.txt");
	public ArrayList<CollRect> roofObjects = new ArrayList<CollRect>();
	
	public Line2D floorLine = new Line2D.Float();
	public Line2D door1Line = new Line2D.Float();
	public Line2D enemyRight = new Line2D.Float();
	public Line2D enemyLeft= new Line2D.Float();
	public Line2D friendRight = new Line2D.Float();
	public Line2D portalRight = new Line2D.Float();



	

	//bounds for floor
	public int floor = 700;
	
	public RoofLevel(int x, int y, ImageManager im, SpriteSheet ss, Player plyr)
	{
		this.im = im;
		this.ss = ss;
		player = plyr;
		fillArray();
				
	}
	
	@SuppressWarnings("unused")
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

			//Game.dialogShow = true;

			Game.dialogShow = true;

			
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
						tmp[i] = scan2.nextInt();
					}
					roofObjects.add(new CollRect(tmp[0], tmp[1], tmp[2], tmp[3]));
					count++;
				}
			}	
			printArray();
			scan.close();

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

			//player.y = 256;
			//Game.dialogShow = true;
			//System.out.println("Down Collision");
		}
		

		
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
	
	

		public Line2D enemyRight()
		{
			enemyRight.setLine(520, 320, 520, 736);
			return enemyRight;
		}
		
		public Line2D enemyLeft()
		{
			enemyLeft.setLine(448, 320, 448, 736);
			return enemyLeft;
		}
		
		public Line2D friendRight()
		{
			
			
			if(Game.dialogStart == 100)
			{
				Game.back2 = Game.back2Again;
				friendRight.setLine(0, 500, 0, 736);
			}
			else
			{
				friendRight.setLine(180, 500, 180, 736);
			}
			//System.out.println("lady false");
			
			return friendRight;
			
		}
		
		public Line2D portalRight()
		{
			portalRight.setLine(60,500, 60, 736);
			if(Game.dialogStart == 116)
			{
				Game.curr = Game.realm2_2;
				player.x = 900;
			}
			//System.out.println("portal collisions");
			return portalRight;
		}
		
	//----------------------------------------------------

	
	public void render(Graphics g)
	{
		g.drawImage(im.roof, x, y, 32*Game.SCALE, 32*Game.SCALE, null);
	}

}