package gamePack;

import java.awt.Color;
import java.awt.Graphics;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.awt.*;

public class Dialog {
	
	DialogList dialogList= new DialogList();
	//Dialog newLine = new Dialog();
	//Dialog dialog = new Dialog();
	Node node = new Node();
	int count = 1;
	String tempArray;
	
	
	public String load(){
	String line = null, dialog = "";
	int x, y;
	
	
	try
	{
		@SuppressWarnings("resource")
		BufferedReader br = new BufferedReader(new FileReader("res/dialog.txt"));
		
		
		//line = br.readLine();
		//dialog = line;
		for(int i=0; i<4; i++)
		{
			line = br.readLine();
			if (line != null)
			{
				dialog = dialog + line  +"\n";
			}
		}
		
		//line = br.readLine();
		//dialog = line;
		
		/*while(line != null)
		{
			x = Integer.parseInt(line);
			line = br.readLine();
			y = Integer.parseInt(line);
			line = br.readLine();
			dialog = line;
			node.newNode(x, y, dialog);
			line = br.readLine();
			System.out.println(x + " "+ y + " " + dialog);
		}*/
	}
	catch (IOException e)
	{
		e.printStackTrace();
	}
	return dialog;
	}
	
	
	private void drawStringEdit(Graphics g, String text, int x, int y) {
        for (String editLine : text.split("\n"))
            g.drawString(editLine, x, y += g.getFontMetrics().getHeight());
    }
	
	public void render(Graphics g)
	{
		if(Game.dialogShow == true)
		{
			g.setColor(Color.WHITE);
			
			g.draw3DRect(299, 299, 401, 201, true);
			g.setColor(Color.BLACK);
			g.fill3DRect(300, 300, 400, 200, true);
			g.setFont(g.getFont().deriveFont(30f));
			g.setColor(Color.WHITE);
			drawStringEdit(g, load(), 320, 300);
			g.setColor(Color.GREEN);
			g.setFont(g.getFont().deriveFont(15f));
			g.drawString("please press the 'E' key to continue", 385, 485);
		}
	}
}
