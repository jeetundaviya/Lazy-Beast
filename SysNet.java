package SysMate;
import java.io.*;
import java.util.Scanner;
import SysMate.*;

public class SysNet extends SysMate
{
	public static String sysnet_cmd = "";

	protected static String SysNetMenuLoc = "c:\\Users\\jeetu\\Desktop\\Lazy-Beast\\SysMate\\SysNetMenu.txt";

	public void runPB(String kw) throws Exception
	{
		ProcessBuilder pb = new ProcessBuilder("cmd","/c",kw);
		Process ps = pb.start();
		BufferedReader reader = new BufferedReader(new InputStreamReader(ps.getInputStream()));
		String line = "";
		while((line = reader.readLine()) != null)
		{
			System.out.println(line);
		}

		int exitCode = ps.waitFor();
		reader.close();

	}
	// public SysNet() throws Exception
	// {
	// 	Scanner sc = new Scanner(System.in);
	// 	while(true){
	// 		System.out.print(prompt+"[SysNet]>>>");
	// 		sysnet_cmd  = sc.nextLine();

	// 	if(sysnet_cmd.equals("clear")||sysnet_cmd.equals("1")||sysnet_cmd.equals("c"))
	// 		{
	// 			new Clear();
	// 		}
	// 	if(sysnet_cmd.contains("sysnet")||sysnet_cmd.contains("9"))
	// 		{
	// 			String [] subCMD = sysnet_cmd.split(" ",2);

	// 			ProcessBuilder pb = new ProcessBuilder("cmd","/c",subCMD[1]);
	// 			Process ps = pb.start();
	// 			BufferedReader reader = new BufferedReader(new InputStreamReader(ps.getInputStream()));
	// 			String line = "";
	// 			while((line = reader.readLine() )!= null)
	// 			{
	// 				System.out.println(line);
	// 			}
	// 		}
	// 	if(sysnet_cmd.equals("back")||sysnet_cmd.equals("0"))
	// 	{
	// 		break;
	// 	} 
	// 	}
	// }

	public SysNet(String input_cmd)throws Exception
	{
			if(input_cmd.equals("-m"))
			{
				new ProcessBuilder("cmd","/c","type "+SysNetMenuLoc).inheritIO().start().waitFor();
			}

			//.............................................................................................................................................
			
			if(input_cmd.startsWith("1") || input_cmd.contains("ipconfig"))  //ipconfig
			{
				if(input_cmd.equals("1") || input_cmd.equals("ipconfig"))
				{
				runPB("ipconfig");
				}
				if(input_cmd.startsWith("1 ") || input_cmd.startsWith("ipconfig "))
				{

				String subCMD [] =input_cmd.split(" ",2);
				runPB("ipconfig "+subCMD[1]);
				}
			}

			//.............................................................................................................................................
			
			if(input_cmd.startsWith("2") || input_cmd.contains("netstat"))  //netstat
			{
				if(input_cmd.equals("2") || input_cmd.equals("netstat"))
				{
				runPB("netstat");
				}
				else
				{

				String subCMD [] =input_cmd.split(" ",2);
				runPB("netstat 	"+subCMD[1]);
				}
			}

			//.............................................................................................................................................
			
			if(input_cmd.startsWith("3") || input_cmd.contains("tracert"))  //tracert
			{
				if(input_cmd.equals("3") || input_cmd.equals("tracert"))
				{
					runPB("tracert");
				}
				else
				{

					String subCMD [] =input_cmd.split(" ",2);
					runPB("tracert "+subCMD[1]);

				}
			}

			//.............................................................................................................................................

			if(input_cmd.startsWith("4") || input_cmd.contains("ping"))  //ping
			{
				if(input_cmd.equals("4") || input_cmd.equals("ping"))
				{
					runPB("ping");
				}
				else
				{

					String subCMD [] =input_cmd.split(" ",2);
					runPB("ping "+subCMD[1]);

				}
			}

			//.............................................................................................................................................

			if(input_cmd.startsWith("5") || input_cmd.contains("pathping"))  //pathping
			{
				if(input_cmd.equals("5") || input_cmd.equals("pathping"))
				{
					runPB("pathping");
				}
				else
				{

					String subCMD [] =input_cmd.split(" ",2);
					runPB("pathping "+subCMD[1]);

				}
			}

			//.............................................................................................................................................

			if(input_cmd.startsWith("6") || input_cmd.contains("telnet"))  //telnet
			{
				if(input_cmd.equals("6") || input_cmd.equals("telnet"))
				{
					//runPB("telnet");
					Runtime.getRuntime().exec("cmd /c start cmd.exe /k \"telnet \"");
				}
				// else
				// {
				// 	String subCMD [] =input_cmd.split(" ",2);
				// 	runPB("telnet "+subCMD[1]);
				// }
			}

			//.............................................................................................................................................

			if(input_cmd.startsWith("7") || input_cmd.contains("ftp"))  //ftp
			{
				if(input_cmd.equals("7") || input_cmd.equals("ftp"))
				{
					//runPB("ftp");
					Runtime.getRuntime().exec("cmd /c start cmd.exe /k \"ftp \"");
				}
				// else
				// {

				// 	String subCMD [] =input_cmd.split(" ",2);
				// 	runPB("ftp "+subCMD[1]);

				// }
			}

			//.............................................................................................................................................

			if(input_cmd.startsWith("8") || input_cmd.contains("route"))  //route
			{
				if(input_cmd.equals("8") || input_cmd.equals("route"))
				{
					runPB("route");
					//Runtime.getRuntime().exec("cmd /c start cmd.exe /k \"route \"");
				}
				else
				{
					String subCMD [] =input_cmd.split(" ",2);
					runPB("route "+subCMD[1]);
				}
			}

			//.............................................................................................................................................

			if(input_cmd.startsWith("9") || input_cmd.contains("arp"))  //arp
			{
				if(input_cmd.equals("9") || input_cmd.equals("arp"))
				{
					runPB("arp");
				}
				else
				{

					String subCMD [] =input_cmd.split(" ",2);
					runPB("arp "+subCMD[1]);

				}
			}

			//.............................................................................................................................................

			if(input_cmd.startsWith("10") || input_cmd.contains("nslookup"))  //nslookup
			{
				if(input_cmd.equals("10") || input_cmd.equals("nslookup"))
				{
					runPB("nslookup");
				}
				else
				{

					String subCMD [] =input_cmd.split(" ",2);
					runPB("nslookup "+subCMD[1]);

				}
			}

			//.............................................................................................................................................

			if(input_cmd.startsWith("11") || input_cmd.contains("nbtstat"))  //nbtstat
			{
				if(input_cmd.equals("11") || input_cmd.equals("nbtstat"))
				{
					runPB("nbtstat");
				}
				else
				{

					String subCMD [] =input_cmd.split(" ",2);
					runPB("nbtstat "+subCMD[1]);

				}
			}

			//.............................................................................................................................................


			if(input_cmd.startsWith("12") || input_cmd.contains("netsh"))  //netsh
			{
				if(input_cmd.equals("12") || input_cmd.equals("netsh"))
				{
					//runPB("netsh");
					Runtime.getRuntime().exec("cmd /c start cmd.exe /k \"netsh \"");
				}
				// else
				// {

				// 	String subCMD [] =input_cmd.split(" ",2);
				// 	runPB("netsh "+subCMD[1]);

				// }
			}
			//.............................................................................................................................................

			if(input_cmd.startsWith("13") || input_cmd.contains("getmac"))  //getmac
			{
				if(input_cmd.equals("13") || input_cmd.equals("getmac"))
				{
					runPB("getmac");
				}
				else
				{

					String subCMD [] =input_cmd.split(" ",2);
					runPB("getmac "+subCMD[1]);

				}
			}

			//.............................................................................................................................................

			if(input_cmd.startsWith("14") || input_cmd.contains("powercfg"))  //powercfg
			{
				if(input_cmd.equals("14") || input_cmd.equals("powercfg"))
				{
					runPB("powercfg");
				}
				else
				{

					String subCMD [] =input_cmd.split(" ",2);
					runPB("powercfg "+subCMD[1]);

				}
			}
	}

}