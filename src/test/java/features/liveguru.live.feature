@liveguru
Feature: Demo for Scenario Outline/ DataTable function

  Scenario Outline: Login to Live Guru Site
    Given I open to live guru site
    And I open to my account page
    When I input to username textbox is "<Username>"
    And I input to password textbox is "<Password>"
    And I click to login button
    Then I verify homepage displayed with message is "<Message>"
    When I click to Account link
    And I click to Logout link

    Examples: 
      | Username                     | Password |Message|
      | automationvalid@gmail.com    |   111111 |My Dashboard|
      | automationvalid_01@gmail.com |   111111 |My Dashboard|
      | automationvalid_02@gmail.com |   111111 |My Dashboard|
