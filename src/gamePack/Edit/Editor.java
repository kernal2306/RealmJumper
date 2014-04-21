package gamePack.Edit;

import gamePack.Dialog;
import gamePack.Game;
import gamePack.KeyManager;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.TextField;

public class Editor {
	Game game = new Game();
	Dialog dialog = new Dialog();
	KeyManager km = new KeyManager();
	TextField coordText;
	int x, y;
	String coord;
	public boolean editBool;
	
	public Editor()
	{
		this.x = Game.getPlayer().x;
		this.y = Game.getPlayer().y;
	}
	
	public void coord()
	{
		
		
	}
	
	public void dialog()
	{
		System.out.println("You are in edit mode");
		//dialog.load();
	}
	
	public void render(Graphics g)
	{
		
			g.setFont(g.getFont().deriveFont(30f));
			g.setColor(Color.GREEN);
			g.drawString("x: "+ Game.getPlayer().x +" y "+ Game.getPlayer().y, 800,40);
	}
	
	public void tick()
	{
		
	}

}
