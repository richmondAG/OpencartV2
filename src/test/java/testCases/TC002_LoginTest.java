package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import utilities.DataProviders;

public class TC002_LoginTest extends BaseClass {
	
	@Test(dataProvider="LoginData", dataProviderClass=DataProviders.class)
	public void verify_Login(String email, String password, String re) throws InterruptedException {
		logger.info("***** TC002 LoginTest *****");
		
		try {
			
	
		
		HomePage hp= new HomePage(driver);
		hp.clickMyAccount();
		LoginPage lp= hp.clickLogin();
		logger.info("Entered Costumer Email, Password");
		lp.enterEmail(email);
		lp.enterPassword(password);
		lp.clkLoginBtn();
		
		logger.info("Validating Expected DataDriven Message");
		boolean myAccountisDisplayed= lp.displayMyAccount();
		
		if(re.equalsIgnoreCase("valid")) {
			if(myAccountisDisplayed==true) {
				lp.clkLogout();
				lp.btnContinueAccountLogout();
				Assert.assertTrue(true);
				
			}
			else
			{
				Assert.assertTrue(false);
			}
			
		}
		
		if(re.equalsIgnoreCase("invalid")) 
		{
			if(myAccountisDisplayed==true) {
				lp.clkLogout();
				lp.btnContinueAccountLogout();
				Assert.assertTrue(false);
			}
			else {
				Assert.assertTrue(true);
			}
		}
		}
		catch(Exception e) {
			Assert.fail();
			
		}		
		logger.info("***** Finished TC002 LoginTest ****");
	}

}
