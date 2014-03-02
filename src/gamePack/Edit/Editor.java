package gamePack.Edit;

import gamePack.Dialog;
import gamePack.Game;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.TextField;

import javax.swing.JTextArea;

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
		g.drawString("x: "+x +" y "+y, 800,20);
	}
	
	public void tick()
	{
		//JTextArea coord = new JTextArea(30, 80);
		//game.frame.add(coord, BorderLayout.CENTER);
		
		//g.setFont(g.getFont().deriveFont(30f));
		//g.drawString("X: " + player.x, 100, 300);
		//g.drawString("Y: " + player.y, 100, 320);
		//Container cp = Game.frame.getContentPane();
		//MyCanvas tl = new MyCanvas();
		//cp.add(tl);
		//cp.setVisible(true);
	}

}
