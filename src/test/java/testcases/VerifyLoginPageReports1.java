package testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestResult;
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
import utility.Helper;


public class VerifyLoginPageReports1 {
	
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
		int rownum=1;
		for (int i=0; i<rownum; i++)
		{
		login.loginApplication(DataProviderFactory.getExcel().getData(0, rownum, 0),DataProviderFactory.getExcel().getData(0, rownum, 1));
		
		logger.log(LogStatus.INFO, "Login to Application");
		System.out.println("The LoginPage Title "+driver.getTitle());
		
		logger.log(LogStatus.INFO, logger.addScreenCapture(Helper.captureScreenShots(driver, "validationSignInPage")));
		
		
		
		Thread.sleep(5000);
		
		rownum=rownum+1;
		}
		
		login.signoutDropdown();
		
		login.clicksignout();
		
		
		logger.log(LogStatus.PASS, "Signout Link is present");
		
		logger.log(LogStatus.INFO, logger.addScreenCapture(Helper.captureScreenShots(driver, "validationSignOut")));
		
	
	}
	
	@AfterMethod
	public void closeBrowser(ITestResult result)
	{
		
		if(result.getStatus()==ITestResult.FAILURE)
		{
			String Path=Helper.captureScreenShots(driver, result.getName());
			
			logger.log(LogStatus.FAIL, logger.addScreenCapture(Path));
		}
		BrowserFactory.closeBrowser(driver);
		
		report.endTest(logger);
		report.flush();
	}
}
