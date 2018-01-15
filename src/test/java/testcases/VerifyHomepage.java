package testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import factory.BrowserFactory;
import factory.DataProviderFactory;
import junit.framework.Assert;
import pages.HomePage;


public class VerifyHomepage {
	
	WebDriver driver;
	
	@BeforeMethod
	public void openBrowser()
	{
 driver =BrowserFactory.getBrowser("firefox");
 
		
		driver.get(DataProviderFactory.getConfig().getApplicationUrl());
	}

	@Test
	public void testHomePage() throws InterruptedException
	{
		
		
		HomePage home=PageFactory.initElements(driver, HomePage.class);
		
		String title= home.getApplicationTitle();
		
		Assert.assertTrue(title.contains("Avactis"));
		
		System.out.println("My Application title is " +title);
		
		Thread.sleep(5000);
	
	}
	
	@AfterMethod
	public void closeBrowser()
	{
		driver.quit();
	}
}
