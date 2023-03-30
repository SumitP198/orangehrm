package ohrm;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import bsh.This;
import utility.BrowserFactory;
import utility.Screenshot;

public class VerifyValidLogin {
	WebDriver driver;
	@BeforeTest
	public void BeforeClass()
	{
		WebDriver driver = BrowserFactory.Browser("Edge","https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		LoginTestCase xyz=PageFactory.initElements(driver, LoginTestCase.class);
		this.driver=driver;
	}

	@Test(priority = 1)
	public void InvalidUser() throws IOException, InterruptedException 
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(" //input[@placeholder='Username']")));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(" //input[@placeholder='Password']")));
		LoginTestCase xyz=PageFactory.initElements(driver, LoginTestCase.class);
		xyz.loginOHRM("Admin","admin1234");
		String CurrentURL= driver.getCurrentUrl();
		Assert.assertTrue(CurrentURL.contains("/auth/login"));	
		
	}
	@Test(priority = 2)
	public void BlankUser() throws IOException 
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(" //input[@placeholder='Username']")));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(" //input[@placeholder='Password']")));
		LoginTestCase xyz=PageFactory.initElements(driver, LoginTestCase.class);		
		xyz.loginOHRM("Admin", "    ");
		String CurrentURL= driver.getCurrentUrl();
		Assert.assertTrue(CurrentURL.contains("/auth/login"));	
	}
	@Test(priority = 3)
	public void ValidUser() throws IOException 
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(" //input[@placeholder='Username']")));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(" //input[@placeholder='Password']")));
		LoginTestCase xyz=PageFactory.initElements(driver, LoginTestCase.class);
		xyz.loginOHRM("Admin", "admin123");
		String CurrentURL = driver.getCurrentUrl();
		Assert.assertTrue(CurrentURL.contains("/dashboard/index"));	
	}
	@AfterTest
	public void Quit() {
		driver.quit();
		}
}
