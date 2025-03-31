package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShoppingCart extends BasePage {
// Constructor
	public ShoppingCart(WebDriver driver) {
		super(driver);
		
	}
	//Locator
	@FindBy(xpath="//span[@class='hidden-xs hidden-sm hidden-md'][normalize-space()='Shopping Cart']")WebElement ShoppingCart;
	@FindBy(xpath="//button[@type='submit']") WebElement Removebutton;
	@FindBy(xpath="//div[@id='content']//p[contains(text(),'Your shopping cart is empty!')]") WebElement CartemptyMessage;
	
	
	
	//Action Methods
	public void ClickonShoppingCart() {
		ShoppingCart.click();
		
	}
	public void ClickonRemoveProductformcart() {
		Removebutton.click();
		
	}
	public boolean GetcartMessage() {
		CartemptyMessage.getText();
		return true;
	}

}
