package gamePack;

import gamePack.Edit.Editor;
import gamePack.entities.Player;
import gamePack.gfx.Background;
import gamePack.gfx.ImageLoader;
import gamePack.gfx.ImageManager;
import gamePack.gfx.SpriteSheet;

import java.awt.*;
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
	public static boolean dialogShow = true;
	
	private BufferedImage spriteSheet;
	private static BufferedImage background;
	
	private ImageManager im;
	private static Background bg;
	
	private static Player player;
	private static Editor editor;
	
	public void init()
	{
		ImageLoader loader = new ImageLoader();
		spriteSheet = loader.load("/SpriteSheet.png");
		
		SpriteSheet ss = new SpriteSheet(spriteSheet);
		
		im = new ImageManager(ss);
		
		
		player = new Player(50,600,im, ss);
		editor = new Editor();
		
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
		player.tick();
		editor.tick();
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
		editor.render(g);
		player.render(g);
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
		//background = bg.getBackground();
		//frame.setContentPane(new JFrame());
		
		dialogBox= new JLabel("testing to see");
		dialogBox.setBounds(200, 200, 200, 200);
		dialogBox.setForeground(Color.green);
		
		frame.add(dialogBox, BorderLayout.NORTH);
		
		
		
		game.start();
	}
	
	public static Player getPlayer()
	{
		return player;
	}
}
