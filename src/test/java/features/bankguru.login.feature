@account
Feature: CREATE ACCOUNT
  As an Automation Test
  I want to create an Account
  So that I can verify register function work well

  Scenario Outline: Create new Account
    Given I open brower
    And I get login url
    When I click to here link
    And I input to email textbox
    And I click to submit button at register page
    And I get to username information
    And I get to password information
    And I open to login page
    And I input to username textbox
    And I input to password textbox
    And I click to submit button at login page
    Then verify homepage welcome message displayed
    When I click to New customer page
    And I input all information to this page
      | CustomerName   | Gender   | DateOfBirth   | Address   | City   | State   | Pin   | Phone   | Email   | Password   |
      | <CustomerName> | <Gender> | <DateOfBirth> | <Address> | <City> | <State> | <Pin> | <Phone> | <Email> | <Password> |
    And I click to Submit button
    And I verify customer created success with information
      | CustomerName   | Gender   | DateOfBirth   | Address   | City   | State   | Pin   | Phone   | Email   | Password   |
      | <CustomerName> | <Gender> | <DateOfBirth> | <Address> | <City> | <State> | <Pin> | <Phone> | <Email> | <Password> |
    And I close the browser

    Examples: 
      | CustomerName    | Gender | DateOfBirth | Address | City | State | Pin    | Phone     | Email              | Password |
      | Automation Test | female | 01/02/1990  | 123 TDT | HCM  | SG    | 123456 | 123456789 | automation |   123456 |
