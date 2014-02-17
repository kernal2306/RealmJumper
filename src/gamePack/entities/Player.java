package gamePack.entities;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import gamePack.Game;
import gamePack.Physics;
import gamePack.gfx.ImageManager;
import gamePack.gfx.SpriteSheet;

public class Player 
{
	public int x;
	public int y;
	private int t;
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
			if(x <= 0)
			{
				this.x = 0;
			}
			x -= SPEED;
		}
		if(rt)
		{
			im.player = ss.crop(2, 1, 32, 32);
			if(x > 1000)
			{
				this.x = -40;
			}
			x += SPEED;
		}
		if (jump)
		{
			t = 10;
			//if(y )
			y -= SPEED *3;
			p.Jump(x, y, t);
		}
	}
	
	public void render(Graphics g)
	{
		g.drawImage(im.player, x, y, 32*Game.SCALE, 32*Game.SCALE, null);
	}

}
