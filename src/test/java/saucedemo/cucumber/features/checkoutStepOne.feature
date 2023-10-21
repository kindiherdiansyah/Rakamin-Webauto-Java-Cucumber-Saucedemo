@CheckoutStepOneRelease
Feature: Checkout Step One Page Aplikasi Saucedemo

  @Regression @Positive
  Scenario: Verifikasi respon ketika mengisi biodata pembeli di checkout page dengan data yang valid
    Given Halaman login saucedemo
    When input username
    And input password
    And click login button
    And click Add to Cart button on one of the product or more
    And click Cart icon on the top right side
    And click button Checkout
    And User fill the buyer's biodata form and click the Continue button
    Then user is redirected to the Checkout: Overview page

  @Regression @Negative
  Scenario: Verifikasi respon ketika tanpa mengisi biodata pembeli di checkout page
    Given Halaman login saucedemo
    When input username
    And input password
    And click login button
    And click Add to Cart button on one of the product or more
    And click Cart icon on the top right side
    And click button Checkout
    And click the Continue button without input biodata
    Then user get error message "Error: First Name is required"

  @TDD
  Scenario Outline: Verifikasi respon ketika melakukan input informasi checkout
    Given Halaman login saucedemo
    When I input <username> as username
    And I input <password> as password
    And click login button
    And click Add to Cart button on one of the product or more
    And click Cart icon on the top right side
    And click button Checkout
    And I input <firstname> as first name
    And I input <lastname> as last name
    And I input <postalcode> as postal code
    And click Continue button
    Then I verify <status> checkout step one result

    Examples:
      | username      | password     | firstname | lastname | postalcode | status  |
      | standard_user | secret_sauce | Alam      | Semesta  | 12345      | success |
      | standard_user | secret_sauce |           |          |            | failed  |
