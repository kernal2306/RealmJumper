package gamePack;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Dialog {
	
	DialogList dialog= new DialogList();
	
	public void load(){
	
	String line;
	try
	{
		@SuppressWarnings("resource")
		BufferedReader br = new BufferedReader(new FileReader("res/dialog.txt"));
		//StringBuilder sb = new StringBuilder();
		line = br.readLine();
		
		while(line != null)
		{
			System.out.println(line);
			line = br.readLine();
		}
	}
	catch (IOException e)
	{
		
	}
	}
}
