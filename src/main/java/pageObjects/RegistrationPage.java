package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationPage extends BasePage {

	//Constructor
	public RegistrationPage(WebDriver driver) {
super(driver);
	}
	
	//Locator

@FindBy(xpath="//input[@id='input-firstname']") WebElement txt_firstname;
@FindBy(xpath="//input[@id='input-lastname']") WebElement txt_lastname;
@FindBy(name="email") WebElement txt_email;
@FindBy(xpath="//input[@id='input-telephone']") WebElement txt_telephone;

@FindBy(xpath="//input[@id='input-password']") WebElement txt_password; 
@FindBy(xpath="//input[@id='input-confirm']") WebElement txt_confirmpassword; 
@FindBy(xpath="//input[@name='agree']") WebElement checkbox_agree;
@FindBy(xpath="//input[@value='Continue']") WebElement btn_continue;
@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']") WebElement msgConfirmation;
//Action Method
public void SetFirstName(String firstname) {
	txt_firstname.sendKeys(firstname);
}
public void SetLastName(String lastname) {
	txt_lastname.sendKeys(lastname);
}
public void SetTelephone(String telephone) {
		txt_telephone.sendKeys(telephone);
	}

public void SetEmail(String email) {
	txt_email.sendKeys(email);
}
public void SetPassword(String password) {
	txt_password.sendKeys(password);
}
public void SetConfirmPassword(String confirmpassword) {
	txt_confirmpassword.sendKeys(confirmpassword);
}

public void ClickCheckbox() {
	checkbox_agree.click();
}
public void ClickContinue() {
	btn_continue.click();
}
public String GetConfirmationMsg() {
	try {
		return(msgConfirmation.getText());
	}
	catch (Exception e) {
		return (e.getMessage());
	}
}
}


