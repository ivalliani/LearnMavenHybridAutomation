package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {

	
	WebDriver driver;
	public HomePage(WebDriver Idriver)
	{
		this.driver=Idriver;
	}
		
		@FindBy(xpath="html/body/div[1]/header/div[2]/div[1]/ul/li[2]/a") WebElement signInlink;
		
		@FindBy(xpath="//a[text()='My Cart'") WebElement MyAccountlink;
		
		@FindBy(xpath="//a[text()='Create an Account'") WebElement CreateAccountlink;
		
		
		
		public void clickonSigninlink()
		{
			signInlink.click();
		}
		
		public void clickonmyAccountLink()
		{
			MyAccountlink.click();
		}
		
		public void clickonCreateAccountLink()
		{
			CreateAccountlink.click();
		}
		
		public String getApplicationTitle()
		{
			return driver.getTitle();
			
		}
	
}
