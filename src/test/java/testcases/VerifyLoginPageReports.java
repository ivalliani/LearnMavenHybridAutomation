package testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import factory.BrowserFactory;
import factory.DataProviderFactory;
import junit.framework.Assert;
import pages.HomePage;
import pages.LoginPage;


public class VerifyLoginPageReports {
	
	WebDriver driver;
	ExtentReports report;
	ExtentTest logger;
	
	@BeforeMethod
	public void setUp()
	{
		
		report = new ExtentReports(".\\Reports\\LoginPageReport.html",true);
		
		logger = report.startTest("verify Test Login");
		
		
 driver =BrowserFactory.getBrowser("Chrome");
 
		//logger = new ExtentTest("Verify Login Page","This Page will verify sign out link");
		driver.get(DataProviderFactory.getConfig().getApplicationUrl());
		
		logger.log(LogStatus.INFO, "Application is up and running");
	}

	@Test
	public void testHomePage() throws InterruptedException
	{
		
		
		HomePage home=PageFactory.initElements(driver, HomePage.class);
		
		String title= home.getApplicationTitle();
		
		logger.log(LogStatus.PASS, "Homepage Loaded successfully and verified");
		
		Assert.assertTrue(title.contains("Avactis"));
		
		System.out.println("My Application title is " +title);
		
		home.clickonSigninlink();
		
		logger.log(LogStatus.INFO, "Click on Signon Link");
		
		LoginPage login=PageFactory.initElements(driver, LoginPage.class);
		
		login.loginApplication(DataProviderFactory.getExcel().getData(0, 0, 0),DataProviderFactory.getExcel().getData(0, 0, 1));
		
		logger.log(LogStatus.INFO, "Login toApplication");
		System.out.println("The LoginPage Title "+driver.getTitle());
		
		
		
		Thread.sleep(5000);
		
		login.signoutDropdown();
		
		login.clicksignout();
		
		logger.log(LogStatus.PASS, "Signout Link is present");
	
	}
	
	@AfterMethod
	public void closeBrowser()
	{
		BrowserFactory.closeBrowser(driver);
		
		report.endTest(logger);
		report.flush();
	}
}
