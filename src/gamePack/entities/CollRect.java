package gamePack.entities;

import java.awt.geom.Line2D;

public class CollRect 
{
	public int width = 0;
	public int height = 0;
	public int x = 0, y = 0;
	public Line2D top = new Line2D.Float();
	public Line2D bottom = new Line2D.Float();
	public Line2D left = new Line2D.Float();
	public Line2D right = new Line2D.Float();
	
	public CollRect(int startX, int startY, int width, int height)
	{
		this.height = height;
		this.width = width;
		this.x = startX;
		this.y = startY;
	}
	
	public Line2D top()
	{
		top.setLine(x, y, x + width, y);
		return top;
	}
	
	public Line2D bottom()
	{
		bottom.setLine(x, y + height, x + width, y + height);
		return bottom;
	}
	
	public Line2D left()
	{
		left.setLine(x, y, x, y + height);
		return left;
	}
	
	public Line2D right()
	{
		right.setLine(x + width, y, x + width, y + height);
		return right;
	}
	
}
