package gamePack;
import gamePack.Edit.Editor;
import gamePack.entities.IntroLevel;
import gamePack.entities.Lady;
import gamePack.entities.Player;
import gamePack.entities.RoofLevel;
import gamePack.gfx.Background;
import gamePack.gfx.ImageManager;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;


public class KeyManager implements KeyListener
{
	public boolean editMode = false;
	Dialog dialog = new Dialog();
	int kmCount =0;
	int begin, end;
	boolean key_Down = false;
	
	public KeyManager()
	{
		
	}
	
	public void keyPressed(KeyEvent e) 
	{

		if(e.getKeyCode() == KeyEvent.VK_W)
		{
			Game.getPlayer().up = true;
		}
		if(e.getKeyCode() == KeyEvent.VK_S)
		{
			Game.getPlayer().down = true;
		}
		if(e.getKeyCode() == KeyEvent.VK_A)
		{
			Game.getPlayer().lt = true;
		}
		if(e.getKeyCode() == KeyEvent.VK_D)
		{
			Game.getPlayer().rt = true;
		}
		if(e.getKeyCode() == KeyEvent.VK_SPACE)
		{
			if(key_Down == false){
			Game.getPlayer().jump = true;
			key_Down = true;
			}else{
				Game.getPlayer().jump = false;	
			}
			
		}
		if(e.getKeyCode() == KeyEvent.VK_BACK_SLASH)
		{
			if(!editMode) 
			{
				editMode = true;
			}
			else
			{
				editMode = false;
			}
			if(editMode)
			{
				Editor edit = new Editor();
				edit.coord();
				edit.dialog();
				edit.editBool = true;
			}
			if(!editMode)
			{
				editMode = false;
				System.out.println("You are no longer in edit mode");
			}
		}
		if(e.getKeyCode() == KeyEvent.VK_E)
		{

			Game.dialogCount += 4;
			dialog.dialogDisplay(Game.dialogCount);

			begin = Dialog.startDialog;
			end = Dialog.endDialog;
			begin += 4;
			dialog.dialogDisplay(begin, end);
			if (Game.dialogShow == false)
			{
				
			}
		}
	}
	

	public void keyReleased(KeyEvent e) 
	{
		if(e.getKeyCode() == KeyEvent.VK_W)
		{
			Game.getPlayer().up = false;
		}
		if(e.getKeyCode() == KeyEvent.VK_S)
		{
			Game.getPlayer().down = false;
		}
		if(e.getKeyCode() == KeyEvent.VK_A)
		{
			Game.getPlayer().lt = false;
		}
		if(e.getKeyCode() == KeyEvent.VK_D)
		{
			Game.getPlayer().rt = false;
		}
		if(e.getKeyCode() == KeyEvent.VK_SPACE)
		{
			Game.getPlayer().jump = false;
			key_Down = false;
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
