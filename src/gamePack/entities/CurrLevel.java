package gamePack.entities;


import java.awt.Graphics;
import java.awt.geom.Line2D;

import gamePack.Dialog;
import gamePack.Game;
import gamePack.KeyManager;
import gamePack.Physics;
import gamePack.Edit.Editor;
import gamePack.gfx.Background;
import gamePack.gfx.ImageManager;
import gamePack.gfx.SpriteSheet;


public class CurrLevel 
{
	public int x;
	public int y;
	private int t;
	int numTiles = 50;
	double count = 1;
	int tickCount = 1;
	private ImageManager im;
	public boolean up = false, down = false, lt = false, rt = false, jump = false, free = false;
	Physics p = new Physics();
	private SpriteSheet ss;
	private Game game;
	private Player player;
	private IntroLevel intro;
	private Dialog dialog;
	private Lady lady;
	
	
	public CurrLevel(int x, int y, ImageManager im, SpriteSheet ss)
	{
		this.im = im;
		this.ss = ss;
		this.x = x;
		this.y = y;
		
		player = new Player(50,200,im, ss);
	
	}
	
	
	public void tick()
	{
		//player.tick();
		intro.tick();
		//dialog.tick();
		
	}
}
