package gamePack.Edit;

import gamePack.Game;

import java.awt.Graphics;

public class Editor {
	Game game = new Game();
	int x, y;
	
	public Editor()
	{
		//this.x = Game.getPlayer().x;
		//this.y = Game.getPlayer().y;
	}
	
	public void coord()
	{
		
	}
	
	public void dialog()
	{
		System.out.println("You are in edit mode");
	}
	
	public void render(Graphics g)
	{
		g.drawString("x: "+x +" y "+y, 800,20);
		//g.drawImage(im.player, x, y, 32*Game.SCALE, 32*Game.SCALE, null);
	}

}
