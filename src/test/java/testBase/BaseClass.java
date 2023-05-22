package testBase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.ResourceBundle;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import pageObjects.BasePage;

public class BaseClass{
	
	public static WebDriver driver;
	public Logger logger;	//Variable created for logging.
	public ResourceBundle rb; //Variable for reading config file
	
	//Setup
	@BeforeClass
	@Parameters("browser")
	public void setup(String br)
	{
		rb=ResourceBundle.getBundle("config");
		
		if(br.equals("chrome"))
			driver = new ChromeDriver();
		if(br.equals("firefox"))
			driver=new FirefoxDriver();
		if(br.equals("edge"))
			driver=new EdgeDriver();
		
		driver.manage().deleteAllCookies();
		driver.get(rb.getString("url"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//driver.get("https://www.saucedemo.com/");
		driver.manage().window().maximize();
		
		//Code for setting up logging
		logger=LogManager.getLogger(this.getClass());		
	}
	
	//Teardown
	@AfterClass
	public void teardown()
	{
		driver.quit();
	}
	
	public String captureScreenshot(String tname)
	{
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMddhhmmss");
		Date dt=new Date();
		String timestamp = df.format(dt);
		
		TakesScreenshot takesscreenshot=(TakesScreenshot)driver;
		File source = takesscreenshot.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir") + "\\screenshot\\" + tname + "_" + timestamp;
		
		try {
			FileHandler.copy(source, source);
			//FileUtils.copyFile(source, new File(destination));
		} catch (IOException e) {
			e.getMessage();
		}
		return destination;
		
	}
	
}
