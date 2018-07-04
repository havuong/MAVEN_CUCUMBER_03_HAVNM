Feature: PAYMENT FUNCTION
  As an Automation Test
  I want to create an Account
  So that I can verify register function work well

  @payment
  Scenario: [PAYMENT] - CREATE NEW ACCOUNT
    Given I get login url
    When I click to here link
    And I input to email textbox
    And I click to submit button at register page
    Then I get to username information
    And I get to password information

  @payment
  Scenario: [PAYMENT] - LOGIN WITH INFORMATION ABOVE
    Given I open to login page
    When I input to usernam textbox
    And I input to password textbox
    And I click to submit button at login page
    Then Verify homepage welcome message displayed

  Scenario Outline: [PAYMENT] - CREATE NEW CUSTOMER
    Given I click to New Customer page
    When I input all infomation to this page
      | CustomerName   | Gender   | DateOfBirth   | Address   | City   | State   | Pin   | Phone   | Email   | Password   |
      | <CustomerName> | <Gender> | <DateOfBirth> | <Address> | <City> | <State> | <Pin> | <Phone> | <Email> | <Password> |
    And I click to Submit button
    Then I verify customer created success with infomation
      | CustomerName   | Gender   | DateOfBirth   | Address   | City   | State   | Pin   | Phone   | Email   | Password   |
      | <CustomerName> | <Gender> | <DateOfBirth> | <Address> | <City> | <State> | <Pin> | <Phone> | <Email> | <Password> |

    Examples: 
      | CustomerName  | Gender | DateOfBirth | Address     | City   | State     | Pin    | Phone      | Email  | Password |
      | Manual Tester | male   | 01/02/2001  | 234 Address | Ha noi | Long Bien | 123456 | 0123654987 | manual |   123456 |
