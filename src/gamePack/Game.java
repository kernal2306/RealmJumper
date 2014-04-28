package gamePack;

import gamePack.Edit.Editor;
import gamePack.entities.IntroLevel;
import gamePack.entities.Lady;
import gamePack.entities.Player;
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

	public static JFrame frame;
	public static JLabel dialogBox;
	public static boolean dialogShow = false;
	public static Line2D downObjects[];
	public static int count;	
	private BufferedImage spriteSheet1;
	private static BufferedImage background1;
	private ImageManager im;
	private static Image bg;
	private static Player player;
	private static Physics p;
	private static Lady lady;
	private static IntroLevel intro;
	private static Collision col;
	private static Editor editor;
	private static Background back;
	private static Dialog dialog;
	private KeyManager key;
	static int dialogCount = 0;
	int t = 0;
	
	public void init()
	{
		ImageLoader loader = new ImageLoader();
		spriteSheet1 = loader.load("/SpriteSheet.png");
		background1 = loader.load("/background.png");
		SpriteSheet ss = new SpriteSheet(spriteSheet1);
		im = new ImageManager(ss);
		
		//set location of sprites on the sreen
		//make floor
		intro = new IntroLevel(500, 700, im, ss);
		player = new Player(50,200,im, ss);
		lady = new Lady(800, 200, im, ss);
		editor = new Editor();
		back = new Background(background1);
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

		//test if player is colliding with the floor
		if (player.DownCollision(intro.floorLine))
		{
			player.y = intro.floor - 73;
			Game.dialogShow = true;
			System.out.println("DownCollision");
		}
		
		//test if player is coliding with platforms top
		if(player.DownCollision(intro.platform1TopBounds()))
		{
			player.y = intro.p1up - 73;
			Game.dialogShow = true;
			System.out.println("DownCollision");
		}
		if(player.DownCollision(intro.platform5TopBounds()))
		{
			player.y = intro.p5up - 73;
			Game.dialogShow = true;
			System.out.println("DownCollision");
		}
		if(player.DownCollision(intro.platform4TopBounds()))
		{
			player.y = intro.p4up - 73;
			Game.dialogShow = true;
			System.out.println("DownCollision");
		}
		
		//test if player is coliding with platforms bottom
		if(player.UpCollision(intro.platform1BottomBounds()))
		{
			player.jump = false;
			player.down = true;
			System.out.println("upCollision");
		}
		
		//player collision with lady
		if(lady.DownCollision(intro.floorLine))
		{
			lady.y = intro.floor - 72;
		}
		if(player.rightCollision(lady.leftBoundsBottom()))
		{
			player.x = lady.x;
			System.out.println("collide");
		}
		else
		editor.tick();
		player.tick();
		lady.tick();
		intro.tick();
		dialog.dialogDisplay(dialogCount);
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
		back.render(g);
		intro.render(g);
		//editor.render(g);
		//dialog.render(g);
		player.render(g);
		lady.render(g);
		
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
