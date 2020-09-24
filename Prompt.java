package SysMate;
import java.util.*;
import SysMate.*;
public class Prompt extends SysMate
{
	private String prompt_cmd = "";
	protected static String ModifiedPrompt = ">>>";
	protected static String PromptConsoleWelcomeLoc = "C:\\Users\\jeetu\\Desktop\\SysMate\\SysMate\\PromptConsoleWelcome.txt";

	public Prompt()throws Exception
	{
		Logs log = new Logs();
		new Clear();
		new ProcessBuilder("cmd", "/c", "type "+PromptConsoleWelcomeLoc).inheritIO().start().waitFor();
		System.out.print("\n\nModify the prompt of the Console as You Like ..... \n\n"
				+"Type 'h' to see the usage.\n\n");

		try{
			log.login("Prompt Console");
		while(!prompt_cmd.equals("back")||!prompt_cmd.equals("0"))
			{
				Scanner sc = new Scanner(System.in);
				System.out.print(ModifiedPrompt+"[PROMPT_MODIFICATION]>>>");
				prompt_cmd = sc.nextLine();
				prompt_cmd = prompt_cmd.toLowerCase();
				log.CMD = prompt_cmd;
				log.appendCMD();

				if(prompt_cmd.equals("1")||prompt_cmd.contains("clear")||prompt_cmd.equals("c"))  //For clearing Screen   
						{
							new Clear();	 	
						}

				if(prompt_cmd.equals("help")||prompt_cmd.equals("h")||prompt_cmd.equals("4"))
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
							"	+     eg. p <Design>                                   |  -> p abc@xyz$                                                                       +\n"+
							"	+     eg. prompt <Design>                              |  -> prompt ~WIN@ADMIN#                                                                    +\n"+
							"	+                                                                                                                                          +\n"+
							"	=++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++="
							);	
					}
				if(prompt_cmd.contains("p")||prompt_cmd.contains("prompt"))
					{
						String [] design = prompt_cmd.split(" ",2);
						ModifiedPrompt = design[1]+" ";
					}
				if(prompt_cmd.equals("back")||prompt_cmd.equals("0"))
					{
						log.logout("Prompt Console");
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