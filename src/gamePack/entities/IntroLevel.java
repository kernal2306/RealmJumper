package gamePack.entities;
import java.awt.Graphics;
import java.awt.geom.Line2D;

import gamePack.CurrentLevel;
import gamePack.Game;
import gamePack.Physics;
import gamePack.gfx.ImageManager;
import gamePack.gfx.SpriteSheet;

public class IntroLevel implements CurrentLevel
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
	
	
	//bounds for floor
	public int floor = 640;
	
	//bounds for first test platform
	public int p1up = 500;
	public int p1down = 560;
	public int p1Left = 100;
	public int p1Right = 300;	
	
	//bounds for platform 5 platform
	public int p5up =97;
	public int p5down = 129;
	public int p5Left = 672;
	public int p5Right = 765;
	
	//bounds for platform 4
	public int p4up =223;
	public int p4down = 0;
	public int p4Left = 768;
	public int p4Right = 864;
	
	//bounds for platform 3
	public int p3up;
	public int p3down;
	public int p3Left;
	public int p3Right;
	

	public int p1Lup = 482;
	public int p1Ldown;
	public int p1Lleft;
	public int p1Lright;	
	
	public int p2Lup = 353;
	public int p2Ldown;
	public int p2Lleft;
	public int p2Lright;	
	
	public int p0Lup = 610;
	public int p0Ldown;
	public int p0Lleft;
	public int p0Lright;	
	
	
	public IntroLevel(int x, int y, ImageManager im, SpriteSheet ss, Player plyr)
	{
		this.im = im;
		this.ss = ss;
		player = plyr;	
	}
	
	public void tick()
	{
		
		//test if player is colliding with the floor
		if (player.y >= this.floorBounds().getY1() - 73)
		{
			player.y = floor -73;
			//Game.dialogShow = true;
			//System.out.println("DownCollision");
			
		}
		//test if player is colliding with platforms top
		if(player.DownCollision(this.platform1TopBounds()))
		{
			player.y = p1up - 73;
			//Game.dialogShow = true;
			//System.out.println("DownCollision");
		}

		if(player.DownCollision(this.platform1LTopBounds()))
		{
			player.y = p1Lup - 73;
			//Game.dialogShow = true;
			//System.out.println("DownCollision");
		}
		
		if(player.DownCollision(this.platform2LTopBounds()))
		{
			player.y = p2Lup - 73;
			//Game.dialogShow = true;
			//System.out.println("DownCollision");
		}
		
		if(player.DownCollision(this.platform0LTopBounds()))
		{
			player.y = p0Lup - 73;
			//Game.dialogShow = true;
			//System.out.println("DownCollision");
		}
				
		if(player.DownCollision(this.platform2RTopBounds()))
		{
			player.y =p2Lup - 73;
			//Game.dialogShow = true;
			//System.out.println("DownCollision");
		}
		
		if(player.DownCollision(this.platform0RTopBounds()))
		{
			player.y = p0Lup - 73;
			//Game.dialogShow = true;
			//System.out.println("DownCollision");
		}
				
		if(player.DownCollision(this.platform1RTopBounds()))
		{
			player.y = p1Lup - 73;
			//Game.dialogShow = true;
			//System.out.println("DownCollision");
		}
				
			if(player.DownCollision(this.platform5TopBounds()))
		{
			player.y = p5up - 73;
			//Game.dialogShow = true;
			//System.out.println("DownCollision");
		}
		
		if(player.DownCollision(this.door()) && player.up == true)
		{
			//System.out.println(Game.dialog.dialogArray[23]);
			Game.curr = Game.roof;
			player.x = 900;
			player.y = 700;
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
	
	public Line2D door()
	{
		door1Line.setLine(672, p5up-16, 768, p5up-16);
		return door1Line;
	}

	
//-----------------------------------------------------------	
	
	//left side intro level collision platforms
	public Line2D platform1LTopBounds()
	{
		platform1LTop.setLine(258, 482, 350,482);
		return platform1LTop;
	}
	public Line2D platform2LTopBounds()
	{
		platform2LTop.setLine(350, 353, 443,353);
		return platform2LTop;
	}
	public Line2D platform0LTopBounds()
	{
		platform0LTop.setLine(500, 610, 255,610);
		return platform1LTop;
	}
	
	//Right side intro level collision platforms
	public Line2D platform1RTopBounds()
	{
		platform1LTop.setLine(258, 482, 350,482);
		return platform1LTop;
	}
	public Line2D platform2RTopBounds()
	{
		platform2RTop.setLine(575, 353, 670, 353);
		return platform2RTop;
	}
	public Line2D platform0RTopBounds()
	{
		platform0RTop.setLine(767, 610, 865, 610);
		return platform0RTop;
	}
//----------------------------------------------------
	
	

	public Line2D platform1TopBounds()
	{
		platform1Top.setLine(100, 500, 300, 500);
		return platform1Top;
	}
	public Line2D platform2TopBounds()
	{
		platform2Top.setLine(100, 500, 300, 500);
		return platform2Top;
	}
	public Line2D platform3TopBounds()

	{
		platform3Top.setLine(p1Left, p1up, p1Right, p1up);
		return platform1Top;
	}
	public Line2D platform4TopBounds()
	{
		platform4Top.setLine(p4Left, p4up, p4Right, p4up);
		return platform4Top;
	}
	public Line2D platform5TopBounds()
	{
		platform5Top.setLine(672, p5up, 768, p5up);
		return platform5Top;
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

	
	public void render(Graphics g)
	{

		int testLinex = 767;
		int testLine2x = testLinex + 95;

		g.drawImage(im.intro, x, y, 32*Game.SCALE, 32*Game.SCALE, null);getClass();
		
		//floor line 
		g.drawLine(-100, floor, 1024, floor);
		
		//test box lines

		g.drawLine(575, 353, 670, 353);
		//g.drawLine(100, 560, 300, 560);
		//g.drawLine(100, 500, 100, 560);
		//g.drawLine(300, 500, 300, 560);

		g.drawLine(100, 500, 300,500);
		g.drawLine(100, 560, 300, 560);
		g.drawLine(100, 500, 100, 560);
		g.drawLine(300, 500, 300, 560);

		
		//platform lines at top of area one
		g.drawLine(673, 97, 765, 97);
		
	}
}

