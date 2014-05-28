
package gamePack;

import gamePack.Edit.Editor;
import gamePack.entities.IntroLevel;
import gamePack.entities.Lady;
import gamePack.entities.Player;
import gamePack.entities.RoofLevel;
import gamePack.gfx.Background;
import gamePack.gfx.ImageLoader;
import gamePack.gfx.ImageManager;
import gamePack.gfx.SpriteSheet;

import java.awt.*;
import java.awt.geom.Line2D;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

import javax.swing.*;

public class Game extends Canvas implements Runnable
{
	private static final long serialVersionUID = 1L;
	public static final int WIDTH = 512, HEIGHT = 384, SCALE = 2;
	public static boolean running = false;
	public Thread gameThread;

	public static  JFrame frame;
	public static  JLabel dialogBox;
	public static  boolean dialogShow = false;
	public  Line2D downObjects[];
	public  int count;	
	private BufferedImage spriteSheet1;
	private BufferedImage background1, background2;
	private ImageManager im;
	private Image bg;
	private static  Player player;
	private  Physics p;
	private  Lady lady;
	private IntroLevel intro;
	private RoofLevel  roof;
	private  Editor editor;
	private CurrentLevel curr;
	private  Background back, back2;
	private  Dialog dialog;
	private KeyManager key;
	static int dialogCount = 0;
	int t = 0;
	public int setBack = 1;
	
	public void init()
	{
		ImageLoader loader = new ImageLoader();
		spriteSheet1 = loader.load("/SpriteSheet.png");
		background1 = loader.load("/background.png");
		background2 = loader.load("/background2.png");
		SpriteSheet ss = new SpriteSheet(spriteSheet1);
		im = new ImageManager(ss);
		
		//set location of sprites on the sreen
		//make floor
		intro = new IntroLevel(500, 700, im, ss);
		roof = new RoofLevel(500, 700, im, ss);
		player = new Player(50,200,im, ss);
		lady = new Lady(800, 200, im, ss);
		editor = new Editor();
		back = new Background(background1);
		back2 = new Background(background2);
		curr = intro;
		dialog = new Dialog();
		key = new KeyManager();
		dialog.load();
		this.addKeyListener(new KeyManager());
	}
	
	public synchronized void start()
	{
		if(running)return;
		running = true;
		gameThread = new Thread(this);
		gameThread.start();
	}
	
	public synchronized void stop()
	{
		if(!running)return;
		running = false;
		try {
			gameThread.join();
		} catch (InterruptedException e) {e.printStackTrace();}
	}
	
	public void run()
	{
		init();
		long lastTime = System.nanoTime();
		final double amountOfTicks = 60D;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		
		while(running)
		{
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			if(delta >= 1)
			{
				tick();
				delta--;
			}
			render();
		}
		stop();
	}
	
	public void tick()
	{
		curr.tick();
	}
		
	public void render()
	{
		BufferStrategy bs = this.getBufferStrategy();
		dialogBox.setVisible(dialogShow);
		if(bs == null)
		{
			createBufferStrategy(3);
			return;
		}
		Graphics g = bs.getDrawGraphics();
		//RENDER HERE
		g.fillRect(0, 0, WIDTH * SCALE, HEIGHT * SCALE);
		if (curr == intro)
		{
			back.render(g);
			player.render(g);
			lady.render(g);
		}
		if (curr == roof)
		{
			back2.render(g);
			player.render(g);
			lady.render(g);
		}
		
		//END RENDER
		bs.show();
		g.dispose();
	}
	
	public static void main(String[] args)
	{
		Game game = new Game();
		game.setPreferredSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
		game.setMaximumSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
		game.setMinimumSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
		frame = new JFrame("Realm Jumper");
		frame.setBounds(400, 100, WIDTH * SCALE, HEIGHT * SCALE);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.add(game);
		frame.setVisible(true);
		dialogBox= new JLabel("testing to see");
		dialogBox.setBackground(Color.black);
		dialogBox.setForeground(Color.green);
		game.start();
	}
	
	public static Player getPlayer()
	{
		return player;
	}
}

