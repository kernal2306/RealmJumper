
package gamePack;

import gamePack.Edit.Editor;
import gamePack.entities.IntroLevel;
import gamePack.entities.Lady;
import gamePack.entities.Player;
import gamePack.entities.Realm1_1;
import gamePack.entities.Realm1_2;
import gamePack.entities.Realm2_1;
import gamePack.entities.Realm2_2;
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
	public static boolean ladyDialog = false;
	public static boolean ladyDialog2 = false;
	public static int dialogBool=0;
	public Thread gameThread;

	public static  JFrame frame;
	public static  JLabel dialogBox;
	public static  boolean dialogShow = false;
	public static boolean dialogShow2 = false;
	public  Line2D downObjects[];
	public  int count;	
	private BufferedImage spriteSheet1;
	private BufferedImage background1, background2, background2_2, background2_1, background1_2, background1_1;
	public static BufferedImage back2NoLady;
	public static BufferedImage Back2NoLady1;
	private ImageManager im;
	private Image bg;
	public static Player player;
	private  Physics p;
	private  Lady lady;
	public static IntroLevel intro;
	public static RoofLevel  roof;
	public static Realm2_2 realm2_2;
	public static Realm2_1 realm2_1;
	public static Realm1_2 realm1_2;
	public static Realm1_1 realm1_1;
	private  Editor editor;
	public static CurrentLevel curr;
	private  Background back;
	public static Background back2;
	private Background back2_2, back2_1, back1_1, back1_2;
	public static  Dialog dialog;
	private KeyManager key;
	public static int dialogCount = 0;
	public static int dialogStart =5;
	public static int dialogStop = 0;
	int t = 0;
	public int setBack = 1;
	public static Background back2Again;
	
	public void init()
	{
		ImageLoader loader = new ImageLoader();
		spriteSheet1 = loader.load("/SpriteSheet.png");
		background1 = loader.load("/background.png");
		background2 = loader.load("/background2.png");
		back2NoLady = loader.load("/Back2NoLady.png");
		background2_2 = loader.load("/background2_2.png");
		background2_1 = loader.load("/background2_1.png");
		background1_2 = loader.load("/background1_2.png");
		background1_1 = loader.load("/background1_1.png");
		SpriteSheet ss = new SpriteSheet(spriteSheet1);
		im = new ImageManager(ss);
		
		//set location of sprites on the sreen
		//make floor
		
		
		player = new Player(50,200,im, ss);
		intro = new IntroLevel(500, 700, im, ss, player);
		roof = new RoofLevel(500, 700, im, ss, player);
		realm2_2 = new Realm2_2(500, 700, im, ss, player);
		realm2_1 = new Realm2_1(500, 700, im, ss, player);
		realm1_2 = new Realm1_2(500, 700, im, ss, player);
		realm1_1 = new Realm1_1(500, 700, im, ss, player);
		lady = new Lady(800, 200, im, ss);
		editor = new Editor();
		back = new Background(background1);
		back2 = new Background(background2);
		back2Again = new Background(back2NoLady);
		back2_2 = new Background(background2_2);
		back2_1 = new Background(background2_1);
		back1_2 = new Background(background1_2);
		back1_1 = new Background(background1_1);
		curr = intro;
		dialog = new Dialog();
		key = new KeyManager();
		dialog.load();
		this.addKeyListener(key);
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
		//dialog.tick();
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
			//lady.render(g);
		}
		if (curr == roof)
		{
			if(ladyDialog2 == false)
			{
				back2.render(g);
			}
			if(ladyDialog2 == true)
			{
				back2Again.render(g);
			}
			player.render(g);
			dialog.render(g);
			//lady.render(g);
		}
		if(curr == realm2_2)
		{
			back2_2.render(g);
			player.render(g);			
			dialog.render(g);
		}
		if(curr == realm2_1)
		{
			back2_1.render(g);
			player.render(g);
			dialog.render(g);
			
		}
		if(curr == realm1_2)
		{
			back1_2.render(g);
			player.render(g);
			dialog.render(g);
			
		}
		if(curr == realm1_1)
		{
			back1_1.render(g);
			player.render(g);
			dialog.render(g);
			
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

