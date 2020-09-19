package SysMate;
import java.io.*;
public class Archive
{
	private void ArchiveFile(String extension,String outputLoc,String inputLoc)throws Exception
		{
			int extensionIndex = inputLoc.indexOf(".");
			int fileStartIndex = inputLoc.lastIndexOf("\\")+1;
			Process ps = Runtime.getRuntime().exec("cmd /c 7z a "+outputLoc+inputLoc.substring(fileStartIndex,extensionIndex)+"."+extension+" "+inputLoc);
			BufferedReader reader = new BufferedReader(new InputStreamReader(ps.getInputStream()));
			String line;
			while((line = reader.readLine()) != null)
			{
				System.out.println(line);
			}
			reader.close();
		}

	private void ArchiveFolder(String extension,String outputLoc,String inputLoc)throws Exception
		{
			//int extensionIndex = inputLoc.indexOf(".");
			int fileStartIndex = inputLoc.lastIndexOf("\\")+1;
			Process ps = Runtime.getRuntime().exec("cmd /c 7z a "+outputLoc+inputLoc.substring(fileStartIndex)+"."+extension+" "+inputLoc);
			BufferedReader reader = new BufferedReader(new InputStreamReader(ps.getInputStream()));
			String line;
			while((line = reader.readLine()) != null)
			{
				System.out.println(line);
			}
			reader.close();
		}
	public Archive() throws Exception
			{
				Runtime.getRuntime().exec("cmd /c 7zfm.exe");
			}

	public Archive(String extension,String outputLoc,String inputLoc) throws Exception
			{
				if (inputLoc.contains("."))               //Archive for files
					{
						ArchiveFile(extension,outputLoc,inputLoc);
					}
				else                                      //Archive for folders
					{
						ArchiveFolder(extension,outputLoc,inputLoc);
					}
			}		
}