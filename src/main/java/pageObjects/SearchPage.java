package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends BasePage{
	
	
	//Constructor
  public SearchPage(WebDriver driver) {
	  super(driver);
  }
	//Locator
  @FindBy(xpath="//input[@placeholder='Search']")WebElement serachbox;
  @FindBy(xpath="//i[@class='fa fa-search']") WebElement clickonsearch;
  @FindBy(xpath="//h2[normalize-space()='Products meeting the search criteria']") WebElement result; //
  
  @FindBy(xpath="//div[@id='content']//div[1]//div[1]//div[2]//div[1]//h4[1]//a[1]") WebElement searchResult;
  @FindBy(xpath="//button[@id='button-cart']") WebElement addtocartbutton;
  @FindBy(xpath="//div[@class='alert alert-success alert-dismissible']") WebElement SuccessMessage;
	//Action Method
  public void SearchProduct(String product) {
	 
	  serachbox.sendKeys(product);
  }
	
  public void ClickButtonSerach() {
		clickonsearch.click();
	}
  public boolean Getproduct() {
	  return result.isDisplayed();
	  
  }
  public void clearSerach() {
	  
	  serachbox.clear();
  }
  
public void ClickonProduct() {
		  searchResult.click();	  
		  
	  }
public void ClickonAddtoCart() {
	
	addtocartbutton.click();
	
}
public boolean GetSuccessMessage() {
	SuccessMessage.getText();
	return true;
}
 


  }
  

  
  
  
  
  
  
  
  
  
  
 
  
  
  
  

