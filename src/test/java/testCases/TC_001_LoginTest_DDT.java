package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC_001_LoginTest_DDT extends BaseClass {
	
	
	@Test(dataProvider="LoginData",dataProviderClass=DataProviders.class)
	void test_login(String email, String password, String res) throws InterruptedException
	{	
		logger.debug("Login testcase started");
		try {
		LoginPage lp = new LoginPage(driver);
		HomePage hp = new HomePage(driver);
		logger.info("Entered username");
		lp.enterusername(email);
		logger.info("Entered password");
		lp.enterpassword(password);
		logger.info("Clicked login button");
		lp.clickloginbtn();
		Thread.sleep(5000);
		logger.info("Checked for label match");
		//Assert.assertEquals(hp.products(), "Swag Labs");
		hp.clickellipses();
		
		if(res.equals("valid"))
		{
			if(hp.isProductsDisplayed()==true)
			{
				hp.clicklogout();
				Assert.assertTrue(true);
			}
			else
			{
				Assert.assertTrue(false);
			}
		}
		if(res.equals("invalid"))
		{
			if(hp.isProductsDisplayed()==true)
			{
				hp.clicklogout();
				Assert.assertTrue(false);
			}
			else
			{
				Assert.assertTrue(true);
			}
		}
	
		}
		catch(Exception e)
		{
			Assert.fail();
			e.getStackTrace();
		}	
		logger.info("Login testcase finished");
	}

}
