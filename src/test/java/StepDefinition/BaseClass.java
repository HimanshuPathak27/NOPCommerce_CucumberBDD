package StepDefinition;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.logging.log4j.*;
import org.openqa.selenium.WebDriver;

import PageObject.AddNewCustomerPage;
import PageObject.LoginPage;
import PageObject.SearchCustomerPage;
import Utilities.ReadConfig;

public class BaseClass {
	
	public static WebDriver driver;
	public LoginPage loginpage;
	public AddNewCustomerPage newCust;
	public SearchCustomerPage searchCust;
	public static Logger log;
	public ReadConfig config;
	
	public String generateEmailId() {	
		return RandomStringUtils.randomAlphabetic(5);
	}
	
}
