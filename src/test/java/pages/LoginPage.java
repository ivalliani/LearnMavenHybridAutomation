package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.*;
import factory.BrowserFactory;

public class LoginPage {
	
	WebDriver driver;
	
	@Test
	public void LoginPage(WebDriver Idriver)
	{
		 this.driver=Idriver;
	}
	
	@FindBy(id="email") WebElement username;
	
	@FindBy(id="pass") WebElement password;
	
	@FindBy(id="send2") WebElement submit;
	
	@FindBy(xpath="html/body/div[1]/header/div[2]/div[1]/ul/li[2]/span/button") WebElement signoutdropdownbutton;
	
	@FindBy(xpath="html/body/div[1]/header/div[2]/div[1]/ul/li[2]/div/ul/li[3]/a") WebElement clickonsignout;
	
	public void loginApplication(String user, String pass)
	{
		username.sendKeys(user);
		
		password.sendKeys(pass);
		
		submit.click();
		
		
	}

	public void signoutDropdown() 
	{
		signoutdropdownbutton.click();
		
	
	}
	
	public void clicksignout()
	{
		clickonsignout.click();
	}
}
