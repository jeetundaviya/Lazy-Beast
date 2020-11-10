package SysMate;
import SysMate.*;
import java.util.*;
import java.io.*;


public class SysMate

{
	protected String cmd = "";
	protected String prompt = ">>>";
	protected String IntroDesignDirLoc;
	protected String MainConsoleWelcomeLoc;

	protected String [] Program;
	//protected String StartDateTime = getDateTime.getCurrentDateTime();

	//All paths and locations for loading files 
	{
	MainConsoleWelcomeLoc = "C:\\Users\\jeetu\\Desktop\\Lazy-Beast\\SysMate\\MainConsoleWelcome.txt"; 
	IntroDesignDirLoc = "C:\\Users\\jeetu\\Desktop\\Lazy-Beast\\SysMate\\Intro\\";

	//You can Change Paths when required..........
	Colors.ColorsConsoleWelcomeLoc = Colors.ColorsConsoleWelcomeLoc ;
	MainConsoleHelp.MainConsoleHelpLoc = MainConsoleHelp.MainConsoleHelpLoc;
	Title.TitleConsoleWelcomeLoc = Title.TitleConsoleWelcomeLoc;
	Logs.OutputLoc = "C:\\Users\\jeetu\\Desktop\\Lazy-Beast\\SysMate\\Logs\\"+"Logs"+".txt";
	Open.OpenMenuLoc = Open.OpenMenuLoc;
	}

	public SysMate(){}

	public SysMate(String cmd) throws Exception
	{
		Random random = new Random();
		int intro = random.nextInt(25);
		new ProcessBuilder("cmd", "/c", "chcp 65001 && cls && title Lazy Beast && type "+IntroDesignDirLoc+Integer.toString(intro)+".txt").inheritIO().start().waitFor(); //->here chcp 65001 is for changing encoding to utf-8 -->Here we are typing IntroDesign in ascii code
		
		new ProcessBuilder("cmd", "/c", "type "+MainConsoleWelcomeLoc).inheritIO().start().waitFor();  //Typing Welcome text
	}

	public void MainConsole()throws Exception
		{
			Scanner sc = new Scanner(System.in);
			prompt = ">>>";
			Logs log = new Logs();

		try{

			log.login("Main Console");

			while(!cmd.equals("close")||!cmd.equals("3"))
				
			{

					try
					{
						System.out.print(prompt);
						cmd = sc.nextLine();
						cmd = cmd.toLowerCase();
						log.CMD = cmd;
						log.appendCMD();

					// ....................................................................................................................................................
					
					if(cmd.equals("1")||cmd.contains("clear")||cmd.equals("c"))  //For clearing Screen   
						{
							new Clear();	 	
						}

					//.......................................................................................................................................................

					if(cmd.contains("open")||cmd.startsWith("2")) //For Opning Programs Or Open Menu
					{

						if (!cmd.equals("open")||!cmd.equals("2"))
							{
								Program = cmd.split(" ",2);
								new Open(Program[1]);
							}
						
					}

					//.......................................................................................................................................................

					if(cmd.contains("close")||cmd.startsWith("3")) //For closing any program.......
					{
							
							if (cmd.equals("close")||cmd.equals("3"))
								{
									log.logout("Main Console");
									new ProcessBuilder("cmd","/c","title Lazy Beast").inheritIO().start().waitFor();
									Runtime.getRuntime().exec("taskkill /fi \"windowtitle eq "+"Lazy Beast"+"*\"");
								}
							else
								{
									if(cmd.contains("-all")) //this will close all the smilar programs......
									{
										Program = cmd.split(" ",3);
										Runtime.getRuntime().exec("taskkill /fi \"imagename eq "+Program[2]+"\"");
									}

									Program = cmd.split(" ",2);
									Runtime.getRuntime().exec("taskkill /fi \"windowtitle eq "+Program[1]+"*\"");
								}

					}

					//.......................................................................................................................................................				

					if(cmd.equals("4")||cmd.equals("help")||cmd.equals("h"))  //for opning help text file
					{
						new MainConsoleHelp();
					}

					//.......................................................................................................................................................
					
					if(cmd.contains("modify")||cmd.startsWith("5"))   //For Modifing color,title,prompt
					{
							Colors color =  new Colors();
							if(cmd.contains("color"))
							{
								color.ModifyColors();
							}

							if(cmd.contains("title"))
							{
								new Title();
							}

							if(cmd.contains("prompt"))
							{
									new Prompt();
								prompt = Prompt.ModifiedPrompt;
							}

							if(cmd.contains("off")) //this will get back you to default settings 
							{
								prompt = ">>>";
								Prompt.ModifiedPrompt = ">>>"; //it will change the previous modification of prompt.
								new ProcessBuilder("cmd","/c","title Lazy Beast").inheritIO().start().waitFor(); //title will  be Lazy Beast 
								color.StopCoolMode(color.StopCoolModePID); //to stop the cool mode if running
								color.DefaultColour();

								//new ProcessBuilder("cmd","/c","color 07").inheritIO().start().waitFor(); //black background and white forground

							}
					}

					//.......................................................................................................................................................

					if(cmd.startsWith("syscmd") || cmd.startsWith("6"))       // For Starting SysCmd or running SysCmd commands
					{
						if(cmd.equals("syscmd") || cmd.equals("6"))
						{
							new SysCmd(prompt);
						}
						else
						{  
							Program = cmd.split(" ",2);
							if(Program[1].equals("-n"))
							{
								new SysCmd();
							}
							else
							{
								new SysCmd(prompt,Program[1]);
							}

							
						}
					}

					//.......................................................................................................................................................

					if(cmd.equals("pycmd")||cmd.equals("7"))   //For opening python console
					{
						// try
						// {
							log.login("PyCmd (new window)");
							Runtime.getRuntime().exec("cmd /c start cmd.exe /k \"title PyCmd && echo Welcome to PyCmd ....... && python\"");
						// }catch(Exception e)
						// {
						// 	System.out.println("Opps...Somethong Unsual Happened ");
						// 	System.out.println("Exception Details:- "+e);
						// }
					}
					//.......................................................................................................................................................

					if(cmd.contains("archive")||cmd.startsWith("8")||cmd.contains("arc"))  //For Archiving files and folders 
					{
						if(cmd.equals("archive")||cmd.equals("8")||cmd.equals("arc"))
						{
							new Archive();  //Opens gui for 7z file manager.
						}
						else
						{
							Program = cmd.split(" ");
							new Archive(Program[1],Program[2],Program[3]);
						}
					}
					//.......................................................................................................................................................
					if(cmd.contains("sysnet")||cmd.startsWith("9")||cmd.contains("net")) //For running networking commands
					{
						if(cmd.equals("sysnet")||cmd.equals("9")||cmd.equals("net"))
						{
							new SysNet("-m");
						}
						else
						{
							Program = cmd.split(" ",2);
							new SysNet(Program[1]);
						}
					}
					//.......................................................................................................................................................


				 }catch(Exception e)
			 		{
			 		System.out.println("Opps...Somethong Unsual Happened ");
					System.out.println("Exception Details:- "+e);
			 		}
			}
		 }catch(Exception e)
		 {
		 	System.out.println("Opps...Somethong Unsual Happened ");
			System.out.println("Exception Details:- "+e);
		 }
		}


	
	public static void main(String[] args) throws Exception
	{
		SysMate obj = new SysMate("");
		obj.MainConsole();

	}
}