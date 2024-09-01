package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterAccount extends BasePage {

	public RegisterAccount(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//*[@id=\"input-firstname\"]")
	WebElement txtFirstName;
	
	@FindBy(xpath="//*[@id=\"input-lastname\"]")
	WebElement txtLastName;

	@FindBy(xpath="//*[@id=\"input-email\"]")
	WebElement txtEmail;
	
	@FindBy(xpath="//*[@id=\"input-telephone\"]")
	WebElement txtTelephone;
	
	@FindBy(xpath="//*[@id=\"input-password\"]")
	WebElement txtPassword;
	
	@FindBy(xpath="//*[@id=\"input-confirm\"]")
	WebElement txtConFirmPassword;
	
	@FindBy(xpath="//*[@id=\"content\"]/form/div/div/input[1]")
	WebElement chkPrivacyPolicy;
	
	@FindBy(xpath="//*[@id=\"content\"]/form/div/div/input[2]")
	WebElement btnContinue;
	
	@FindBy(xpath="//*[@id=\"content\"]/h1")
	WebElement AccountValidation;
	

	
	
	public void enterfirstName(String firstname) {
		 txtFirstName.sendKeys(firstname);	
	}
	
	public void enterLastName(String lastname) {
		txtLastName.sendKeys(lastname);
	}

	public void enterEmail(String email) {
		txtEmail.sendKeys(email);
	}

	public void enterTelephone(String telephone) {
		txtTelephone.sendKeys(telephone);
	}


	public void enterPassword(String password) {
		txtPassword.sendKeys(password);
	}

	public void enterConFirmPassword(String confirmpassword) {
		txtConFirmPassword.sendKeys(confirmpassword);
	}

	public void ChkPrivacyPolicy() {
		chkPrivacyPolicy.click();
	}

	public void BtnContinue() {
		btnContinue.click();
	}	
	
	public String accountCreatedValidation() {
		try{
			return AccountValidation.getText();
		}
		catch(Exception e) {
			return (e.getMessage());
		}
		
		
	}

}
