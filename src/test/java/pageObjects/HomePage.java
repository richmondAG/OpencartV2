package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
	
		
	public HomePage(WebDriver driver){
		super(driver);		
	}
	
	@FindBy(xpath="//*[@id=\"top-links\"]/ul/li[2]/a/span[2]")
	WebElement lnkMyAccount;
	
	@FindBy(xpath="//*[@id=\"top-links\"]/ul/li[2]/ul/li[1]/a")
	WebElement lnkRegister;
	
	@FindBy(xpath= "//*[@id=\"top-links\"]/ul/li[2]/ul/li[2]/a")
	WebElement lnkLogin;
	
	
	public void clickMyAccount() {
		lnkMyAccount.click();	
	}
	
	public RegisterAccount clickRegister() {
		lnkRegister.click();	
		return new RegisterAccount(driver);
	}
	
	public LoginPage clickLogin() {
		lnkLogin.click();
		return new LoginPage(driver);
		
	}
	
	
	
	
	
	
	
	

}
