@payment
Feature: PAYMENT FUNCTION
  As an Automation Test
  I want to payment
  So that I can verify payment function work well

  Scenario: [PAYMENT] - CREATE NEW ACCOUNT
    Given I get login url
    When I click to here link
    And I input to email textbox
    And I click to submit button at register page
    Then I get to username information
    And I get to password information

  Scenario: [PAYMENT] - LOGIN WITH INFORMATION ABOVE
    Given I open to login page
    When I input to username textbox
    And I input to password textbox
    And I click to submit button at login page
    Then verify homepage welcome message displayed

  Scenario Outline: [PAYMENT] - CREATE NEW CUSTOMER
    Given I click to New customer page
    When I input all information to this page
      | CustomerName   | Gender   | DateOfBirth   | Address   | City   | State   | Pin   | Phone   | Email   | Password   |
      | <CustomerName> | <Gender> | <DateOfBirth> | <Address> | <City> | <State> | <Pin> | <Phone> | <Email> | <Password> |
    And I click to Submit button
    Then I verify customer created success with information
      | CustomerName   | Gender   | DateOfBirth   | Address   | City   | State   | Pin   | Phone   | Email   | Password   |
      | <CustomerName> | <Gender> | <DateOfBirth> | <Address> | <City> | <State> | <Pin> | <Phone> | <Email> | <Password> |

    Examples: 
      | CustomerName    | Gender | DateOfBirth | Address | City | State | Pin    | Phone     | Email      | Password |
      | Automation Test | female | 01/02/1990  | 123 TDT | HCM  | SG    | 123456 | 123456789 | automation |   123456 |
