package gamePack;

<<<<<<< HEAD
public class Physics 
{
=======
public class Physics {
>>>>>>> tBranch1
	
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

<<<<<<< HEAD
	public int Jump(int y, int x, double t)
	{
		x = getX(x, t) / 2;
		y = getY(y,t) / 2;
		
		return y--;
	}
	
	public int falling(int y, int x, double t)
	{
		y = getY(y, t);
		return y++;
	}
=======
	public void Jump(int y, int x, double t)
	{
		x = getX(x, t);
		y = getY(y,t);
	}
	
>>>>>>> tBranch1
}
