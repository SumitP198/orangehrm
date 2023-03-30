package ohrm;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class StaticBrowser {
static WebDriver driver;
@Parameters({"browser"})
@Test
public void SelectBrowser(String browser)
{
	System.out.println("browser is: "+ browser);
	if(browser.equalsIgnoreCase("Chrome")) {
		WebDriverManager.chromedriver().setup();
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--remote-allow-origins=*","ignore-certificate-errors");
		driver = new ChromeDriver(chromeOptions);
	}
	else if(browser.equalsIgnoreCase("Firefox"))
	{
		driver = new FirefoxDriver();
	}
	else if (browser.equalsIgnoreCase("Edge"))
	{
		driver = new EdgeDriver();		
	}
	driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
}
}


