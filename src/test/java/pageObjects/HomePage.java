package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
	
	public HomePage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//div[text()='Products']")
	WebElement products;
	
	@FindBy(id="react-burger-menu-btn")
	WebElement ellipses;
	
	@FindBy(id="logout_sidebar_link")
	WebElement logout;
	
	
	public String products()
	{
		String pro = products.getText();
		return pro;
		
	}
	
	public void clickellipses()
	{
		ellipses.click();
	}
	
	public void clicklogout()
	{
		logout.click();
	}
	
	public boolean isProductsDisplayed()
	{
		boolean bool=products.isDisplayed();
		return bool;
	}

}
