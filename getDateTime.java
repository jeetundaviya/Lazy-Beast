package SysMate;
import java.io.*;
import java.time.*;
import java.time.format.*;
public class getDateTime
{
	public String getCurrentDateTime()
	{
	LocalDateTime currentDateTime = LocalDateTime.now();
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH:mm:ss");
	String formattedDateTime = currentDateTime.format(formatter);
	return formattedDateTime;
	}
}