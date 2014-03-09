package gamePack.entities;

import java.awt.Graphics;
import java.awt.Rectangle;
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
	
	public Player(int x, int y, ImageManager im, SpriteSheet ss)
	{
		this.x = x;
		this.y = y;
		this.im = im;
		this.ss = ss;
	}
	
	public Rectangle bounds()
	{
		return(new Rectangle(x, y, 32, 32));
	}

	
	public void tick()
	{
		
		if (up)
		{
			//y -= SPEED;
		}
		if (down)
		{
			if(y >= 640)
			{
				this.y = 640;
			}
			y += SPEED;
		} 
		if (lt)
		{
			if(tickCount == 1)
			{
				im.player = ss.crop(0, 0, 32, 32);
			}
			else if(tickCount == 0)
			{
				im.player = ss.crop(2, 0, 32, 32);
			}
			if(x <= 0)
			{
				this.x = 0;
			}
			x -= SPEED;
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
			x += SPEED;
		}
		if (jump)
		{
			y -= p.Jump(y, x, count);
			
			if(y < 640)
			{
				
			}
			if(y <= 620)
			{
				
			}
		    
		}
		else
		{
			if(y <= 640)
			{
				
				y += p.falling(y, x, t);
				//y += SPEED * 3;
			}
		}
	}
	
	public void render(Graphics g)
	{
		g.drawImage(im.player, x, y, 32*Game.SCALE, 32*Game.SCALE, null);
		
	}
	
	public void stop()
	{
		
	}
	

}
