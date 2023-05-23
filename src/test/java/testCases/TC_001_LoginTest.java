package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC_001_LoginTest extends BaseClass {
	SoftAssert sa=new SoftAssert();
	
	@Test
	void test_login() throws InterruptedException
	{	
		logger.debug("Login testcase started");
		try {
		LoginPage lp = new LoginPage(driver);
		HomePage hp = new HomePage(driver);
		logger.info("Enter the username");
		lp.enterusername(rb.getString("username"));
		String uname=lp.getusername().getText();
		if(uname.equals(""))
		{
			sa.fail();
		}
		else {
			logger.info("Username is entered");
		}
		logger.info("Enter the password");
		//lp.enterpassword(rb.getString("password"));
		String pass=lp.getpassword().getText();
		if(pass.equals(""))
		{
			sa.fail();
		}
		else {
			logger.info("password is entered");
		}
		logger.info("Clicked login button");
		lp.clickloginbtn();
		Thread.sleep(5000);
		logger.info("Checked for label match");
		Assert.assertEquals(hp.products(), "Swag Labs");
		}
		catch(Exception e)
		{
			Assert.fail();
			e.getStackTrace();
		}	
		logger.info("Login testcase finished");
	}

}
