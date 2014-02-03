package gamePack.entities;

import java.awt.Graphics;
import gamePack.Game;
import gamePack.gfx.ImageManager;

public class Player 
{
	private int x, y;
	private ImageManager im;
	public boolean up = false, down = false, lt = false, rt = false, jump = false;
	private final int SPEED = 3;
	
	public Player(int x, int y, ImageManager im)
	{
		this.x = x;
		this.y = y;
		this.im = im;
	}
	
	public void tick()
	{
		if (up)
		{
			y -= SPEED * 3;
		}
		if (down)
		{
			y += SPEED;
		} 
		if (lt)
		{
			x -= SPEED;
		}
		if(rt)
		{
			x += SPEED;
		}
		if (jump)
		{
			while(jump == true)
			{
				if (jump)
				{
					
				}
			}
		}
	}
	
	public void render(Graphics g)
	{
		g.drawImage(im.player, x, y, 32*Game.SCALE, 32*Game.SCALE, null);
	}

}
