package gamePack;

<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> 9a60eedc09c1646cf7321294f7c12e616dd6aa0b
import gamePack.Edit.Editor;

import java.awt.BorderLayout;
import java.awt.Graphics;
<<<<<<< HEAD
=======
>>>>>>> tBranch1
=======
>>>>>>> 9a60eedc09c1646cf7321294f7c12e616dd6aa0b
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyManager implements KeyListener
{
<<<<<<< HEAD
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
=======
	public boolean editMode = false;
	Dialog dialog = new Dialog();
	int kmCount =0;
	int begin, end;
	
	
	
	public void keyPressed(KeyEvent e) 
	{
		
>>>>>>> 9a60eedc09c1646cf7321294f7c12e616dd6aa0b

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
<<<<<<< HEAD
=======
>>>>>>> 9a60eedc09c1646cf7321294f7c12e616dd6aa0b
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
<<<<<<< HEAD
			Game.dialogCount += 4;
			dialog.dialogDisplay(Game.dialogCount);
=======
			begin = Dialog.startDialog;
			end = Dialog.endDialog;
			begin += 4;
			dialog.dialogDisplay(begin, end);
>>>>>>> 9a60eedc09c1646cf7321294f7c12e616dd6aa0b
			if (Game.dialogShow == false)
			{
				
			}
<<<<<<< HEAD
		}
	}
	
=======
		
	}

	@Override
>>>>>>> tBranch1
=======
			Game.getPlayer().free = true;
		}
	}
	
>>>>>>> 9a60eedc09c1646cf7321294f7c12e616dd6aa0b
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
