package SysMate;

public class Clear
{
	public Clear()
		{
			try
			{
				new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
			}
			catch(Exception e)
			{
				System.out.println(e);
			}

		}
} 