package gamePack;

import gamePack.Edit.Editor;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyManager implements KeyListener
{
	public boolean editMode = false;
	@Override
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
			Game.getPlayer().jump = true;
		}
		if(e.getKeyCode() == KeyEvent.VK_BACK_SLASH)
		{
			editMode = true;
			if(editMode)
			{
				Editor edit = new Editor();
				edit.coord();
				edit.dialog();
			}
			if(!editMode)
			{
				editMode = false;
			}
		}
		
	}

	@Override
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
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
