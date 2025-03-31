package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.SearchPage;
import pageObjects.ShoppingCart;
import testBase.BaseTest;

public class Tc__005ProductRemoveFormCart extends BaseTest {
	
	
	@Test
	public void VerifyProductremoveformcartItem() {
		
		SearchPage sp= new SearchPage(driver);
		sp.SearchProduct("Macbook");
		sp.ClickButtonSerach();
		sp.ClickonProduct();
		sp.ClickonAddtoCart();
        ShoppingCart sc= new ShoppingCart(driver);
        sc.ClickonShoppingCart();
        sc.ClickonRemoveProductformcart();
       boolean status= sc.GetcartMessage();
       if(status==true){
    	   Assert.assertTrue(true);
    	   
       }else{
    	   Assert.assertTrue(false);
    	   
       }
       
}
}