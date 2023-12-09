package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchCustomerPage {

	public WebDriver ldriver;
	
	public SearchCustomerPage(WebDriver rdriver){
		ldriver=rdriver;
		PageFactory.initElements(ldriver, this);
	}
	
	@FindBy(xpath = "//input[@id='SearchEmail']")
	WebElement emailTextBox;
	
	@FindBy(xpath = "//button[@id='search-customers']")
	WebElement searchButton;
	
	@FindBy(xpath = "//table[@id='customers-grid']//tbody//tr//td[2]")
	WebElement emailSearchResult;
	
	@FindBy(xpath = "//input[@id='SearchFirstName']")
	WebElement firstNameTextBox;
	
	@FindBy(xpath = "//input[@id='SearchLastName']")
	WebElement lastNameTextBox;
	
	@FindBy(xpath = "//table[@id='customers-grid']//tbody//tr//td[3]")
	WebElement nameSearchResult;
	
	
	
	public void enterEmailForSearch(String emailId) {
		emailTextBox.clear();
		emailTextBox.sendKeys(emailId);
	}
	
	public void clickSearchBtn() {
		searchButton.click();
	}
	
	public String searchedCustomerByEmail() {
		return emailSearchResult.getText();
	}
	
	public void enterFirstNameForSearch(String firstName) {
		firstNameTextBox.clear();
		firstNameTextBox.sendKeys(firstName);
	}
	
	public void enterLastNameForSearch(String lastName) {
		lastNameTextBox.clear();
		lastNameTextBox.sendKeys(lastName);
	}
	
	public String searchedCustomerByName() {
		return nameSearchResult.getText();
	}
}
