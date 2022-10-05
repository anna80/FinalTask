Feature: Search
  As a user
  I want to find a product on the site
  So that I can be sure that a search functionality works correctly

  Scenario Outline: Search products by keyword
    Given User opens 'https://www.ebay.com/' page
    And User verify search field visibility
    When User searches products by '<keyword>' keyword
    Then Search result products are shown on the Search Results page
    And Each product title contains searching word '<keyword>'
    Examples:
      | keyword |
      | Samsung |