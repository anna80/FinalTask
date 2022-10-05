Feature: Navigation
  As a tester
  I want to verify a navigation functionality
  So that I can navigate to other pages

  Scenario Outline: Verify quantity of products per page using "Items Per Page" select options
    Given User opens 'https://www.ebay.com/' page
    And User verify search field visibility
    When User searches products by '<keyword>' keyword
    Then Search result products are shown on the Search Results page
    When User selects 'Items Per Page' value 25 at navigation menu
    Then User sees 25 products on the Search Results page
    Examples:
      | keyword |
      | Samsung |