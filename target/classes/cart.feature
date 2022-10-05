Feature: Cart
  As a user
  I want to verify a cart functionality
  So that I can be sure that a cart on the site works correctly

  Scenario: Verify that the cart popup is opened after clicking by shopping cart icon
    Given User opens 'https://www.ebay.com/' page
    And User verify the visibility of the cart icon
    When User clicks by the shopping cart icon
    Then Cart page with 'https://cart.payments.ebay.com/' url is opened

  Scenario Outline: Verify that user backs to home page by clicking on "Start shopping" button from the cart popup
    Given User opens '<homePage>' page
    And User verify the visibility of the cart icon
    When User clicks by the shopping cart icon
    Then Cart page with 'https://cart.payments.ebay.com/' url is opened
    When User clicks 'Start shopping' button
    Then '<homePage>' page is opened

    Examples:
      | homePage              |
      | https://www.ebay.com/ |

  Scenario: Verify that products are added to cart
    Given User opens 'https://www.ebay.com/' page
    And User verify search field visibility
    When User searches products by 'apple iphone 8' keyword
    Then Search result products are shown on the Search Results page
    When User clicks on the first product image on the Search Results page
    And User switches to new opened tab in browser
    And user selects 'Silver' Manufacturer Colour for product
    And user selects '64GB' Storage for product
    And User clicks 'Add to Cart' button on the Product page
    Then User verifies that 1 product in the cart
    And User verifies that cart heading contains text '1 item'

  Scenario: Remove product from the cart
    Given User opens 'https://www.ebay.com/' page
    And User verify search field visibility
    When User searches products by 'apple iphone 8' keyword
    Then Search result products are shown on the Search Results page
    When User clicks on the first product image on the Search Results page
    And User switches to new opened tab in browser
    And user selects 'Silver' Manufacturer Colour for product
    And user selects '64GB' Storage for product
    And User clicks 'Add to Cart' button on the Product page
    Then User verifies that 1 product in the cart
    And User clicks 'Remove' button
    Then User sees the message 'You don\'t have any items in your cart.' on the Cart page