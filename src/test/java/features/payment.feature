@tag
Feature: Payment feature
  As an automation tester
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
      | CustomerName | Gender | DateOfBirth | Address | City | State | PIN    | Phone     | Email      | Password |
      | Ha Vuong     | f      | 11/11/1991  | HCM     | HCM  | HCM   | 456789 | 123456789 | automation |   123456 |
    And Click to Submit button
    Then Verify Customer created successfully with message "Customer Registered Successfully!!!"
    And Customer infomation should be shown
      | CustomerName | Birthday   | City | Address | Phone       | Email    |
      | Ha Vuong     | 11/11/1991 | HCM  | HCM     | 01223456789 | autotest |
    And Get CustomerID for edit customer function

  @editCustomer
  Scenario: Edit Customer
    Given I open Edit Customer page
    When Input CustomerID
    And Click to Submit button
    And I quit browser
