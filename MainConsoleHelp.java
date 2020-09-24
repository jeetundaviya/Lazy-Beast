package SysMate;
public class MainConsoleHelp
{
	protected static String MainConsoleHelpLoc =  "C:\\Users\\jeetu\\Desktop\\SysMate\\SysMate\\MainConsoleHelp.txt";
	public MainConsoleHelp()
	{
					try{

  					new ProcessBuilder("cmd", "/c", "type "+MainConsoleHelpLoc).inheritIO().start().waitFor();
    				
					}
					catch(Exception e)
					{
						System.out.println(e);
					}
	}
}