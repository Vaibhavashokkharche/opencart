package testCases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseTest;

public class Tc_002LoginTest extends BaseTest {

		 @Test(groups={"Sanity","Master" })
	public void VerifyLogin() {
			
			try {
				
	//HomePage			
	HomePage hp= new HomePage(driver);
		logger.info("****Starting the Login Test***");	
	hp.ClickMyAccount();
	hp.ClickLogin();
	
	logger.info("** navigationg towards Login  Page");
	//LoginPage
	LoginPage lp= new LoginPage(driver) ;
	lp.SetEmail(p.getProperty("email"));
	lp.SetPassword(p.getProperty("password"));
	lp.ClickLogin();
	
	///MyAcount
	MyAccountPage Macc=new MyAccountPage(driver);
	boolean TargetPage=Macc.LoginExists();
  org.testng.Assert.assertEquals(TargetPage, true);}
			catch(Exception e){
				System.out.println("Login failed");
				org.testng.Assert.fail();
			}
logger.info("LogintestFinished");
}}