package gamePack;

public class Physics {
	
	public int getX(int x, double t)
	{
		x = (int) Math.log1p(Math.pow(t, 2)); //t>0
		return x;
	}
	
	public int getY(int y, double t)
	{
		y = (int) (Math.pow(-4.9*t, 2) + 15*t + 22);
		return y;
	}

	public void Jump(int y, int x, double t)
	{
			while (t > 0)
			{
				x = getX(x, t);
				y = getY(y,t);
			}
		}
	
	public void falling(int y, int x, double t)
	{
		while(t > 0)
		{
		y = getY(y, t);
		y--;
		}
	}
}
