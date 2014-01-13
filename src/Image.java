import java.awt.*;
import javax.swing.JFrame;
import javax.swing.ImageIcon;

public class Image extends JFrame
{

	public static void main(String[] args) 
	{
		DisplayMode dm = new DisplayMode(1024, 768, 16, DisplayMode.REFRESH_RATE_UNKNOWN);
		Image i = new Image();
		i.run(dm);
	}
	
	private Screen s;
	private java.awt.Image bg;
	private boolean loaded;
	
	public void run(DisplayMode dm)
	{
		//setBackground(Color.GRAY);
		setForeground(Color.GREEN);
		setFont(new Font("Arial",Font.PLAIN, 24));
		loaded = false;
		
		s = new Screen();
		try
		{
			s.setFullScreen(dm, this);
			loadPics();
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
	
	public void loadPics()
	{
		bg = new ImageIcon("C:\\test\\Background.jpg").getImage();
		loaded = true;
		repaint();
		
	}
	
	public void paint(Graphics g)
	{
		if(loaded)
		{
			g.drawImage(bg, 0, 0, null);
			
		}
	}

}
