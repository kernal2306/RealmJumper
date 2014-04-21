package gamePack;

public class DialogList 
{
	public Node head;
	public int value;
	public DialogList next;
	
	public DialogList()
	{
		head = null;
	}
	
	public void addToStart(int x, int y, String newDialog)
	{
		head = new Node();
		head.newNode(x, y, newDialog);
	}
	
	private Node find(int target)
	{
		Node position = head;
		int itemAtPosition;
		
		while(position != null)
		{
			itemAtPosition = position.getNodeNumber();
			if(itemAtPosition == target)
			{
				return position;
			}
			
			
			
			
			position = position.next;
		}
		return null;
	}

}
