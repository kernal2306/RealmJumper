package gamePack.gfx;

import java.awt.GraphicsConfiguration;
import java.awt.image.BufferedImage;

public class Background {
	
		
		private BufferedImage background;
		
		public Background(BufferedImage background)
		{
			this.background = background;
		}
		
		public  BufferedImage getBackground()
		{
			return background;
		}


}
