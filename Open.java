package SysMate;
import SysMate.*;
public class Open
{
	protected static String OpenMenuLoc = "c:\\Users\\jeetu\\Desktop\\Lazy-Beast\\SysMate\\OpenMenu.txt";
	public Open(String Program)throws Exception
		{
			if(Program.equals("-m"))
			{
				new ProcessBuilder("cmd","/c","type "+OpenMenuLoc).inheritIO().start().waitFor();
			}
			
			if(Program.contains("1"))
			{
				if(!Program.equals("1"))
				{
					String subCMD [] = Program.split(" ",2); 
					Runtime.getRuntime().exec("notepad "+subCMD[1]);
				}
				else
				{
					Runtime.getRuntime().exec("notepad");
				}
			}

			if(Program.equals("2"))
			{
					Runtime.getRuntime().exec("mspaint");
			}

			if(Program.contains("3"))
			{
				if(!Program.equals("3"))
				{
					String subCMD [] = Program.split(" ",2); 
					Runtime.getRuntime().exec("C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe "+subCMD[1]);
				}
				else
				{
					Runtime.getRuntime().exec("C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe");
				}
			}

			if(Program.equals("4"))
			{
				Runtime.getRuntime().exec("calc");	
			}

			else
			{
				Runtime.getRuntime().exec(Program);
			}

		}
	public Open()
	{


	}
}