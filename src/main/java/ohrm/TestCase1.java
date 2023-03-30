package ohrm;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class TestCase1{
	static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException {
	
		driver = new EdgeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		Thread.sleep(4000);
	
		driver.quit();
	}
	
}
