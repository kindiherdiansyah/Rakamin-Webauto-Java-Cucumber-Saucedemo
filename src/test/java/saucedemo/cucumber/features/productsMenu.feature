@ProductsMenuRelease
Feature: Products Menu Saucedemo

  @TDD @Positive
  Scenario Outline: Verify user is able to buy products via Homepage
    Given Halaman login saucedemo
    When I input <username> as username
    And I input <password> as password
    And click login button
    And click Add to Cart button on one of the product or more
    And click Cart icon on the top right side
    And i check the shopping list and click button Checkout and directed page biodata form
    And I input <firstname> as first name
    And I input <lastname> as last name
    And I input <postalcode> as postal code
    And click Continue button
    And i check the shopping list and click the Finish button
    Then I verify <status> purchased the product and directed to Checkout: Complete Page
    And i can back to Homepage with click the Back Home button

    Examples:
      | username      | password     | firstname | lastname | postalcode | status  |
      | standard_user | secret_sauce | Alam      | Semesta  | 12345      | success |

  @TDD @Negative
  Scenario Outline: Verify user unable to buy products without input the buyer's biodata via Homepage
    Given Halaman login saucedemo
    When I input <username> as username
    And I input <password> as password
    And click login button
    And click Add to Cart button on one of the product or more
    And click Cart icon on the top right side
    And i check the shopping list and click button Checkout and directed page biodata form
    And I click Continue button without input biodata form
    Then I verify failed to buy product and system will display the warning message

    Examples:
      | username      | password      | status   |
      | standard_user | secret_sauce  | failed   |
