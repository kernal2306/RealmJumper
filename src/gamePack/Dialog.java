package gamePack;

import java.awt.Color;
import java.awt.Graphics;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.awt.*;

public class Dialog {
	
	DialogList dialogList= new DialogList();
	Node node = new Node();
	//int count = 1;
	String dialogArray[] = new String[150];
	int arrayCount = 0;
	static int startDialog =0;
	static int endDialog = 103;
	private String displayDialog;
	
	
	public String load(){
	String line = null, dialog = "";
	int count=0;
	try
	{
		@SuppressWarnings("resource")
		BufferedReader br = new BufferedReader(new FileReader("res/dialog.txt"));
		
		
		while((line = br.readLine())!= null)
		{
			dialogArray[count] = line;
			count++;
		}
		
	}
	catch (IOException e)
	{
		e.printStackTrace();
	}
	return dialog;
	}
	
	
	//private void drawStringEdit(Graphics g, String text, int x, int y) {
     //   for (String editLine : text.split("\n"))
        //    g.drawString(editLine, x, y += g.getFontMetrics().getHeight());
   // }
	
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
			//drawStringEdit(g, getDialog(), 320, 300);
			g.setColor(Color.GREEN);
			g.setFont(g.getFont().deriveFont(15f));
			g.drawString("please press the 'E' key to continue", 385, 485);
		}
	}
	

	public void dialogDisplay(int dialogCount)
	{
		
		String arrayLine, dialog = "";
		Game.dialogShow = true;
		int count = dialogCount;
		if(dialogArray[count+1] == null)
		{
			Game.dialogShow = false;
		}
		for(int i=0; i<4; i++)
		{
			arrayLine = dialogArray[count];
			count++;
		}
	}

	public void dialogDisplay(int begin, int end)
	{
		
		
		startDialog = begin;
		endDialog = end;
		String arrayLine, dialog = "";
		Game.dialogShow = true;
		//int count = dialogCount;
		if(startDialog >= endDialog)
		{
			Game.dialogShow = false;
		}
		for(int i=startDialog; i<startDialog+4; i++)
		{
			arrayLine = dialogArray[i];
			//i++;

			dialog = dialog + arrayLine  +"\n";
			
		}
		
		displayDialog = dialog;
		
	}
	
	public String getDialog()
	{
		return displayDialog;
	}
	
}
