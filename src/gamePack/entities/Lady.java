package gamePack.entities;

import java.awt.Graphics;
import java.awt.Rectangle;
<<<<<<< HEAD
import java.awt.geom.Line2D;
import java.awt.image.BufferedImage;

=======
import java.awt.image.BufferedImage;
>>>>>>> 9a60eedc09c1646cf7321294f7c12e616dd6aa0b
import gamePack.Game;
import gamePack.Physics;
import gamePack.gfx.ImageManager;
import gamePack.gfx.SpriteSheet;

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
	
<<<<<<< HEAD
	public Line2D rtLine = new Line2D.Float();
	public Line2D upLine = new Line2D.Float();
	public Line2D lfLine = new Line2D.Float();
	public Line2D downLine = new Line2D.Float();
	public int right, left, top, bottom;
	
=======
>>>>>>> 9a60eedc09c1646cf7321294f7c12e616dd6aa0b
	public Lady(int x, int y, ImageManager im, SpriteSheet ss)
	{
		this.x = x;
		this.y = y;
		this.im = im;
		this.ss = ss;
<<<<<<< HEAD
		downLine.setLine(x-16, y+16, x+16, y+16);
	}
	
	//collisionDetection for player class
	public Line2D downBoundsLeft()
	{
		downLine.setLine(x, y+53, x, y+63);
		return downLine;
	}
	public Line2D downBoundsRight()
	{
		downLine.setLine(x+60, y+53, x+60, y+63);
		return downLine;
	}
	public Line2D upBoundsLeft()
	{
		upLine.setLine(x, y, x, y+10);
		return upLine;
	}
	public Line2D upBoundsRight()
	{
		upLine.setLine(x+60, y, x+60, y+10);
		return upLine;
	}
	public Line2D upBoundsMid()
	{
		upLine.setLine(x+30, y-1, x + 30, y-1);
		return upLine;
	}
	public Line2D leftBoundsTop()
	{
		lfLine.setLine(x+60, y-1, x+60, y+63);
		return lfLine;
	}
	public Line2D leftBoundsBottom()
	{
		lfLine.setLine(x, y+63, x, y);
		return lfLine;
	}
	public Line2D rightBoundsTop()
	{
		rtLine.setLine(x, y-1, x, y+63);
		return rtLine;
	}
	public Line2D rightBoundsBottom()
	{
		rtLine.setLine(x, y-1, x, y+63);
		return rtLine;
	}
	
	public boolean DownCollision(Line2D down)
	{		
		if(downBoundsLeft().intersectsLine(down))
		{
			return true;
		}
		if(downBoundsRight().intersectsLine(down))
		{
			return true;
		}
		else return false;
	}
	public boolean UpCollision(Line2D up)
	{
		if(upBoundsLeft().intersectsLine(up))
		{
			return true;
		}
		if(upBoundsRight().intersectsLine(up))
		{
			return true;
		}
		else return false;
	}
	public boolean LeftCollision(Line2D Left)
	{
		if(leftBoundsTop().intersectsLine(Left))
		{
			return true;
		}
		if(leftBoundsBottom().intersectsLine(Left))
		{
			return true;
		}
		else return false;
	}
	public boolean rightCollision(Line2D right)
	{
		if(rightBoundsTop().intersectsLine(right))
		{
			return true;
		}
		if(rightBoundsBottom().intersectsLine(right))
		{
			return true;
		}
		else return false;
	}
=======
	}
	
	public Rectangle bounds()
	{
		return(new Rectangle(x, y, 32, 32));
	}
	
>>>>>>> 9a60eedc09c1646cf7321294f7c12e616dd6aa0b
	
	public void tick()
	{
		y += (p.falling(y, x, t)) / 2;
	}
	

	public void render(Graphics g)
	{
		g.drawImage(im.lady, x, y, 32*Game.SCALE, 32*Game.SCALE, null);
	
	}
}