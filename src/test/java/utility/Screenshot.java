package utility;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Screenshot {
public static String captureScreenshot(WebDriver driver) throws IOException 
{   
System.getProperties();
String path ="ohrm\\test-output"+File.separator+"Screenshots"+File.separator+System.currentTimeMillis()+".png";
File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
File dest = new File (path);
FileHandler.copy(source,dest);
return path;
}
}
		

		

	


