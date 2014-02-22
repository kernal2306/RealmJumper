package gamePack.Edit;

import gamePack.Dialog;
import gamePack.Game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.TextField;

public class Editor {
	Game game = new Game();
	Dialog dialog = new Dialog();
	TextField coordText;
	int x, y;
	String coord;
	
	public Editor()
	{
		//this.x = Game.getPlayer().x;
		//this.y = Game.getPlayer().y;
	}
	
	public void coord()
	{
		
		coordText = new TextField(25);
	}
	
	public void dialog()
	{
		System.out.println("You are in edit mode");
		dialog.load();
	}
	
	public void render(Graphics g)
	{
		
		//coord = "x: "+x +" y "+y;
		//Font font = new Font("Verdana", Font.BOLD, 12);
		//coord.setFont(font);
		//coord.setForeground(Color.WHITE);
		g.drawString("x: "+x +" y "+y, 800,20);
	}
	

}
