package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC_001_LoginTest_Grouping extends BaseClass {
	
//	
//	@Test(groups= {"sanity","smoke",})
//	void test_login() throws InterruptedException
//	{	
//		logger.debug("Login testcase started");
//		try {
//		LoginPage lp = new LoginPage(driver);
//		HomePage hp = new HomePage(driver);
//		logger.info("Entered username");
//		lp.enterusername(rb.getString("username"));
//		logger.info("Entered password");
//		lp.enterpassword(rb.getString("password"));
//		logger.info("Clicked login button");
//		lp.clickloginbtn();
//		Thread.sleep(5000);
//		logger.info("Checked for label match");
//		Assert.assertEquals(hp.products(), "Swag Labs");
//		}
//		catch(Exception e)
//		{
//			Assert.fail();
//			e.getStackTrace();
//		}	
//		logger.info("Login testcase finished");
//	}
	
	@Test(groups= {"sanity"})
	void test_sanity() throws InterruptedException
	{	
		System.out.println("Sanity based testcase");
	}
	@Test(groups= {"smoke"})
	void test_smoke() throws InterruptedException
	{	
		System.out.println("Smoke based testcase");
	}
	@Test(groups= {"regression"})
	void test_regression() throws InterruptedException
	{	
		System.out.println("regression based testcase");
	}

}
