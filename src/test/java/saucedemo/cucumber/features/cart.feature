@CartRelease
Feature: Cart Page Aplikasi Saucedemo

  @Regression @Positive
  Scenario: verify response when clicking the checkout button on the cart after adding a product
    Given Halaman login saucedemo
    When input username
    And input password
    And click login button
    And click Add to Cart button on one of the product or more
    And click Cart icon on the top right side
    Then click button Checkout and go to the checkout page to fill in the information

  @Regression @Negative
  Scenario: verify response when clicking the checkout button on the cart without adding a product
    Given Halaman login saucedemo
    When input username
    And input password
    And click login button
    And click Cart icon on the top right side
    Then verify click button Checkout and get error

  @Regression @Positive
  Scenario: Ensure the Continue Shopping button on the cart page functions correctly
    Given Halaman login saucedemo
    When input username
    And input password
    And click login button
    And click Add to Cart button on one of the product or more
    And click Cart icon on the top right side
    Then Click the Continue Shopping button and success return to the homepage products

