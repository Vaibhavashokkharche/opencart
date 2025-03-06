package testCases;


import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.RegistrationPage;
import testBase.BaseTest;

public class AccountRegistrationTest extends BaseTest {
	WebDriver driver;

    @Test(groups={"Regression","Master" })
	public void TC_001AccountRegistertest() {
    	logger.info("********Strating TC_001AccountRegistertest ");
		try {
    	HomePage hp=new HomePage(driver);
	
		hp.ClickMyAccount();
		logger.info("Clicked on My Account");
		hp.ClickRegister();
		logger.info("Clicked on Register Account");
		RegistrationPage rp=new RegistrationPage(driver);
		logger.info("Provide the customer details");
		rp.SetFirstName(RandomString().toUpperCase());
		rp.SetLastName(RandomString().toUpperCase());
		rp.SetTelephone(Randomint());
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
		rp.SetEmail(RandomString()+"@gmail.com");
		String password=randomAlphaNumeric();
		
		rp.SetPassword(password);
		rp.SetConfirmPassword(password);
		rp.ClickCheckbox();
		rp.ClickContinue();;
		logger.info("Validating the expected message");
	String Confirmmsg=rp.GetConfirmationMsg();
		Assert.assertEquals(Confirmmsg,"Your Account Has Been Created!");
	}catch(Exception e) {
		logger.error("Test Faild");
		logger.debug("debug logs ");
		
		
	}
		logger.info("********Finished TC_001AccountRegistertest ");
		
		}
    


    }

