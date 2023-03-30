package ohrm;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;


	public class LoginTestCase
	{
		WebDriver driver;
		public LoginTestCase(WebDriver driver)
		{
			this.driver=driver;
			
		}
		@FindBy(xpath = "//input[@placeholder='Username']") WebElement username;
		@FindBy(how=How.XPATH,using = "//input[@placeholder='Password']") WebElement password;
		@FindBy(how=How.XPATH,using = "//button[@type='submit']") WebElement submit;
		@FindBy(how=How.XPATH,using ="//p[@class='oxd-text oxd-text--p orangehrm-login-forgot-header']") 
		WebElement Forgotpwd;
		
		public void loginOHRM(String user,String pwd)
		{
			
			username.sendKeys(user);
			password.sendKeys(pwd);
			submit.click();	
			username.clear();
			password.clear();

		}
		
		

}
