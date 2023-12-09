package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	public WebDriver ldriver;
	
	public LoginPage(WebDriver rdriver){
		ldriver=rdriver;
		PageFactory.initElements(ldriver, this);
	}

	@FindBy(xpath = "//input[@id='Email']")
	WebElement emailFld;

	@FindBy(xpath = "//input[@id='Password']")
	WebElement passwordFld;

	@FindBy(xpath = "//button[@class='button-1 login-button']")
	WebElement loginBtn;

	@FindBy(linkText = "Logout")
	WebElement logoutLink;
	
	public void enterEmail(String emailId) {
		emailFld.clear();
		emailFld.sendKeys(emailId);
	}

	public void enterPassword(String password) {
		passwordFld.clear();
		passwordFld.sendKeys(password);
	}

	public void clickLoginBtn() {
		loginBtn.click();
	}

	public void clickLogoutLink() {
		logoutLink.click();
	}
	
}

