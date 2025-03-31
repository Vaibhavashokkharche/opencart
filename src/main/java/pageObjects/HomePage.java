package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
//Constructor	
public HomePage(WebDriver driver) {
	super(driver);
}
//Locator
@FindBy(xpath="//span[normalize-space()='My Account']") WebElement txt_myaccount;
@FindBy(xpath="//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Register']") WebElement txt_register;
@FindBy(xpath="//a[normalize-space()='Login']")WebElement txt_login;
@FindBy(xpath="//input[@placeholder='Search']") WebElement search_box;



//Action method
public void ClickMyAccount() {
	txt_myaccount.click();
	
}
public void ClickRegister() {
	txt_register.click();
}
public void ClickLogin() {  //Update in Login Test 
	txt_login.click();
}
public void ClickOnSerachBOX() {
	search_box.click();
}


}
