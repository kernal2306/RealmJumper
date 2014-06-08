package gamePack;

import java.awt.Color;
import java.awt.Graphics;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;
import java.awt.*;
import java.awt.geom.Line2D;

public class Dialog implements Serializable{
	
	DialogList dialogList= new DialogList();
	Node node = new Node();
	//int count = 1;
	public String dialogArray[] = new String[300];
	int arrayCount = 0;
	static int startDialog =0;
	static int endDialog = 103;
	private String displayDialog;
	public Line2D enemyRight = new Line2D.Float();
	public Line2D enemyLeft = new Line2D.Float();
	public Line2D friendRight = new Line2D.Float();
	private String line1, line2, line3, line4;
	
	
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
			System.out.println(dialogArray[count]);
			count++;
		}
		System.out.println(dialogArray[0]);
		
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
		if(Game.dialogShow2 == true)
		{
			getDialog();
			g.setColor(Color.WHITE);
			g.draw3DRect(299, 299, 401, 201, true);
			g.setColor(Color.BLACK);
			g.fill3DRect(300, 300, 400, 200, true);
			g.setFont(g.getFont().deriveFont(30f));
			g.setColor(Color.WHITE);
			g.drawString(line1, 320, 340);
			g.drawString(line2, 320, 380);
			g.drawString(line3, 320, 420);
			g.drawString(line4, 320, 460);
			//drawStringEdit(g, getDialog(), 320, 300);
			g.setColor(Color.GREEN);
			g.setFont(g.getFont().deriveFont(15f));
			g.drawString("please press the 'E' key to continue", 385, 485);
		}
	}
	

	public void dialogDisplay(int dialogCount)
	{
		
		String arrayLine, dialog = "";
		Game.dialogShow2 = true;
		int count = dialogCount;
		if(dialogArray[count+1] == null)
		{
			Game.dialogShow2 = false;
		}
		for(int i=0; i<4; i++)
		{
			arrayLine = dialogArray[count];
			if(count == 100)
			{
				Game.ladyDialog2 = true;
				Game.back2 = Game.back2Again;
			}
			count++;
		}
	}

	/*public void dialogDisplay2(int begin, int end)
	{
		
		
		startDialog = begin;
		endDialog = end;
		String arrayLine, dialog = "";
		Game.dialogShow2 = true;
		//int count = dialogCount;
		if(startDialog >= endDialog)
		{
			Game.dialogShow2 = false;
		}
		for(int i=startDialog; i<startDialog+4; i++)
		{
			arrayLine = dialogArray[i];
			//i++;

			dialog = dialog + arrayLine  +"\n";
			
		}
		
		displayDialog = dialog;
		
	}*/
	
	public String getDialog()
	{
		
		line1 = dialogArray[Game.dialogStart];
		line2 = dialogArray[Game.dialogStart +1];
		line3 = dialogArray[Game.dialogStart +2];
		line4 = dialogArray[Game.dialogStart +3];
		
		
		return displayDialog;
	}
	
	public void tick()
	{
		
		if(Game.curr == Game.roof)
		{
		if(Game.player.rightCollision(this.enemyRight()))
		{
			System.out.print("Enemy being hit");
		}
		
		if(Game.player.x < 512 && (Game.player.y < 736 || Game.player.y > 320))
		{
			System.out.print("You are winning!");
		}
		}
		Game.player.tick();
	}
	
	//collison lines for rooftop dialog
	public Line2D enemyRight()
	{
		enemyRight.setLine(512, 320, 512, 736);
		return enemyRight;
	}
	
	public Line2D enemyLeft()
	{
		enemyLeft.setLine(448, 320, 448, 736);
		return enemyLeft;
	}
	
	public Line2D friendRight()
	{
		friendRight.setLine(192, 672, 192, 736);
		return friendRight;
	}
	
	
}
