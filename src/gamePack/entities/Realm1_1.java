package gamePack.entities;

import gamePack.CurrentLevel;
import gamePack.Game;
import gamePack.Physics;
import gamePack.gfx.ImageManager;
import gamePack.gfx.SpriteSheet;

import java.awt.Graphics;
import java.awt.geom.Line2D;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Realm1_1 implements CurrentLevel
{
	public int x;
	public int y;
	private int t, count;
	private ImageManager im;
	Physics p = new Physics();
	CollRect rect;
	private SpriteSheet ss;
	private Player player;
	File cFile = new File("res/Realm1_1Coord.txt");
	public ArrayList<CollRect> realm1_1Objects = new ArrayList<CollRect>();
	
	public Line2D floorLine = new Line2D.Float();
	public Line2D door1Line = new Line2D.Float();
	public Line2D enemyRight = new Line2D.Float();
	public Line2D enemyLeft= new Line2D.Float();
	public Line2D friendRight = new Line2D.Float();
	public Line2D portalRight = new Line2D.Float();
	
	//bounds for floor
		public int floor = 730;
		
		public Realm1_1(int x, int y, ImageManager im, SpriteSheet ss, Player plyr)
		{
			this.im = im;
			this.ss = ss;
			player = plyr;
					
		}
		
		@SuppressWarnings("unused")
		public void tick()
		{
			for(CollRect rect: realm1_1Objects)
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
			
			if(Game.player.rightCollision(this.friendRight()))
			{
				System.out.print("Friend being hit");
				Game.dialogShow2 = true;
				Game.player.x = 185;
				//Game.dialogCount = 104;
				Game.dialogStart = 136;
				Game.dialogStop = 199;
				/*if((Game.dialogStart+4 >= Game.dialogStop))
				{
					Game.ladyDialog = false;
				}*/
				//Game.dialog.dialogDisplay2(24, 27);
				
			}
			
			/*if(Game.player.LeftCollision(this.enemyLeft()))
			{
				System.out.print("Enemy being hit");
				Game.dialogShow2 = true;
				Game.player.x = 370;
				//Game.dialogCount = 104;
				Game.dialogStart = 104;
				Game.dialogStop = 107;
				//Game.dialog.dialogDisplay2(24, 27);
				
			}*/
			
			/*if(Game.player.rightCollision(this.friendRight()))
			{
				System.out.print("Friend being hit");
				Game.dialogShow2 = true;
				Game.player.x = 192;
				//Game.dialogCount = 104;
				Game.dialogStart = 0;
				Game.dialogStop = 103;
				
			}*/
			
			/*if(Game.player.rightCollision(this.friendRight()))
			{
				System.out.print("Friend being hit");
				Game.dialogShow2 = true;
				Game.player.x = 852;
				//Game.dialogCount = 104;
				Game.dialogStart = 0;
				Game.dialogStop = 104;
				if((Game.dialogStart+4 >= Game.dialogStop))
				{
					Game.ladyDialog = false;
				}
				//Game.dialog.dialogDisplay2(24, 27);
				
			}*/
			
			if(Game.player.rightCollision(this.portalRight()))
			{
				System.out.print("portal collision");
				Game.curr = Game.realm1_2;
				player.x = 100;
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
						realm1_1Objects.add(new CollRect(tmp[0], tmp[1], tmp[2], tmp[3]));
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
			for(CollRect rect: realm1_1Objects)
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
		
		

			/*public Line2D enemyRight()
			{
				enemyRight.setLine(900, 700, 900, 768);
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
				
			}*/
			
			public Line2D portalRight()
			{
				portalRight.setLine(1014,0, 1014, 736);
				return portalRight;
			}
			
			public Line2D friendRight()
			{
				
				
				
				friendRight.setLine(180, 500, 180, 736);
				
				//System.out.println("lady false");
				
				return friendRight;
				
			}
			
		//----------------------------------------------------

		
		public void render(Graphics g)
		{
			g.drawImage(im.roof, x, y, 32*Game.SCALE, 32*Game.SCALE, null);
		}

}
