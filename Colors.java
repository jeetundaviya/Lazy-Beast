package SysMate;
import java.util.*;
import java.io.*;
import SysMate.*;
class Colors extends SysMate
{
	public String color_cmd="";
	private String colors [] = {"A","B","C","D","E","F","1","2","3","4","5","6","7","8","9"};
	private String color = "07";
	private String color1="";
	private	String color2="";
	public static long StopCoolModePID = 0;

	public class COOL_MODE extends Thread
		{
		public int mode = 0;
					
			    @Override
			    public void run()
			    {
			       // String colors [] = {"A","B","C","D","E","F","1","2","3","4","5","6","7","8","9"};
			    if(mode == 0){                                                //cool_forground
							        try
								        {
								          while(true)
								          {
								            Random random = new Random();
								            String color1=colors[random.nextInt(colors.length)]; 
								            //String color2=colors[random.nextInt(colors.length)];
								            Thread.sleep(1000);
								            new ProcessBuilder("cmd", "/c", "color "+color2+""+color1).inheritIO().start().waitFor(); 
								          }
								        }
							        catch(Exception e)
								        {
								          System.out.println(e);
								        }
			    			}

			    	if(mode == 1){                                          //cool_background
							       try
								      {
								          while(true)
								          {
								            Random random = new Random();
								            //String color1=colors[random.nextInt(colors.length)]; 
								            String color2=colors[random.nextInt(colors.length)];
								            Thread.sleep(1000);
								            new ProcessBuilder("cmd", "/c", "color "+color2+""+color1).inheritIO().start().waitFor(); 
								          }
								       }
							       catch(Exception e)
								        {
								          System.out.println(e);
								        }
			    				}

			    	if(mode == 2){                                          //pro_cool_mode
						    		try
								        {
								          while(true)
								          {
								            Random random = new Random();
								            String color1=colors[random.nextInt(colors.length)]; 
								            String color2=colors[random.nextInt(colors.length)];
								            Thread.sleep(1000);
								            new ProcessBuilder("cmd", "/c", "color "+color2+""+color1).inheritIO().start().waitFor(); 
								          }
								        }
								    catch(Exception e)
								        {
								          System.out.println(e);
								         }
					        }
			    }  
		}
					  
	protected static String ColorsConsoleWelcomeLoc = "C:\\Users\\jeetu\\Desktop\\SysMate\\SysMate\\ColorsConsoleWelcome.txt";
	public COOL_MODE cool_obj = new COOL_MODE();
	public void StopCoolMode(long stoppid)
	{
		//Give you set of Threads
		Set<Thread> setOfThread = Thread.getAllStackTraces().keySet();

		//Iterate over set to find yours
		for(Thread thread : setOfThread){
		    if(thread.getId()==stoppid){
		        thread.stop();
		    }
		}
	}
	public void ModifyColors()throws Exception
	{
		 //for excessing cool mode options

		Logs log = new Logs();
		log.login("Colors Console");
				Scanner sc = new Scanner(System.in);

			{                                             //initial starting
				try
				{
					new Clear();
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
								log.logout("Colors Console");
								break;
							}
							if(color_cmd.equals("default")||color_cmd.equals("use 1"))
							{
								cool_obj.stop();
								DefaultColour();
							}

							if(color_cmd.equals("random_forground")||color_cmd.equals("use 3"))
							{
								cool_obj.stop();
								RandomizeColour(3);
							}

							if(color_cmd.equals("swap")||color_cmd.equals("use 2"))
							{
								cool_obj.stop();
								RandomizeColour(4);
							}

							if(color_cmd.equals("random_forground_with_black_background")||color_cmd.equals("use 4"))
							{
								cool_obj.stop();
								RandomizeColour(1);
							}

							if(color_cmd.equals("random_background")||color_cmd.equals("use 5"))
							{
								cool_obj.stop();
								RandomizeColour(2);
							}

							if(color_cmd.equals("random")||color_cmd.equals("use 6"))
							{
								cool_obj.stop();
								RandomizeColour(5);
							}

							if(color_cmd.equals("cool_forground_mode")||color_cmd.equals("use 7"))
							{
								cool_obj.stop();
								cool_obj = new COOL_MODE();
								StopCoolModePID = cool_obj.getId();
								//System.out.println(StopCoolModePID);
								cool_obj.mode = 0;
								cool_obj.start();
								
							}

							if(color_cmd.equals("cool_background_mode")||color_cmd.equals("use 8"))
							{
								cool_obj.stop();
								cool_obj = new COOL_MODE();
								StopCoolModePID = cool_obj.getId();
								cool_obj.mode = 1;
								cool_obj.start();
							}

							if(color_cmd.equals("cool_forground_mode")||color_cmd.equals("use 9"))
							{
								cool_obj.stop();
								cool_obj = new COOL_MODE();
								StopCoolModePID = cool_obj.getId();
								cool_obj.mode = 2;
								cool_obj.start();
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
							"	+    1.  'DEFAULT'                                  |  -> It will set colors to default background black and foreground white.             +\n"+
							"	+    2.  'SWAP'                                     |  -> It will interchange background and foreground colors and vice-versa.             +\n"+							
							"	+    3.  'RANDOM_FORGROUND'                         |  -> It will set random color for foreground colour.                                  +\n"+
							"	+    4.  'RANDOM_FORGROUND_WITH_BLACK_BACKGROUND'   |  -> It will set random color foreground colour with black background.                +\n"+							
							"	+    5.  'RANDOM_BACKGROUND'                        |  -> It will set random  background colour.                                           +\n"+
							"	+    6.  'RANDOM'                                   |  -> It will set random  foreground and background colors.                            +\n"+
							"	+    7.  'COOL_FORGROUND_MODE'                      |  -> It will continously change forground color in a random manner.                   +\n"+
							"	+    8.  'COOL_BACKGROUND_MODE'                     |  -> It will continously change background color in a random manner.                  +\n"+
							"	+    9.  'PRO_COOL_MODE'                            |  -> It will continously change forground and background color in a random manner.    +\n"+
							"	+                                                                                                                                          +\n"+
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

		protected void DefaultColour()
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

				if(choice == 4)  //swap only
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

				if(choice == 5)  //random both background and forground
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