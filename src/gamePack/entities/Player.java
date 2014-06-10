package gamePack.entities;
import java.awt.Graphics;
import java.awt.geom.Line2D;
import gamePack.Game;
import gamePack.Physics;
import gamePack.gfx.ImageManager;
import gamePack.gfx.SpriteSheet;


public class Player 
{
	public int x;
	public int y;
	private int t;
	double count = 1;
	int tickCount = 1;
	private ImageManager im;
	public boolean up = false, down = false, lt = false, rt = false, jump = false, free = false;
	private final int SPEED = 3;
	Physics p = new Physics();
	private SpriteSheet ss;
	private IntroLevel intro;
	private Realm2_2 realm2_2;
	Line2D lfLine = new Line2D.Float();
	Line2D rtLine = new Line2D.Float();
	Line2D upLine = new Line2D.Float();
	Line2D downLine = new Line2D.Float();
	public Object player;


	//right/left collision line (top)
	Line2D rltLineT = new Line2D.Float();
	
	//right/left collision line (middle)
	Line2D rltLineM = new Line2D.Float();
	
	//right/left collision line (bottom)
	Line2D rltLineB = new Line2D.Float();
	
	//down/up collision line (right)
	Line2D downUpRight = new Line2D.Float();
	
	//down/up collision line (middle)
	Line2D downUpMiddle = new Line2D.Float();
	
	//down/up collision line (left)
	Line2D downUpLeft = new Line2D.Float();


	public Player(int x, int y, ImageManager im, SpriteSheet ss)
	{
		this.x = x;
		this.y = y;
		this.im = im;
		this.ss = ss;
		
	}
	//collisionDetection for player class
//---------------------------------------------------//
	
	public Line2D downUpBoundsLeft()
	{
		downUpLeft.setLine(x, y, x, y+63);
		return downUpLeft;
	}
	public Line2D downUpBoundsMid()
	{
		downUpMiddle.setLine(x+30,y,x+30,y+63);
		return downUpMiddle;
	}
	public Line2D downUpBoundsRight()
	{
		downUpRight.setLine(x+60, y, x+60, y+63);
		return downUpRight;
	}
	
//----------------------------------------------------//
	
	public Line2D leftRightBoundsTop()
	{
		rltLineT.setLine(x, y, x+60, y);
		return rltLineT;
	}
	public Line2D leftRightBoundsMiddle()
	{
		rltLineM.setLine(x,y+33,x+60,y+33);
		return rltLineM;
	}
	public Line2D leftRightBoundsBottom()
	{
		rltLineB.setLine(x,y+63,x+60,y+63);
		return rltLineB;
	}
	
//-----------------------------------------------------//
	
	//test for a collision on the bottom of the player
	public boolean DownCollision(Line2D down)
	{		
		if(downUpBoundsLeft().intersectsLine(down))
		{
			return true;
		}
		if(downUpBoundsRight().intersectsLine(down))
		{
			return true;
		}
		if(downUpBoundsMid().intersectsLine(down))
		{
			return true;
		}
		return false;
	}
	//tests for a collision on the top of the player
	public boolean UpCollision(Line2D up)
	{
		if(downUpBoundsLeft().intersectsLine(up))
		{
			return true;
		}
		if(downUpBoundsRight().intersectsLine(up))
		{
			return true;
		}
		if(downUpBoundsMid().intersectsLine(up))
		{
			return true;
		}
		return false;
	}
	//tests for a collision on the left of the player
	public boolean LeftCollision(Line2D Left)
	{
		if(leftRightBoundsTop().intersectsLine(Left))
		{
			return true;
		}
		if(leftRightBoundsMiddle().intersectsLine(Left))
		{
			return true;
		}
		if(leftRightBoundsBottom().intersectsLine(Left))
		{
			return true;
		}
		
		return false;
	}
	//tests for a collision on the right of the player
	public boolean rightCollision(Line2D right)
	{
		if(leftRightBoundsTop().intersectsLine(right))
		{
			return true;
		}
		if(leftRightBoundsBottom().intersectsLine(right))
		{
			return true;
		}
		if(leftRightBoundsBottom().intersectsLine(right))
		{
			return true;
		}
		
		return false;
	}
	
	
	//player tick method
	public void tick()
	{
		if (up)
		{
			y -= SPEED;
			
		}
		if (down)
		{
			//y += SPEED;
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
			this.x -= SPEED * 1.5;
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
		}
			
		if(jump && rt)
		{
			y -= (p.Jump(y, x, count)) / 5;
			x += SPEED * 2;
		}
		if(jump && lt)
		{
			y -= (p.Jump(y, x, count)) / 5;
			x -= SPEED * 2;
		}
		else
		{
			this.y += (p.falling(y, x, t)) / 3.5;
				y += SPEED * 3;
		}
		
	}
	
	public void render(Graphics g)
	{
		g.drawImage(im.player, x, y, 32*Game.SCALE, 32*Game.SCALE, null);
		
		//left vertical collision line
		//g.drawLine(x, y, x, y+63);
		//right vertical collision line
		//g.drawLine(x+60, y, x+60, y+63);
		//middle vertical collision line
		//g.drawLine(x+30,y,x+30,y+63);
		//top horizontal collision line
		//g.drawLine(x, y, x+60, y);
		//middle horizontal collision line
		//g.drawLine(x,y+33,x+60,y+33);
		//bottom horizontal collision line
		//g.drawLine(x,y+63,x+60,y+63);
	}
	
}
