package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.internal.BaseClassFinder;

import testBase.BaseTest;

public class Tc__001HomePageExists extends BaseTest{
	@Test
	public void VerifyHomePage() {
		driver.get("https://tutorialsninja.com/demo/");
		Assert.assertEquals(driver.getTitle(), "Your Store");
		
		
	}
	
	
	
	
	
	
	
	

}
