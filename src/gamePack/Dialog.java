package gamePack;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Dialog {
	
	DialogList dialog= new DialogList();
	
	public void load(){
	
	try
	{
		@SuppressWarnings("resource")
		BufferedReader br = new BufferedReader(new FileReader("dialog.txt"));
		//StringBuilder sb = new StringBuilder();
		String line = br.readLine();
		
		while(line != null)
		{
			System.out.print(line + " end of line\n");
		}
	}
	catch (IOException e)
	{
		
	}
	}
}
