Feature: Customer

Background: Steps common for all scenarios
Given User launch Chrome browser
When User opens URL "https://admin-demo.nopcommerce.com/login"
And User enters Email as "admin@yourstore.com" and Password as "admin"
And User clicks on Login button
Then User can view Dashboard
  
  @Sanity @Regression  
  Scenario: Add a new Customer
    When User clicks on Customers menu
    And Click on Customers Menu item
    And Click on Add New button
    Then User can view Add A new Customer page
    When User enter Customer info
    And Click on Save button
    Then User can view confirmation message "The new customer has been added successfully."
    And Close browser
    
  @Regression  
  Scenario: Search Customer by Email
    When User clicks on Customers menu
    And Click on Customers Menu item
    And Enter Customer Email in search section
    When Click on search button
    Then User should found desired Email in search result table
    And Close browser
    
   @Regression 
   Scenario: Search Customer by Name
    When User clicks on Customers menu
    And Click on Customers Menu item
    And Enter Customer First Name in search section
    And Enter Customer Last Name in search section
    When Click on search button
    Then User should found desired Name in search result table
    And Close browser
