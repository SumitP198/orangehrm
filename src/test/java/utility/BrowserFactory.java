package utility;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BrowserFactory {
static WebDriver driver;
WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
String CurrentURL= driver.getCurrentUrl();
	
	public static WebDriver Browser(String browserName,String URL) {
		if (browserName.equalsIgnoreCase("edge"))
		{
			driver = new EdgeDriver();
		}
		else if (browserName.equalsIgnoreCase("chrome")) {
			driver=  new ChromeDriver();
			}
		else if (browserName.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
			}
		driver.get(URL);
		
		return driver;
	
	}
	
	}
