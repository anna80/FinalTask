Feature: Registration & Sign in
  As a user
  I want to verify a registration and a sign in functionalities
  So that I can register or login on the site

  Scenario Outline: Verify that user is successfully registered
    Given User opens '<homePage>' page
    When User clicks by link 'Register'
    And User enters '<firstName>' first name
    And User enters '<lastName>' last name
    And User enters '<email>' email on Registration page
    And User enters '<password>' password on Registration page
    And User clicks 'Create account' button
    And User sees '<firstName>' on the top navigation bar
    Examples:
      | homePage              | firstName      | lastName      | email                      | password         |
      | https://www.ebay.com/ | FirstTestName3 | LastTestName3 | testuser333.auto@gmail.com | Automation123123 |

  Scenario Outline: Verify that user signed in
    Given User opens '<homePage>' page
    When User clicks by link 'Sign in'
    And User enters 'testuser.auto@gmail.com' email
    And User clicks 'Continue' button
    And User enters 'Automation123123' password
    And User clicks 'Sign in' button
    And User sees '<firstName>' on the top navigation bar
    Examples:
      | homePage              | firstName     |
      | https://www.ebay.com/ | FirstTestName |




