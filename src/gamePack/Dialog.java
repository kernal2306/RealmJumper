package gamePack;

import java.awt.Color;
import java.awt.Graphics;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Dialog {
	
	DialogList dialog= new DialogList();
	//Dialog newLine = new Dialog();
	Node node = new Node();
	
	public String load(){
	
	String line, dialog = null;
	int x, y;
	try
	{
		@SuppressWarnings("resource")
		BufferedReader br = new BufferedReader(new FileReader("res/dialog.txt"));
		//StringBuilder sb = new StringBuilder();
		line = br.readLine();
		
		while(line != null)
		{
			x = Integer.parseInt(line);
			line = br.readLine();
			y = Integer.parseInt(line);
			line = br.readLine();
			dialog = line;
			node.newNode(x, y, dialog);
			line = br.readLine();
			System.out.println(x + " "+ y + " " + dialog);
		}
	}
	catch (IOException e)
	{
		e.printStackTrace();
	}
	return dialog;
	}
	
	public void render(Graphics g)
	{
		g.setFont(g.getFont().deriveFont(30f));
		g.setColor(Color.GREEN);
		g.drawString("Hello Pete", 400,400);
	}
}
