package Basics;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ButtonsAndCheckBoxes {
	public static void main(String[] args) {
		ButtonsAndCheckBoxes buttons= new ButtonsAndCheckBoxes();
		buttons.RadioButton();
		
	}


public void RadioButton() {
	WebDriverManager.chromedriver().setup();
	ChromeOptions chromeOptions = new ChromeOptions();
	chromeOptions.addArguments("--remote-allow-origins=*","ignore-certificate-errors");
	WebDriver driver = new ChromeDriver(chromeOptions);
	driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	List<WebElement> Login = driver.findElements(By.xpath("//div[@class='orangehrm-login-slot']"));
	
	for(int i=0;i<Login.size();i++)
	{
		WebElement local_login = Login.get(i);
		String xpath = local_login.getDomAttribute("Value");
		
		System.out.println("the value is " + xpath);
	}
	
}
}
