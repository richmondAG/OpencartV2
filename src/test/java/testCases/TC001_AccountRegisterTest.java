package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.RegisterAccount;
import utilities.RandomData;

public class TC001_AccountRegisterTest extends BaseClass{
	RandomData rd= new RandomData();
	

	@Test(groups="Sanity")
	public void verify_AccountRegister(){
		logger.info("***** Starting TC001_AccountRegistrationTest *****");
		
		try {
		String password= rd.password();
		HomePage hp= new HomePage(driver);
		
		hp.clickMyAccount();
		logger.info("Clicked on MyAccount Link");
		RegisterAccount ra= hp.clickRegister();
		logger.info("Clicked on Register Link");
		
		logger.info("Provided Account Creation Details");
		ra.enterfirstName(rd.fullname());
		ra.enterLastName(rd.fullname());
		ra.enterEmail(rd.email());
		ra.enterTelephone(rd.telephone());
		ra.enterPassword(password);
		ra.enterConFirmPassword(password);
		ra.ChkPrivacyPolicy();
		ra.BtnContinue();
		
		logger.info("Validating Expected Message");
		String actual_AccountValiation= ra.accountCreatedValidation();
		Assert.assertEquals(actual_AccountValiation, "Your Account Has Been Created!");	
		}
		
		catch(Exception e) {
			logger.error("Test failed");
			Assert.fail();
		}
		logger.info("***** Finished TC001_AccountRegistratiomTest ****");
		
	}

}
