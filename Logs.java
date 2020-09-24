package SysMate;

public class Logs
{
	
	public static String OutputLoc ="C:\\Users\\jeetu\\Desktop\\SysMate\\SysMate\\Logs\\Logs.txt";
	protected String CMD = "";
	public Logs()throws Exception 
	{

	}

	public void login()throws Exception
	{
		Runtime.getRuntime().exec("cmd /c "+
			"echo ............................................................................................................... >> "+OutputLoc+
			" && echo Login  >> "+OutputLoc+
			" && echo DATE:- >> "+OutputLoc+ 
			" && date /t >> "+OutputLoc+
			" && echo TIME:- >> "+OutputLoc+ 
			" && time /t >> "+OutputLoc+
			" && echo ............................................................................................................... >> "+OutputLoc);
	}

		
	public void login(String console)throws Exception         //Overloading login method with one string parameter for fetching console details
	{
		Runtime.getRuntime().exec("cmd /c "+
			"echo ............................................................................................................... >> "+OutputLoc+
			" && echo Login  >> "+OutputLoc+
			" && echo Console :-  >> "+OutputLoc+
			" && echo "+console+" >> "+OutputLoc+
			" && echo DATE:- >> "+OutputLoc+ 
			" && date /t >> "+OutputLoc+
			" && echo TIME:- >> "+OutputLoc+ 
			" && time /t >> "+OutputLoc+
			" && echo ............................................................................................................... >> "+OutputLoc);
	}
	


	public void logout()throws Exception
	{
		Runtime.getRuntime().exec("cmd /c "+
			"echo ............................................................................................................... >> "+OutputLoc+
			" && echo Logout  >>"+OutputLoc+
			" && echo DATE:- >>"+OutputLoc+ 
			" && date /t >>"+OutputLoc+
			" && echo TIME:- >>"+OutputLoc+ 
			" && time /t >> "+OutputLoc+
			" && echo ............................................................................................................... >> "+OutputLoc);
	}

	public void logout(String console)throws Exception         //Overloading logout method with one string parameter for fetching console details
	{
		Runtime.getRuntime().exec("cmd /c "+
			"echo ............................................................................................................... >> "+OutputLoc+
			" && echo Logout  >> "+OutputLoc+
			" && echo Console :-  >> "+OutputLoc+
			" && echo "+console+" >> "+OutputLoc+
			" && echo DATE:- >> "+OutputLoc+ 
			" && date /t >> "+OutputLoc+
			" && echo TIME:- >> "+OutputLoc+ 
			" && time /t >> "+OutputLoc+
			" && echo ............................................................................................................... >> "+OutputLoc);
	}


	public void appendCMD()throws Exception
	{
		Runtime.getRuntime().exec("cmd /c "+
			"echo ............................................................................................................... >> "+OutputLoc+
			" && echo Command :-   >>"+OutputLoc+
			" && echo "+CMD+" >>"+OutputLoc+
			" && echo DATE:- >>"+OutputLoc+ 
			" && date /t >>"+OutputLoc+
			" && echo TIME:- >>"+OutputLoc+ 
			" && time /t >> "+OutputLoc+
			" && echo ............................................................................................................... >> "+OutputLoc);

	}
}