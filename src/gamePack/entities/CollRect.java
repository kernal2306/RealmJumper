package gamePack.entities;

import java.awt.geom.Line2D;

public class CollRect 
{
	public int width = 0;
	public int height = 0;
	public int x = 0, y = 0;
	
	public CollRect(int startX, int startY, int width, int height)
	{
		this.height = height;
		this.width = width;
		this.x = startX;
		this.y = startY;
	}
	
	/*public Line2D top()
	{
		
	}*/
	
}
