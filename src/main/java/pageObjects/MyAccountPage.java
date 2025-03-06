package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage {
//Constructor
	
	public MyAccountPage(WebDriver driver) {
		
		super(driver);
	}
	
	
	
	
	//Locator
	
	@FindBy(xpath="//h2[normalize-space()='My Account']") WebElement getmsg; 
	@FindBy(xpath="//a[@class='list-group-item'][normalize-space()='Newsletter']") WebElement logoutlink;
	
	
	// Action Methods
	public boolean LoginExists() {
		try {
			return getmsg.isDisplayed();
		} catch (Exception e) {
			return false;
		}

	}

	public void ClickLogout() {
		logoutlink.click();
	}
}