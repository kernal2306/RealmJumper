package gamePack.entities;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.geom.Line2D;
import java.awt.image.BufferedImage;
import gamePack.Game;
import gamePack.Physics;
import gamePack.gfx.ImageManager;
import gamePack.gfx.SpriteSheet;

public class RoofLevel
{
	public int x;
	public int y;
	private int t;
	int numTiles = 50;
	double count = 1;
	int tickCount = 1;
	private ImageManager im;
	Physics p = new Physics();
	private SpriteSheet ss;
	Line2D introObjects[];
	public Line2D floorLine = new Line2D.Float();
	public Line2D rtLine = new Line2D.Float();
	public Line2D upLine = new Line2D.Float();
	public Line2D downLine = new Line2D.Float();
	public Line2D platform1Top = new Line2D.Float();
	public Line2D platform2Top = new Line2D.Float();
	public Line2D platform3Top = new Line2D.Float();
	public Line2D platform4Top = new Line2D.Float();
	public Line2D platform5Top = new Line2D.Float();
	public Line2D platform1Bottom = new Line2D.Float();
	public Line2D platform1Right = new Line2D.Float();
	public Line2D platform1Left = new Line2D.Float();
	public Line2D door1Line = new Line2D.Float();
	
	public void render(Graphics g)
	{
		g.drawImage(im.intro, x, y, 32*Game.SCALE, 32*Game.SCALE, null);
		g.drawImage(im.roof, x, y, 32*Game.SCALE, 32*Game.SCALE, null);
	}
}