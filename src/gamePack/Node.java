package gamePack;

public class Node {
	public int item;
	public int xLocation;
	public int yLocation;
	public String dialog;
	Node previous;
	Node next;
	
	public Node()
	{
		item = 0;
		xLocation = 0;
		yLocation = 0;
		dialog = null;
		previous = null;
		next = null;		
	}
	
	public void newNode(int x, int y, String newDialog)
	{
		setData(x, y, newDialog);
		item = previous.item +1;
	}
	
	public void setData(int x, int y, String newDialog)
	{
		xLocation = x;
		yLocation = y;
		dialog = newDialog;
	}
	
	public int getNodeNumber()
	{
		return item;
	}
	
	public String getDialog()
	{
		return dialog;
	}
	
	public int getXLocation()
	{
		return xLocation;
	}
	
	public int getYLocation()
	{
		return yLocation;
	}

}
