import java.io.*;
import java.time.*;
import java.time.format.*;
class trySplit
{
	public static void main(String[] args) {
		// Get current date time
LocalDateTime currentDateTime = LocalDateTime.now();
 
// Inbuilt format
DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE_TIME;
 
// Custom format
//DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
 
// Format LocalDateTime
String formattedDateTime = currentDateTime.format(formatter);
 
//Verify
System.out.println("Formatted LocalDateTime : " + formattedDateTime);       
 
//Output:
 
//Formatted LocalDateTime : 2018-07-14T17:45:55.9483536
	}
}