package gamePack.entities;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.geom.Line2D;
import java.awt.geom.Line2D.Float;
import java.awt.image.BufferedImage;

import gamePack.Game;
import gamePack.Physics;
import gamePack.gfx.ImageManager;
import gamePack.gfx.SpriteSheet;

import java.awt.Rectangle;

public class Player 
{
	public int x;
	public int y;
	private int t;
	double count = 1;
	int tickCount = 1;
	private ImageManager im;
	public boolean up = false, down = false, lt = false, rt = false, jump = false;
	private final int SPEED = 3;
	Physics p = new Physics();
	private SpriteSheet ss;
	private IntroLevel intro;
	Line2D lfLine = new Line2D.Float();
	Line2D rtLine = new Line2D.Float();
	Line2D upLine = new Line2D.Float();
	public Line2D downLine;
	
	public Player(int x, int y, ImageManager im, SpriteSheet ss)
	{
		this.x = x;
		this.y = y;
		this.im = im;
		this.ss = ss;
	}
	
	//collisionDetection for player class
	public Line2D downBounds()
	{
		downLine = new Line2D.Double(x, y+16, 32, 32);
		return downLine;
	}
	public Line2D upBounds()
	{
		upLine = new Line2D.Double(x, y-16, 32, 32);
		return upLine;
	}
	public Line2D leftBounds()
	{
		lfLine = new Line2D.Double(x-16, y, 32, 32);
		return lfLine;
	}
	public Line2D rightBounds()
	{
		rtLine = new Line2D.Double(x+16, y, 32 ,32);
		return rtLine;
	}
	
	public boolean DownCollision(Line2D down)
	{		
		if(downBounds().intersectsLine(down))
		{
			return true;
		}
		else return false;
	}
	public boolean UpCollision(Line2D down)
	{
		if(upBounds().intersectsLine(upLine))
		{
			return true;
		}
		else return false;
	}
	public boolean LeftCollision(Line2D Left)
	{
		if(leftBounds().intersectsLine(Left))
		{
			return true;
		}
		else return false;
	}
	public boolean rightCollision(Line2D right)
	{
		if(rightBounds().intersectsLine(right))
		{
			return true;
		}
		else return false;
	}
	
	//player tick method
	public void tick()
	{
		
		
		if (up)
		{
			
		}
		if (down)
		{
			y += SPEED;
		}
		if (lt)
		{
			if(tickCount == 0)
			{
				im.player = ss.crop(0, 0, 32, 32);
				tickCount = 1;
			}
			else if(tickCount == 1)
			{
				im.player = ss.crop(2, 0, 32, 32);
				tickCount = 0;
			}
			if(x <= 0)
			{
				this.x = 0;
			}
			x -= SPEED * 1.5;
		}
		if(rt)
		{
			if (tickCount == 0)
			{
				im.player = ss.crop(0, 1, 32, 32);
				tickCount = 1;
			}
			else if(tickCount == 1)
			{
				im.player = ss.crop(2, 1, 32, 32);
				tickCount = 0;
			}
			if((x > 958))
			{
				this.x = 958;
			}
			x += SPEED * 1.5;
		}
		if (jump)
		{
			y -= (p.Jump(y, x, count));
			
			if(count > 1)
			{
				y += (p.falling(y, x, t)) / 2;
			}
		}
		else	
			y += (p.falling(y, x, t)) / 2;
				//y += SPEED * 3;
			}
	
	public void render(Graphics g)
	{
		g.drawImage(im.player, x, y, 32*Game.SCALE, 32*Game.SCALE, null);
		
	}
	
	public void stop()
	{
		up = false;
		down = false;
		lt = false;
		rt = false;
		jump = false;
		
	}
	

}
