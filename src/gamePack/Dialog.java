package gamePack;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Dialog {
	
	DialogList dialog= new DialogList();
	Node node = new Node();
	
	public void load(){
	
	String line, dialog;
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
	}
}
