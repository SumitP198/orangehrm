package ohrm;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Clear {
	@FindBy(xpath = "//input[@placeholder='Username']") WebElement username;
	@FindBy(xpath = "//input[@placeholder='Password']") WebElement password;

public void ClearBox()
{
	username.clear();
	password.clear();
}

}
