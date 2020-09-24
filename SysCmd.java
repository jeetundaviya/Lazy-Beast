package SysMate;
import java.io.*;
import java.util.*;
import SysMate.*;
public class SysCmd extends SysMate
{
    public SysCmd()throws Exception
    {
        Logs log = new Logs();
        log.login("SysCmd (new window)");
        Runtime.getRuntime().exec("cmd /c start cmd.exe /K \"echo Welcome to SysCmd ......... && title SysCmd && prompt $G$G$G[SysCmd]$G$G$G \"");
                        
    }

    public SysCmd(String prompt)
    {
        Scanner sc = new Scanner(System.in);
        try
        {
            new Clear();
            System.out.println("Welcome to SysCmd.....");
            Logs log = new Logs();
            log.login("SysCmd");
        while(true){  
                System.out.print(prompt+"[SysCmd]>>>");
                String cmd = sc.nextLine();
                log.CMD = cmd;
                log.appendCMD();

                if(cmd.equals("1")||cmd.contains("clear")||cmd.equals("c"))  //For clearing Screen   
                        {
                            new Clear();        
                        }

                ProcessBuilder pb = new ProcessBuilder("cmd","/c",cmd);
                Process ps = pb.start();
                BufferedReader reader = new BufferedReader(new InputStreamReader(ps.getInputStream()));
                String line;
                while((line = reader.readLine()) != null)
                {
                    System.out.println(line);
                }
                int exitCode = ps.waitFor();
             // System.out.println("\nExited System Command with error code : " + exitCode);
                reader.close();

                if(cmd.equals("back")||cmd.equals("0"))
                    {
                        log.logout("SysCmd");
                        break;
                    }
            }
        } 
        catch (Exception e) 
        { 
            System.out.println("Exception :- "+e); 
          
        } 

    } 
    public SysCmd(String prompt,String cmd) 
    {
        try
        {  
                System.out.println(prompt+"[SysCmd]>>>");
                ProcessBuilder pb = new ProcessBuilder("cmd","/c",cmd+" && exit");
        		Process ps = pb.start();
                BufferedReader reader = new BufferedReader(new InputStreamReader(ps.getInputStream()));
                String line;
                while((line = reader.readLine()) != null)
                {
                    System.out.println(line);
                }
                int exitCode = ps.waitFor();
             // System.out.println("\nExited System Command with error code : " + exitCode);
                reader.close();

        } 
        catch (Exception e) 
        { 
            System.out.println("Exception :- "+e); 
          
        } 
    } 
} 