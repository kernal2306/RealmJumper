import java.awt.*;
import javax.swing.JFrame;
public class RealmJumper extends JFrame
{

	public static void main(String[] args) 
	{
		DisplayMode dm = new DisplayMode(1024, 768, 16, DisplayMode.REFRESH_RATE_UNKNOWN);
		RealmJumper rj = new RealmJumper();
		rj.run(dm);
	}
	
	public void run(DisplayMode dm)
	{
		setBackground(Color.GRAY);
		setForeground(Color.GREEN);
		setFont(new Font("Arial",Font.PLAIN, 24));
		
		Screen s = new Screen();
		try
		{
			s.setFullScreen(dm, this);
			try
			{
				Thread.sleep(5000);
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
			}
		}
		finally
		{
			s.restoreScreen();
		}
	}
	
	public void paint(Graphics g)
	{
		g.drawString("This is the screen!", 500, 300);
	}

}
