Feature: Watchlist
  As a user
  I want to add products to watchlist
  So that I can be sure that a watchlist functionality works correctly

  Scenario Outline: Add product to watchlist
    Given User opens '<homePage>' page
    When User searches products by '<keyword>' keyword
    Then Search result products are shown on the Search Results page
    When User clicks on the first product image on the Search Results page
    And User switches to new opened tab in browser
    And user selects '<color>' Manufacturer Colour for product
    And user selects '<storage>' Storage for product
    And User clicks 'Add to Watchlist' button
    Then User sees that the button renamed to 'Watching'
    When User clicks to 'Watchlist' link on the top navigation bar
    Then User sees that 1 product is added to watchlist
    Examples:
      | homePage              | keyword        | color | storage          |
      | https://www.ebay.com/ | apple iphone 8 | Gold  | 64GB |


