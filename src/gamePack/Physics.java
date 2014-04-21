package gamePack;

<<<<<<< HEAD
<<<<<<< HEAD
public class Physics 
{
=======
public class Physics {
>>>>>>> tBranch1
=======
public class Physics 
{
>>>>>>> 9a60eedc09c1646cf7321294f7c12e616dd6aa0b
	
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
=======
	public int Jump(int y, int x, double t)
>>>>>>> 9a60eedc09c1646cf7321294f7c12e616dd6aa0b
	{
		x = getX(x, t) / 2;
		y = getY(y,t) / 2;
		
		return y--;
	}
	
<<<<<<< HEAD
>>>>>>> tBranch1
=======
	public int falling(int y, int x, double t)
	{
		y = getY(y, t);
		return y++;
	}
>>>>>>> 9a60eedc09c1646cf7321294f7c12e616dd6aa0b
}
