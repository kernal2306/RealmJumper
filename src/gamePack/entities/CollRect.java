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
		top.setLine(0, 0, 0, 0);
		return top;
	}
	
	public Line2D bottom()
	{
		bottom.setLine(0, 0, 0, 0);
		return bottom;
	}
	
	public Line2D left()
	{
		top.setLine(0, 0, 0, 0);
		return left;
	}
	
	public Line2D right()
	{
		top.setLine(0, 0, 0, 0);
		return right;
	}
	
}
