package gamePack.entities;

import java.awt.Graphics;

import gamePack.Game;
import gamePack.gfx.SpriteSheet;

public class Player 
{
	private int x, y;
	private SpriteSheet ss;
	
	public Player(int x, int y, SpriteSheet ss)
	{
		this.x = x;
		this.y = y;
		this.ss = ss;
	}
	
	public void tick()
	{
		
	}
	
	public void render(Graphics g)
	{
		g.drawImage(ss.crop(0, 0, 32, 32), x, y, 32*Game.SCALE, 32*Game.SCALE, null);
	}
}
