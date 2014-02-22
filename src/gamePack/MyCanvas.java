package gamePack;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JComponent;

public class MyCanvas extends JComponent{
	public void paintComponent(Graphics g)
	{
		if(g instanceof Graphics2D)
		{
			Graphics2D g2 = (Graphics2D)g;
			g2.drawString("This is gonna be awesome", 100, 100);
		}
		
	}

}
