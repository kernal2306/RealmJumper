package gamePack.entities;
import java.awt.Graphics;
import java.awt.geom.Line2D;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.FileReader;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

import gamePack.CurrentLevel;
import gamePack.Game;
import gamePack.Physics;
import gamePack.gfx.ImageManager;
import gamePack.gfx.SpriteSheet;



public class IntroLevel implements CurrentLevel, Serializable
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
	private Lady lady;
	public RoofLevel roof;
	public CollRect rect;
	public ArrayList<CollRect> introObjects = new ArrayList<CollRect>();
	
	
	public Line2D floorLine = new Line2D.Float();
	public Line2D door1Line = new Line2D.Float();  
	int walkObjects;
	
	//bounds for floor
	public int floor = 640;

	//bounds for platform 5 platform
	public int p5up =97;
	public int p5down = 129;
	public int p5Left = 672;
	public int p5Right = 765;

	
	
	public IntroLevel(int x, int y, ImageManager im, SpriteSheet ss, Player plyr)
	{
		this.im = im;
		this.ss = ss;
		player = plyr;	
		//fillArray();
	}
	
	public void tick()
	{
		for(CollRect rect: introObjects)
		{
			if(player.DownCollision(rect.top()))
			{
				player.x = rect.x;
				System.out.println("Collision");
			}
		}
		if (player.y >= this.floorBounds().getY1() - 73)
		{
			player.y = floor -73;
			Game.dialogShow = true;
			System.out.println("DownCollision");
		}
		
		if(player.DownCollision(this.door()) && player.up == true)
		{
			Game.curr = Game.roof;
			
		}
		
		player.tick();
	}
	
	public void fillArray()
	{
		
		try
		{
			int tmp[] = {0,0,0,0};
			Scanner scan = new Scanner(new File("res/rooftopNewCoord.txt"));
			
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
					introObjects.add(new CollRect(tmp[0], tmp[1], tmp[2], tmp[3]));
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
		for(CollRect rect: introObjects)
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
	
	public Line2D door()
	{
		door1Line.setLine(672, p5up-16, 768, p5up-16);
		return door1Line;
	}


	
	public void render(Graphics g)
	{


		g.drawImage(im.intro, x, y, 32*Game.SCALE, 32*Game.SCALE, null);getClass();
		
		//floor line 
		g.drawLine(-100, floor, 1024, floor);

		
	}
}

