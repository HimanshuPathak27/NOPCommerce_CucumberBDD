package StepDefinition;

import org.apache.logging.log4j.*;
import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import PageObject.AddNewCustomerPage;
import PageObject.LoginPage;
import PageObject.SearchCustomerPage;
import Utilities.ReadConfig;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.*;

public class StepDefinition extends BaseClass{
	
	@Before
	public void setup(){
		log = LogManager.getLogger("StepDefinition");
		
		config = new ReadConfig();
		String browser = config.getBrowser();
		
		if(browser.equals("chrome")) {
			driver = new ChromeDriver();
		}
		if(browser.equals("msedge")) {
			driver = new EdgeDriver();
		}
		if(browser.equals("firefox")) {
			driver = new FirefoxDriver();
		}

		driver.manage().window().maximize();
		
		log.info("Setup is Done");
	}
	
	@After
	public void tearDown() {
		driver.close();
	}
	
	@AfterStep
	public void addScreenshot(Scenario sc){
		if(sc.isFailed()) {
			final byte[] screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			sc.attach(screenshot, "image/png", sc.getName());
		}
	}

	//////////////////// LOGIN FEATURE ////////////////////

	@Given("User has already launch a browser")
	public void User_has_already_launch_a_browser() {
		
		loginpage = new LoginPage(driver);
		newCust = new AddNewCustomerPage(driver);
		searchCust = new SearchCustomerPage(driver);

		log.info("Browser is launched and maximized Successfully using Setup");
	}

	@When("User opens URL {string}")
	public void user_opens_url(String url) {
		driver.get(url);
		log.info("URL Opened Successfully");
	}

	@When("User enters Email as {string} and Password as {string}")
	public void user_enters_email_as_and_password_as(String emailId, String password) {
		loginpage.enterEmail(emailId);
		loginpage.enterPassword(password);
		log.info("Email ID & Password entered Successfully");
	}

	@When("User clicks on Login button")
	public void user_clicks_on_login_button() {
		loginpage.clickLoginBtn();
		log.info("Login Button is clicked Successfully");
	}

	@Then("Title of home page should be {string}")
	public void title_of_home_page_should_be(String expHomePageTitle) {
		String actualHomePageTitle = driver.getTitle();
		if(actualHomePageTitle.equals(expHomePageTitle)) {
			log.warn("Test Passed | Home Page title is matched");
			Assert.assertTrue(true);
		}
		else {
			log.warn("Test Failed | Home Page title is not matched");
			Assert.assertTrue(false);
		}
	}

	@When("User clicks on Log Out link")
	public void user_clicks_on_log_out_link() throws InterruptedException {
		Thread.sleep(2000);
		loginpage.clickLogoutLink();
		log.info("Logout Button is clicked Successfully");
	}

	@Then("Title of login page should be {string}")
	public void title_of_login_page_should_be(String expLoginPageTitle) {
		String actualLoginPageTitle = driver.getTitle();
		if(actualLoginPageTitle.equals(expLoginPageTitle)) {
			log.warn("Test Passed | Login Page title is matched");
			Assert.assertTrue(true);
		}
		else {
			log.warn("Test Failed | Login Page title is not matched");
			Assert.assertTrue(false);
		}
	}

	@Then("Close browser")
	public void close_browser() {
		log.info("Browser is closed Successfully");
	}

	//////////////////// ADD NEW CUSTOMER FEATURE ////////////////////

	@Then("User can view Dashboard")
	public void user_can_view_dashboard() {
		String actualTitle = newCust.getDashboardPageTitle();
		String expectedTitle = "Dashboard / nopCommerce administration";

		if(actualTitle.equals(expectedTitle)) {
			log.warn("Test Passed | Dashboard title is matched");
			Assert.assertTrue(true);
		}
		else {
			log.warn("Test Failed | Dashboard title is not matched");
			Assert.assertTrue(false);
		}
	}

	@When("User clicks on Customers menu")
	public void user_clicks_on_customers_menu() {
		newCust.clickOnCustomerMenu();
		log.info("Customer Menu is selected successfully");
	}

	@When("Click on Customers Menu item")
	public void click_on_customers_menu_item() {
		newCust.clickOnCustomerMenuItem();
		log.info("Customer Menu Item is selected successfully");
	}

	@When("Click on Add New button")
	public void click_on_add_new_button() {
		newCust.clickOnAddNewButton();
		log.info("Add New button is clicked successfully");
	}

	@Then("User can view Add A new Customer page")
	public void user_can_view_add_a_new_customer_page() {
		String actualTitle = newCust.getAddNewCustPageTitle();
		String expectedTitle = "Add a new customer / nopCommerce administration";

		if(actualTitle.equals(expectedTitle)) {
			log.warn("Test Passed | Add New Customer page title is matched");
			Assert.assertTrue(true);
		}
		else {
			log.warn("Test Failed | Add New Customer page title is not matched");
			Assert.assertTrue(false);
		}
	}

	@When("User enter Customer info")
	public void user_enter_customer_info() {
		newCust.enterEmail(generateEmailId() + "@nopcommerce.com");
		log.info("Email is entered successfully");
		newCust.enterPassword("test");
		log.info("Password is entered successfully");
		newCust.enterFirstName("QA");
		log.info("First Name is entered successfully");
		newCust.enterlastName("Automation");
		log.info("Last Name is entered successfully");
		newCust.selectGender();
		log.info("Gender is selected successfully");
		newCust.enterDOB("9/27/2000");
		log.info("Date of Birth is entered successfully");
		newCust.enterCompanyName("QA Studio");
		log.info("Company Name is entered successfully");
		newCust.selectTaxExempt();
		log.info("Tax Exempt is selected successfully");
		newCust.enterAdminComment("Please consider me as a customer for services");
		log.info("Admin Comment is entered successfully");
	}

	@When("Click on Save button")
	public void click_on_save_button() {
		newCust.clickSaveButton();
		log.info("Save button is clicked successfully");
	}

	@Then("User can view confirmation message {string}")
	public void user_can_view_confirmation_message(String expSuccessMessage) {
		String actSuccessMessage = newCust.getSuccessMessage();
		if(actSuccessMessage.contains(expSuccessMessage)) {
			log.warn("Test Passed | Confirmation message is matched");
			Assert.assertTrue(true);
		}
		else {
			log.warn("Test Failed | Confirmation message is not matched");
			Assert.assertTrue(false);
		}
	}

	//////////////////// Search Customer by Email ////////////////////

	@When("Enter Customer Email in search section")
	public void enter_customer_email_in_search_section() {
		searchCust.enterEmailForSearch("brenda_lindgren@nopCommerce.com");
		log.info("Customer Email for search is entered successfully");
	}

	@When("Click on search button")
	public void click_on_search_button() {
		searchCust.clickSearchBtn();
		log.info("Search button is clicked successfully");
	}

	@Then("User should found desired Email in search result table")
	public void user_should_found_desired_email_in_search_result_table() throws InterruptedException {
		Thread.sleep(3000);
		String actSearchedCustomer = searchCust.searchedCustomerByEmail();
		String expSearchedCustomer = "brenda_lindgren@nopCommerce.com"; 
		if(actSearchedCustomer.equals(expSearchedCustomer)) {
			log.warn("Test Passed | Desired Email found in Customer table");
			Assert.assertTrue(true);
		}
		else {
			log.warn("Test Failed | Desired Email not found in Customer table");
			Assert.assertTrue(false);
		}
	}

	//////////////////// Search Customer by Name ////////////////////

	@When("Enter Customer First Name in search section")
	public void enter_customer_first_name_in_search_section() {
		searchCust.enterFirstNameForSearch("Brenda");
		log.info("Customer First Name for search is entered successfully");
	}

	@When("Enter Customer Last Name in search section")
	public void enter_customer_last_name_in_search_section() {
		searchCust.enterLastNameForSearch("Lindgren");
		log.info("Customer Last Name for search is entered successfully");
	}

	@Then("User should found desired Name in search result table")
	public void user_should_found_desired_name_in_search_result_table() throws InterruptedException {
		Thread.sleep(3000);
		String actSearchedCustomer = searchCust.searchedCustomerByName();
		String expSearchedCustomer = "Brenda Lindgren"; 
		if(actSearchedCustomer.equals(expSearchedCustomer)) {
			log.warn("Test Passed | Desired Name found in Customer table");
			Assert.assertTrue(true);
		}
		else {
			log.warn("Test Failed | Desired Name not found in Customer table");
			Assert.assertTrue(false);
		}
	}
}
