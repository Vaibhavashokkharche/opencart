package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseTest;
import utilities.Dataprovider;

public class LoginDDT extends BaseTest {
	@Test(dataProvider="logindata" ,dataProviderClass = Dataprovider.class ,groups={"Regression","Master" })
	public void TC003LoginDDtest(String email, String pwd, String expresult) {
		//logger.info("Starting The LoginDDt");
		// HomePage
		HomePage hp = new HomePage(driver);
		hp.ClickMyAccount();
		hp.ClickLogin();
		// Login Page
		LoginPage lp = new LoginPage(driver);
		lp.SetEmail(email);
		lp.SetPassword(pwd);
		lp.ClickLogin();
		MyAccountPage mp = new MyAccountPage(driver);
		boolean status = mp.LoginExists();
		
		
		
		// Data is valid == login sucessful(Test Is paased)
		// Login failed (Test is failed)

		// Data Is invalid== Login Successful (Test Failed)
		// Login Failed (Test Passed)

		if (expresult.equalsIgnoreCase("Valid")) {
			if (status = true) {
				mp.ClickLogout();
				Assert.assertTrue(true);
			}
		} else {
			Assert.assertTrue(false);
		}

		if (expresult.equalsIgnoreCase("Invalid")) {
			if (status = true) {
				mp.ClickLogout();
				Assert.assertTrue(false);
			}
		} else {
			Assert.assertTrue(true);
		}
		//logger.info("Finished the loginDDt ");
	}
	
	
	
	
	
	
	

}
