package gamePack;

import java.awt.Color;
import java.awt.Graphics;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.awt.*;

public class Dialog {
	
	DialogList dialogList= new DialogList();
	//KeyManager km = new KeyManager();
	//Dialog newLine = new Dialog();
	//Dialog dialog = new Dialog();
	Node node = new Node();
	//int count = 1;
	String dialogArray[] = new String[100];
	int arrayCount = 0;
	private String displayDialog;
	
	
	public String load(){
	String line = null, dialog = "";
	//public String dialogReturn;
	int count=0;
	try
	{
		@SuppressWarnings("resource")
		BufferedReader br = new BufferedReader(new FileReader("res/dialog.txt"));
		
		
		while((line = br.readLine())!= null)
		{
			//line = br.readLine();
			dialogArray[count] = line;
			//dialog = dialog + line + "\n";
			System.out.println(dialogArray[count]);
			count++;
		}
		/*for(int i=0; i<4; i++)
		{
			line = br.readLine();
			if (line != null)
			{
				dialog = dialog + line  +"\n";
			}
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
			//load();
			g.setColor(Color.WHITE);
			
			g.draw3DRect(299, 299, 401, 201, true);
			g.setColor(Color.BLACK);
			g.fill3DRect(300, 300, 400, 200, true);
			g.setFont(g.getFont().deriveFont(30f));
			g.setColor(Color.WHITE);
			drawStringEdit(g, getDialog(), 320, 300);
			g.setColor(Color.GREEN);
			g.setFont(g.getFont().deriveFont(15f));
			g.drawString("please press the 'E' key to continue", 385, 485);
		}
	}
	
	public void dialogDisplay(int dialogCount)
	{
		
		String arrayLine, dialog = "";
		//System.out.println(dialogArray[0]);
		Game.dialogShow = true;
		int count = dialogCount;
		if(dialogArray[count+1] == null)
		{
			Game.dialogShow = false;
			Game.getPlayer().x = Game.getPlayer().x-1;
		}
		for(int i=0; i<4; i++)
		{
			arrayLine = dialogArray[count];
			//System.out.println(arrayLine+ "Hey there");
			count++;
			dialog = dialog + arrayLine  +"\n";
			
		}
		
		displayDialog = dialog;
		
	}
	
	public String getDialog()
	{
		//String displayDialog = ;
		return displayDialog;
	}
	
}
