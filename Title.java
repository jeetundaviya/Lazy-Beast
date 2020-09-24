package SysMate;
import java.util.*;
import SysMate.*;
public class Title extends SysMate
{
	private String title_cmd = "";
	protected static String TitleConsoleWelcomeLoc = "C:\\Users\\jeetu\\Desktop\\SysMate\\SysMate\\TitleConsoleWelcome.txt";
	
	public Title() throws Exception
	{
		new Clear();
		new ProcessBuilder("cmd", "/c", "type "+TitleConsoleWelcomeLoc).inheritIO().start().waitFor();
		System.out.print("\n\nModify the title of the Console as You Like ..... \n\n"
				+"Type 'h' to see the usage.\n\n");
	try{
		Logs log = new Logs();
		log.login("Title Console ");
		while(!title_cmd.equals("back")||!title_cmd.equals("0"))
			{
				Scanner sc = new Scanner(System.in);
				System.out.print(Prompt.ModifiedPrompt+"[TITLE_MODIFICATION]>>>");
				title_cmd = sc.nextLine();
				title_cmd = title_cmd.toLowerCase();
				log.CMD = title_cmd;
				log.appendCMD();

				if(title_cmd.equals("1")||title_cmd.contains("clear")||title_cmd.equals("c"))  //For clearing Screen   
						{
							new Clear();	 	
						}

				if(title_cmd.equals("help")||title_cmd.equals("h")||title_cmd.equals("4"))
					{
						System.out.println( 
							"	=++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++=\n"+
							"	+                                                         _   _ _____ _     ____                                                           +\n"+
							"	+                                                        | | | | ____| |   |  _ \\                                                         +\n"+
							"	+                                                        | |_| |  _| | |   | |_) |                                                         +\n"+
							"	+                                                        |  _  | |___| |___|  __/                                                          +\n"+
							"	+                                                        |_| |_|_____|_____|_|                                                             +\n"+
							"	+                                                                                                                                          +\n"+
							"	+                                                                                                                                          +\n"+
							"	+   USAGE :-                                                                                                                               +\n"+							
							"	+                                                                                                                                          +\n"+
							"	+     eg. t <NAME>                                  |  -> t anyname                                                                        +\n"+
							"	+     eg. title <NAME>                              |  -> title anyname                                                                    +\n"+
							"	+                                                                                                                                          +\n"+
							"	=++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++="
							);	
					}
				if(title_cmd.contains("t")||title_cmd.contains("title"))
					{
						String [] name = title_cmd.split(" ",2);
						new ProcessBuilder("cmd","/c","title "+name[1]).inheritIO().start().waitFor();
					}
				if(title_cmd.equals("back")||title_cmd.equals("0"))
					{
						log.logout("Title Console");
						break;
					}

			}
		}
		catch(Exception e)
		{
			System.out.println("Opps...Somethong Unsual Happened ");
			System.out.println("Exception Details:- "+e);
		}
	}

}



