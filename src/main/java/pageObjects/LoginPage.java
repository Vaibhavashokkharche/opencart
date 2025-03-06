package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{
	//Constructor 
	public  LoginPage(WebDriver driver ) {
	super(driver);
	}
	

	//Locator
	@FindBy(xpath="//input[@id='input-email']") WebElement txt_email;
	@FindBy(xpath="//input[@id='input-password']") WebElement txt_password;	
	
	@FindBy(xpath="//input[@value='Login']") WebElement btn_login;
	
	//Action Methods 
	
	public void SetEmail(String email) {
		txt_email.sendKeys(email);
		
	}
	public void SetPassword (String pwd) {
		txt_password.sendKeys(pwd);
		
	}
	
	public void ClickLogin() {
		btn_login.click();
		
	}
	
	
	
	
	
	

}
