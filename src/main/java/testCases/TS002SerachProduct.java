package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.SearchPage;
import testBase.BaseTest;
import utilities.Dataprovider;

public class TS002SerachProduct extends BaseTest{

	@Test(dataProvider ="product",dataProviderClass = Dataprovider.class)
	public void VerifySerachProduct(String productname, String expectedresult) {
		
		HomePage hp =new HomePage(driver);
		hp.ClickOnSerachBOX();
		SearchPage sp=new SearchPage(driver);
		sp.SearchProduct(productname);
		sp.ClickButtonSerach();
        boolean status=sp.Getproduct();
		
		//Validation
if(expectedresult.equalsIgnoreCase("valid")) {
if(status=true)	{
	sp.clearSerach();
	Assert.assertTrue(true);
}
else {
	sp.clearSerach();
	Assert.assertTrue(false);
	
}
}
if(expectedresult.equalsIgnoreCase("invalid")) {
	if(status=true)
		sp.clearSerach();
	Assert.assertTrue(false);
	
}else {
	sp.clearSerach();
	Assert.assertTrue(true);
}
}
	
	

}
