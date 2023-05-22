package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
	
	//Created constructor of login page
	public LoginPage(WebDriver driver) {
		super(driver);
		
	}
	
	//Declaring Elements
	@FindBy(id = "user-name")
	WebElement username;
	
	@FindBy(id = "password")
	WebElement password;
	
	@FindBy(id = "login-button")
	WebElement loginbtn;
	
	//Declaring Action Methods
	
	public void enterusername(String un)
	{
		username.sendKeys(un);
	}
	
	public void enterpassword(String pw)
	{
		password.sendKeys(pw);
	}
	
	public void clickloginbtn()
	{
		loginbtn.click();
	}
	

}
