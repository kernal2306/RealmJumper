package gamePack.entities;

import java.awt.Graphics;
import java.awt.geom.Line2D;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import gamePack.CurrentLevel;
import gamePack.Game;
import gamePack.Physics;
import gamePack.gfx.ImageManager;
import gamePack.gfx.SpriteSheet;

public class Realm2_2 implements CurrentLevel{
	
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
	public Line2D bottomLeft = new Line2D.Float();
	public Line2D top = new Line2D.Float();
	public Line2D door1Line = new Line2D.Float();
	public Line2D enemyRight = new Line2D.Float();
	public Line2D enemyLeft= new Line2D.Float();
	public Line2D friendRight = new Line2D.Float();
	public Line2D portalRight = new Line2D.Float();
	File cFile = new File("res/realm2_2Coord.txt");
	public ArrayList<CollRect> realm2_2Objects = new ArrayList<CollRect>();
	

	//bounds for floor
		public int floor = 730;
		
		public Realm2_2(int x, int y, ImageManager im, SpriteSheet ss, Player plyr)
		{
			this.im = im;
			this.ss = ss;
			player = plyr;
			fillArray();
		}
		
		@SuppressWarnings("unused")
		public void tick()
		{
			for(CollRect rect: realm2_2Objects)
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


				
			}
			
			
			
			if(Game.player.rightCollision(this.bottomLeft()))
			{
				System.out.println("portal collision");
				Game.curr = Game.realm2_1;
				player.x = 924;
				//Game.dialogShow2 = true;
				//Game.player.x = 65;
				//Game.dialogCount = 104;
				//Game.dialogStart = 108;
				//Game.dialogStop = 119;
			}
			
			if(Game.player.UpCollision(this.top()))
			{
				System.out.println("top of screen collision collision");
				Game.curr = Game.realm1_2;
				player.y = 720;
				player.x = 700;
				//Game.dialogShow2 = true;
				//Game.player.x = 65;
				//Game.dialogCount = 104;
				//Game.dialogStart = 108;
				//Game.dialogStop = 119;
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
						realm2_2Objects.add(new CollRect(tmp[0], tmp[1], tmp[2], tmp[3]));
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
			for(CollRect rect: realm2_2Objects)
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
		
		

			
			
			public Line2D bottomLeft()
			{
				bottomLeft.setLine(32, 0, 10, 736);
				
				return bottomLeft;
			}
			
			public Line2D top()
			{
				top.setLine(0,20, 1024, 20);
				
				return top;
			}
			
		//----------------------------------------------------

		
		public void render(Graphics g)
		{
			g.drawImage(im.roof, x, y, 32*Game.SCALE, 32*Game.SCALE, null);
		}
		
		
		
		

}
