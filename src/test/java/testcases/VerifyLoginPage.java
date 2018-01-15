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
import pages.LoginPage;


public class VerifyLoginPage {
	
	WebDriver driver;
	
	@BeforeMethod
	public void openBrowser()
	{
 driver =BrowserFactory.getBrowser("Chrome");
 
		
		driver.get(DataProviderFactory.getConfig().getApplicationUrl());
	}

	@Test
	public void testHomePage() throws InterruptedException
	{
		
		
		HomePage home=PageFactory.initElements(driver, HomePage.class);
		
		String title= home.getApplicationTitle();
		
		Assert.assertTrue(title.contains("Avactis"));
		
		System.out.println("My Application title is " +title);
		
		home.clickonSigninlink();
		
		LoginPage login=PageFactory.initElements(driver, LoginPage.class);
		
		login.loginApplication(DataProviderFactory.getExcel().getData(0, 0, 0),DataProviderFactory.getExcel().getData(0, 0, 1));
		
		System.out.println("The LoginPage Title "+driver.getTitle());
		
		
		
		Thread.sleep(5000);
		
		login.signoutDropdown();
		
		login.clicksignout();
	
	}
	
	@AfterMethod
	public void closeBrowser()
	{
		BrowserFactory.closeBrowser(driver);
	}
}
