Feature: Checkout
  As a tester
  I want to verify a checkout page functionality
  So that I can make an order on the site

  Scenario Outline: Verify visibility of Checkout page sections
    Given User opens '<homePage>' page
    When User searches products by 'apple iphone 8' keyword
    Then Search result products are shown on the Search Results page
    When User clicks on the first product image on the Search Results page
    And User switches to new opened tab in browser
    And user selects 'Gold' Manufacturer Colour for product
    And user selects '64GB' Storage for product
    And User clicks 'Add to Cart' button on the Product page
    When User clicks on 'Go to checkout' button
    And User click 'Continue as guest' button
    Then Checkout page is opened
    And 1 product is present in 'Review item and shipping' section
    And 'Ship to' form is visible on the Checkout page
    And 'Pay with' section is visible
    And 'Confirm and pay' button is visible

    Examples:
      | homePage              |
      | https://www.ebay.com/ |





