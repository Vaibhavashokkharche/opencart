package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.SearchPage;
import testBase.BaseTest;

public class Tc__004Addtocart extends BaseTest{
	
	
	@Test
	public void VerifyAddtocartItem() {
		
		SearchPage sp= new SearchPage(driver);
		sp.SearchProduct("Macbook");
		sp.ClickButtonSerach();
		sp.ClickonProduct();
		sp.ClickonAddtoCart();
		boolean ConfirmationMSg =sp.GetSuccessMessage();
		if(ConfirmationMSg==true) {
			System.out.println("Product added suceesfully");
			Assert.assertTrue(true);
			
		}else {
			
			System.out.println("Invalid product");
			Assert.assertTrue(false);
		}
		
		
		
		
	}

}
