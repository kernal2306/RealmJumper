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
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
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
	
	private BufferedImage spriteSheet;
	private static BufferedImage background;
	
	private ImageManager im;
	private static Image bg;
	
	private static Player player;
	private static Editor editor;
	private static Background back;
	private static Dialog dialog;
	
	public void init()
	{
		ImageLoader loader = new ImageLoader();
		spriteSheet = loader.load("/SpriteSheet.png");
		background = loader.load("/background.png");
		
		SpriteSheet ss = new SpriteSheet(spriteSheet);
		//Background bg = new Background(background);
		
		im = new ImageManager(ss);
		
		
		player = new Player(50,600,im, ss);
		editor = new Editor();
		back = new Background(background);
		dialog = new Dialog();
		
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
		dialogBox.setVisible(dialogShow);
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
		editor.render(g);
		dialog.render(g);
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
		//myJFrame.setContentPane(new ImagePanel(myImage));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//frame.setContentPane(new ImagePanel());
		//setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("test.jpg")))));
		/*try {
			frame.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("res/background.png")))));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		frame.setResizable(false);
		frame.add(game);
		frame.setVisible(true);
		//background = bg.getBackground();
		//frame.setContentPane(new JFrame());
		
		dialogBox= new JLabel("testing to see");
		//dialogBox.setBorder(BorderFactory.createLineBorder(Color.BLACK));  
	    //Dimension d = dialogBox.getPreferredSize();  
	    //dialogBox.setPreferredSize(new Dimension(d.width+60,d.height));
		//dialogBox.setBounds(200, 200, 200, 200);
		dialogBox.setBackground(Color.black);
		dialogBox.setForeground(Color.green);
		
		
		
		
		
		
		
		game.start();
	}
	
	public static Player getPlayer()
	{
		return player;
	}
}
