package gamePack;

<<<<<<< HEAD
import gamePack.Edit.Editor;

import java.awt.BorderLayout;
import java.awt.Graphics;
=======
>>>>>>> tBranch1
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyManager implements KeyListener
{
<<<<<<< HEAD
	public boolean editMode = false;
	Dialog dialog = new Dialog();
	int kmCount =0;
	
	
	
	public void keyPressed(KeyEvent e) 
	{
		
=======
	@Override
	public void keyPressed(KeyEvent e) 
	{

>>>>>>> tBranch1

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
<<<<<<< HEAD
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
			if (Game.dialogShow == false)
			{
				
			}
		}
	}
	
=======
		
	}

	@Override
>>>>>>> tBranch1
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
