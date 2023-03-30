package ohrm;


import org.testng.annotations.Test;
import org.testng.AssertJUnit;

import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;


public class LoginTest extends StaticBrowser{



@Test(priority = 1)
public void getstarted() throws InterruptedException
{
super.driver=driver;
driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
Thread.sleep(5000);
String CurrentURL = driver.getCurrentUrl();
Assert.assertTrue(CurrentURL.contains("/auth/login"));
}
@Test(dependsOnMethods = "getstarted")
public void LoginCase() {
	WebElement Uname=driver.findElement(By.xpath("//input[@placeholder='Username']"));
	Uname.sendKeys("Admin");
	WebElement Pwd=driver.findElement(By.xpath("//input[@placeholder='Password']"));
	Pwd.sendKeys("admin123");
	WebElement button=driver.findElement(By.xpath("//button[normalize-space()='Login']"));
	button.click();
	//boolean status =driver.findElement(By.xpath("//p[@class='oxd-userdropdown-name']")).isDisplayed();
	//Assert.assertTrue(status);	
}
@Test(dependsOnMethods = "Dashboard")
public void LogoutCase() throws InterruptedException {
	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
	driver.findElement(By.xpath("//i[@class='oxd-icon bi-caret-down-fill oxd-userdropdown-icon']")).click();

	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[normalize-space()='Logout']"))).isDisplayed();
	
	driver.findElement(By.xpath("//a[normalize-space()='Logout']")).click();
	Thread.sleep(3000);
	Assert.assertTrue(driver.findElement(By.xpath("//input[@placeholder='Username']")).isDisplayed());
	
	}
@Test(priority = 2)
public void Dashboard() throws InterruptedException, IOException 
{
WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='oxd-main-menu-item active']")));
driver.findElement(By.xpath("//a[@class='oxd-main-menu-item active']")).click();
wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[normalize-space()='My Info']")));
driver.findElement(By.xpath("//span[normalize-space()='My Info']")).click();
wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[normalize-space()='PIM']")));
driver.findElement(By.xpath("//span[normalize-space()='PIM']")).click();
Screenshot.captureScreenshot(driver);
Thread.sleep(5000);
}
@AfterClass
public void quit()
{
	driver.quit();
	
}

}

