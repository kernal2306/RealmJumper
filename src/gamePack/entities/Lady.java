package gamePack.entities;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import gamePack.Game;
import gamePack.Physics;
import gamePack.gfx.ImageManager;
import gamePack.gfx.SpriteSheet;
import java.awt.Rectangle;

public class Lady 
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
	
	public Lady(int x, int y, ImageManager im, SpriteSheet ss)
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
		
	}
	

	public void render(Graphics g)
	{
		g.drawImage(im.lady, x, y, 32*Game.SCALE, 32*Game.SCALE, null);
	
	}
}