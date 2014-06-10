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
	int count;
	private ImageManager im;
	Physics p = new Physics();
	private SpriteSheet ss;
	private Player player;
	private Lady lady;
	public RoofLevel roof;
	public CollRect rect;
	File cFile = new File("res/introNewCoord.txt");
	public ArrayList<CollRect> introObjects = new ArrayList<CollRect>();
	
	
	public Line2D floorLine = new Line2D.Float();
	public Line2D door1Line = new Line2D.Float();  
	int walkObjects;
	
	//bounds for floor
	public int floor = 728;

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
		fillArray();
	}
	
	public void tick()
	{
		
		if(player.DownCollision(this.floorLine))
		{


			//player.y = floor -73;
			//Game.dialogShow = true;
			//System.out.println("DownCollision");

			player.y = floor -73;

			
		}
		for(CollRect rect: introObjects)
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

			//System.out.println("DownCollision");
			
		}
		if(player.DownCollision(this.door()) && player.up == true)
		{
			Game.curr = Game.roof;
			player.x = 900;
			player.y = 700;
			
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
					introObjects.add(new CollRect(tmp[0], tmp[1], tmp[2], tmp[3]));
					count++;
				}
			}	
			printArray();
			scan.close();
			//scan2.close();
		}
		catch(IOException e)
		{

			player.y = p5up - 73;
			//Game.dialogShow = true;
			//System.out.println("DownCollision");

			e.printStackTrace();

		}
	}
	
	public void printArray()
	{
		for(CollRect rect: introObjects)
		{
			//System.out.println(Game.dialog.dialogArray[23]);
			//Game.curr = Game.roof;

			

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
		floorLine.setLine(0, floor, 1024, floor);
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

