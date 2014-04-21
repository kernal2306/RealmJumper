package gamePack.gfx;

import java.awt.image.BufferedImage;

public class SpriteSheet {
	
	private BufferedImage sheet;
	
	public SpriteSheet(BufferedImage sheet)
	{
		this.sheet = sheet;
	}
	
<<<<<<< HEAD
<<<<<<< HEAD
	public  BufferedImage crop(int col, int row, int w, int h)
=======
	public BufferedImage crop(int col, int row, int w, int h)
>>>>>>> tBranch1
=======
	public  BufferedImage crop(int col, int row, int w, int h)
>>>>>>> 9a60eedc09c1646cf7321294f7c12e616dd6aa0b
	{
		return sheet.getSubimage(col * 32, row * 32, w, h);
	}

}
