package pageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage{
	WebDriverWait wait;

	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath= "//*[@id=\"input-email\"]")
	WebElement txtEmail;
	
	@FindBy(xpath= "//*[@id=\"input-password\"]")
	WebElement txtPassword;
	
	@FindBy(xpath= "//*[@id=\"content\"]/div/div[2]/div/form/input")
	WebElement btnLogin;
	
	@FindBy(xpath= "//*[@id=\"content\"]/h2[1]")
	WebElement hdMyAccount;
	
	@FindBy(xpath= "//*[@id=\"column-right\"]/div/a[13]")
	WebElement lnklogout;
	
	@FindBy(xpath= "//*[@id=\"column-right\"]/div/a[13]")
	WebElement btnAccountLogout;
	
	
	
	
	public void enterEmail(String email) {
		wait= new WebDriverWait(driver, Duration.ofSeconds(30));
		WebElement emails= wait.until(ExpectedConditions.visibilityOf((txtEmail)));
		emails.sendKeys(email);		
	}
	
	public void enterPassword(String password) {
		wait= new WebDriverWait(driver, Duration.ofSeconds(30));
		WebElement loginPassword= wait.until(ExpectedConditions.visibilityOf((txtPassword)));
		loginPassword.sendKeys(password);		
	}
	
	public void clkLoginBtn() {
		btnLogin.click();		
	}
		
	public void clkLogout() {
		try {
			Actions ac= new Actions(driver);
			ac.moveToElement(lnklogout).click();
			ac.perform();	
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	
	}
	
	public void btnContinueAccountLogout() {
		btnAccountLogout.click();
	}
	
	
	
	public boolean displayMyAccount() {
		try
		{
			return hdMyAccount.isDisplayed();
		}
		catch(Exception e)
		{
			return false;
		}
		
	}
	
	
	

}
