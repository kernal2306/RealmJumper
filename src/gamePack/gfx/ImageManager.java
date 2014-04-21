package gamePack.gfx;

<<<<<<< HEAD
<<<<<<< HEAD
import gamePack.entities.IntroLevel;

=======
>>>>>>> tBranch1
=======
import gamePack.entities.IntroLevel;

>>>>>>> 9a60eedc09c1646cf7321294f7c12e616dd6aa0b
import java.awt.image.BufferedImage;

public class ImageManager 
{
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> 9a60eedc09c1646cf7321294f7c12e616dd6aa0b
	public BufferedImage player, lady, intro;
	public int floorLength;
	SpriteSheet character[];
	SpriteSheet objects[];
	public BufferedImage floor[];
	public int x;
	public int y;
	public int width = 32;
	public int hieght = 32;
<<<<<<< HEAD
=======
	public BufferedImage player;
>>>>>>> tBranch1
=======
>>>>>>> 9a60eedc09c1646cf7321294f7c12e616dd6aa0b
	
	public ImageManager(SpriteSheet ss)
	{
		player = ss.crop(0, 0, 32, 32);
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> 9a60eedc09c1646cf7321294f7c12e616dd6aa0b
		lady = ss.crop(0, 0, 32,32);
		intro = ss.crop(2, 0, 32, 32);
	}
	
	public void intro(SpriteSheet ss)
	{
		for (int i = 0; i <= floorLength; i++)
		{
			x += 32;
			y += 32;
			intro = ss.crop(y, x, width, hieght);
			floor[i] = intro;
		}
<<<<<<< HEAD
=======
>>>>>>> tBranch1
=======
>>>>>>> 9a60eedc09c1646cf7321294f7c12e616dd6aa0b
	}
}
