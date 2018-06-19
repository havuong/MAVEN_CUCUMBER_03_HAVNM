#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@tag
Feature: Payment feature
  As aa automation tester
  I want to create new customer
  So that I want to make sure payment correctly
  @login
  Scenario: Login
    Given I navigate to bank guru site
    When I input username and password
    And I click to Login button
    Then I verify Homepage displayed
 @newCustomer
  Scenario: Create new Customer and get NewCustomerID
    Given I open New Customer page
    And Input data to all fields required
      | CustomerName | Gender | DateOfBirth | Address | City    | State   | PIN    | Phone     | Email      | Password |
      | Dam Dao      | m      | 16/10/1989  | Da nang | Da nang | Da nang | 456789 | 123456789 | automation |   123456 |
    And Click to Submit button
    Then Verify Customer created successfully with message "Customer Registered Successfully!!!"
    And Customer infomation should be shown
      | CustomerName | Birthday   | City    | Address | Phone       | Email    |
      | Dam Dao      | 16/10/1989 | Da nang | Da nang | 01223456789 | autotest |
    And Get CustomerID for edit customer function
  @editCustomer
  Scenario: Edit Customer
    Given I open Edit Customer page
    When Input CustomerID
    And Click to Submit button
    And I quit browser