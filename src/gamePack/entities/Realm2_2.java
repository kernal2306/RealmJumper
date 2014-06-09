package gamePack.entities;

import java.awt.Graphics;
import java.awt.geom.Line2D;

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
		public Line2D portalRight = new Line2D.Float();
	//bounds for floor
		public int floor = 700;
		
		public Realm2_2(int x, int y, ImageManager im, SpriteSheet ss, Player plyr)
		{
			this.im = im;
			this.ss = ss;
			player = plyr;
			this.x = x;
			this.y = y;
					
		}
		
		public void render(Graphics g)
		{
			g.drawImage(im.realm2_2, x, y, 32*Game.SCALE, 32*Game.SCALE, null);
		}

		@SuppressWarnings("unused")
		public void tick() 
		{
			if (player.y >= this.floorBounds().getY1() - 73)
			{
				player.y = floor -73;
				//Game.dialogShow = true;
				//System.out.println("DownCollision");
				
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
			
		
		
		
		

}
