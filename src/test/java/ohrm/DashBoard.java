package ohrm;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.AssertJUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
public class DashBoard {
WebDriverWait wait;
WebDriver driver;


//@Test(priority = 1)
//public void PageLoad() throws InterruptedException

//{
//	super.driver = driver;
//	driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
//	String URL=driver.getCurrentUrl();
//	driver.manage().window().maximize();
//	AssertJUnit.assertTrue(URL.contains("auth/login"));
//	System.out.println("page has been loaded successfully");
//	Thread.sleep(5000);
//	driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("Admin");
//	Thread.sleep(5000);
//	driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("admin123");
//	Thread.sleep(5000);
//	driver.findElement(By.xpath("//button[@type='submit']")).click();
//	Thread.sleep(5000);
//	}

@Test(priority = 2)
public void LoginCase() throws InterruptedException
{

wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='oxd-text oxd-text--span oxd-main-menu-item--name'][normalize-space()='Pizarra de pendientes']")));
driver.findElement(By.xpath("//a[@class='oxd-main-menu-item active']")).click();
wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='oxd-main-menu-item active']")));
driver.findElement(By.xpath("//a[@class='oxd-main-menu-item active']")).click();
wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='oxd-main-menu-item active']")));
driver.findElement(By.xpath("//a[@class='oxd-main-menu-item active']")).click();
Thread.sleep(5000);
}

@AfterTest(dependsOnMethods = "LoginCase")
public void Endtest()
{
	driver.quit();
}
}
	