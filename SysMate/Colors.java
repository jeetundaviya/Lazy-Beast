package SysMate;
import java.util.*;
import java.io.*;
import SysMate.*;
class Colors extends SysMate
{
	private String color_cmd="";
	private String colors [] = {"A","B","C","D","E","F","1","2","3","4","5","6","7","8","9"};
	private String color = "07";
	private String color1="";
	private	String color2="";
	protected static String ColorsConsoleWelcomeLoc = "C:\\Users\\jeetu\\Desktop\\SysMate\\SysMate\\ColorsConsoleWelcome.txt";
	public void ModifyColors()throws Exception
	{
		Logs log = new Logs();
		log.login();
				Scanner sc = new Scanner(System.in);

			{                                             //initial starting
				try
				{
					new ProcessBuilder("cmd","/c","type "+ColorsConsoleWelcomeLoc).inheritIO().start().waitFor();
				}
				catch(Exception e)
				{
					System.out.println(e);
				}

				System.out.print("\n\nModify the colours of Text and Background of the Console as You Like ..... \n\n"
				+"Type 'h' to see the various options\n\n");
			}
				while(!color_cmd.equals("back")||!color_cmd.equals("0"))
					{
							System.out.print(Prompt.ModifiedPrompt+"[COLOUR_MODIFICATION]>>>");
							color_cmd = sc.nextLine();
							color_cmd = color_cmd.toLowerCase();
							
							log.CMD = color_cmd;
							log.appendCMD();
							
							if(color_cmd.equals("clear")||color_cmd.equals("1")||color_cmd.equals("c"))
							{
								new Clear();
							}

							if(color_cmd.equals("back")||color_cmd.equals("0"))
							{
								log.logout();
								break;
							}
							if(color_cmd.equals("default")||color_cmd.equals("use 1"))
							{
								DefaultColours();
							}

							if(color_cmd.equals("random_forground")||color_cmd.equals("use 3"))
							{
								RandomizeColour(3);
							}

							if(color_cmd.equals("swap")||color_cmd.equals("use 2"))
							{
								RandomizeColour(4);
							}

							if(color_cmd.equals("random_forground_with_black_background")||color_cmd.equals("use 4"))
							{
								RandomizeColour(1);
							}

							if(color_cmd.equals("random_background")||color_cmd.equals("use 5"))
							{
								RandomizeColour(2);
							}

							if(color_cmd.equals("random")||color_cmd.equals("use 6"))
							{
								RandomizeColour(5);
							}

							if(color_cmd.contains("color"))
							{
							try
							{
							new ProcessBuilder("cmd", "/c", color_cmd).inheritIO().start().waitFor(); //USER DEFINED COLOR
							color1 = Character.toString(color_cmd.charAt(1));
							color2 = Character.toString(color_cmd.charAt(0));
							}
							catch(Exception e)
							{
							System.out.println(e);
							}
							}


							if(color_cmd.equals("help")||color_cmd.equals("h")||color_cmd.equals("4"))
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
							"	+  HEX CODES:-                                                                                                                             +\n"+
                            "	+                                                                                                                                          +\n"+
                            "	+   0 = Black       8 = Gray                                                                                                               +\n"+
						    "	+   1 = Blue        9 = Light Blue                                                                                                         +\n"+
						    "	+   2 = Green       A = Light Green                                                                                                        +\n"+
						    "	+   3 = Aqua        B = Light Aqua                                                                                                         +\n"+
						    "	+   4 = Red         C = Light Red                                                                                                          +\n"+
						    "	+   5 = Purple      D = Light Purple                                                                                                       +\n"+
						    "	+   6 = Yellow      E = Light Yellow                                                                                                       +\n"+
						    "	+   7 = White       F = Bright White                                                                                                       +\n"+       
							"	+                                                                                                                                          +\n"+
							"	+  SPECIAL COMMANDS :-                                                                                                                     +\n"+
							"	+                                                                                                                                          +\n"+
							"	+    1.  'DEFAULT'                                  |  ->Type 'DEFAULT' to set to default background black and foreground white.           +\n"+
							"	+    2.  'SWAP'                                     |  ->Type 'SWAP' to interchange background and foreground and vice-versa.              +\n"+							
							"	+    3.  'RANDOM_FORGROUND'                         |  ->Type 'RANDOM_FORGROUND' to set to random  foreground colour.                      +\n"+
							"	+    4.  'RANDOM_FORGROUND_WITH_BLACK_BACKGROUND'   |  ->Type 'RANDOM_FORGROUND' to set to random  foreground colour.                      +\n"+							
							"	+    5.  'RANDOM_BACKGROUND'                        |  ->Type 'RANDOM_BACKGROUND' to set to random  background colour.                     +\n"+
							"	+    6.  'RANDOM'                                   |  ->Type 'RANDOM' to set to random  foreground colour and random  background colour.  +\n"+
							"	+                                                                                                                                          +\n"+
							"	+   USAGE :-                                                                                                                               +\n"+							
							"	+                                                                                                                                          +\n"+
							"	+     eg. use <SPECIAL COMMANDS>                    |  -> use DEFAULT OR use default                                                       +\n"+
							"	+     eg. use <SPECIAL COMMANDS INDEX>              |  -> use 1                                                                            +\n"+
							"	+     eg. color <HEXA DECIMAL CODE>                 |  -> color FC //It will make bright black background and white forground              +\n"+
							"	+                                                                                                                                          +\n"+
							"	=++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++="
							);
							}
					}

	}

		protected void DefaultColours()
			{
			try
			{
			new ProcessBuilder("cmd", "/c", "color 07").inheritIO().start().waitFor(); //Default
			}
			catch(Exception e)
			{
			System.out.println(e);
			}
			color1 ="7";
			color2 ="0";
			}

	
		protected void RandomizeColour(int choice)
			{
				Random random = new Random();

				color = colors[random.nextInt(colors.length)];


				if(choice == 1)
				{
				try
				{
					new ProcessBuilder("cmd", "/c", "color "+color).inheritIO().start().waitFor();  //forground change with default black
					
				}catch(Exception e)
				{
					System.out.println(e);
				}
				color1 = color;
				}
			
				if(choice == 2)
				{
				try
				{
					new ProcessBuilder("cmd", "/c", "color "+color+""+color1).inheritIO().start().waitFor();	//background change only 
				}
				catch(Exception e)
				{
					System.out.println(e);
				}
				color2 = color;
				}

				if(choice == 3)
				{
				try
				{
					new ProcessBuilder("cmd", "/c", "color "+color2+""+color).inheritIO().start().waitFor();	//forground change only 
				}
				catch(Exception e)
				{
					System.out.println(e);
				}
				}

				if(choice == 4)
				{
				try
				{
					new ProcessBuilder("cmd", "/c", "color "+color1+""+color2).inheritIO().start().waitFor();	//swap only 
				}
				catch(Exception e)
				{
					System.out.println(e);
				}
				color = color1;
				color1 = color2;
				color2 = color;	
				}

				if(choice == 5)
				{
				color1=colors[random.nextInt(colors.length)]; 
				color2=colors[random.nextInt(colors.length)];
				try
				{
					new ProcessBuilder("cmd", "/c", "color "+color2+""+color1).inheritIO().start().waitFor();	
				}
				catch(Exception e)
				{
					System.out.println(e);
				}
			 
				}
		}


	public static void main(String[] args) {
		Colors c = new Colors();
		
	}
}