Feature: Login 

  @Sanity @Regression
  Scenario: Successfull Login with valid credentials
    Given User launch Chrome browser
    When User opens URL "https://admin-demo.nopcommerce.com/login"
    And User enters Email as "admin@yourstore.com" and Password as "admin"
    And User clicks on Login button
    Then Title of home page should be "Dashboard / nopCommerce administration"
    When User clicks on Log Out link
		Then Title of login page should be "Your store. Login"
		And Close browser
		
	@Regression	
	Scenario Outline: Successfull Login with different credentials DDT
	  Given User launch Chrome browser
    When User opens URL "https://admin-demo.nopcommerce.com/login"
    And User enters Email as "<email>" and Password as "<password>"
    And User clicks on Login button
    Then Title of home page should be "Dashboard / nopCommerce administration"
    When User clicks on Log Out link
		Then Title of login page should be "Your store. Login"
		And Close browser
	  Examples: 
	  |email|password|
	  |admin@yourstore.com|admin|
	  |admin@yourstore.com|admin|
