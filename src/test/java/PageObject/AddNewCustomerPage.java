package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddNewCustomerPage {
	
	public WebDriver ldriver;
	
	public AddNewCustomerPage(WebDriver rdriver){
		ldriver=rdriver;
		PageFactory.initElements(ldriver, this);
	}
	
	@FindBy(xpath = "//a[@href='#']//p[contains(text(),'Customers')]")
	WebElement customerMenu;

	@FindBy(xpath = "//a[@href='/Admin/Customer/List']//p[contains(text(),'Customers')]")
	WebElement customerMenuItem;
	
	@FindBy(xpath = "//a[@class='btn btn-primary']")
	WebElement addNewButton;
	
	@FindBy(xpath = "//input[@id='Email']")
	WebElement emailField;
	
	@FindBy(xpath = "//input[@id='Password']")
	WebElement pwdField;
	
	@FindBy(xpath = "//input[@id='FirstName']")
	WebElement firstNameField;
	
	@FindBy(xpath = "//input[@id='LastName']")
	WebElement lastNameField;
	
	@FindBy(xpath = "//input[@id='Gender_Male']")
	WebElement genderRadioBtn;
	
	@FindBy(xpath = "//input[@id='DateOfBirth']")
	WebElement dobField;
	
	@FindBy(xpath = "//input[@id='Company']")
	WebElement companyNameField;
	
	@FindBy(xpath = "//input[@id='IsTaxExempt']")
	WebElement taxExmptCheckbox;
	
	@FindBy(xpath = "//textarea[@id='AdminComment']")
	WebElement adminCommentField;
	
	@FindBy(xpath = "//button[@name='save']")
	WebElement saveButton;
	
	@FindBy(tagName = "body")
	WebElement successMessage;
	
	
	
	public String getDashboardPageTitle() {
		return ldriver.getTitle();
	}
	
	public void clickOnCustomerMenu() {
		customerMenu.click();
	}
	
	public void clickOnCustomerMenuItem() {
		customerMenuItem.click();
	}
	
	public void clickOnAddNewButton() {
		addNewButton.click();
	}
	
	public String getAddNewCustPageTitle() {
		return ldriver.getTitle();
	}
	
	public void enterEmail(String email) {
		emailField.clear();
		emailField.sendKeys(email);
	}
	
	public void enterPassword(String pwd) {
		pwdField.clear();
		pwdField.sendKeys(pwd);
	}
	
	public void enterFirstName(String fName) {
		firstNameField.clear();
		firstNameField.sendKeys(fName);
	}
	
	public void enterlastName(String lName) {
		lastNameField.clear();
		lastNameField.sendKeys(lName);
	}
	
	public void selectGender() {
		genderRadioBtn.click();
	}
	
	public void enterDOB(String dob) {
		dobField.clear();
		dobField.sendKeys(dob);
	}
	
	public void enterCompanyName(String companyName) {
		companyNameField.clear();
		companyNameField.sendKeys(companyName);
	}
	
	public void selectTaxExempt() {
		taxExmptCheckbox.click();
	}
	
	public void enterAdminComment(String comment) {
		adminCommentField.clear();
		adminCommentField.sendKeys(comment);
	}
	
	public void clickSaveButton() {
		saveButton.click();
	}
	
	public String getSuccessMessage() {
		String actSuccessMessage = successMessage.getText();
		return actSuccessMessage;
	}
}
