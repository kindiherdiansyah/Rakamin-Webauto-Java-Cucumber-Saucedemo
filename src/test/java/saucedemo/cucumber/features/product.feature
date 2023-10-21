@ProductRelease
Feature: Product functionality

  @Regression @Positive
  Scenario: make sure you can view the product details
    Given Halaman login saucedemo
    When input username
    And input password
    And click login button
    And click Title product
    Then I see view the product details

  @Regression @Positive
  Scenario: Make sure the quantity on the cart icon decreases when you click remove product
    Given Halaman login saucedemo
    When input username
    And input password
    And click login button
    And click Add to Cart button on two of the product
    And click remove on the product
    Then I see the the quantity on the cart icon decreases

  @Regression @Positive
  Scenario: Make sure the quantity on the cart icon decreases when you click remove product
    Given Halaman login saucedemo
    When input username
    And input password
    And click login button
    And click Add to Cart button on two of the product
    And click remove on the product
    Then I see the the quantity on the cart icon decreases

  @TDD @Positive
  Scenario Outline: Ensure the amount on the cart icon increases when you click add to cart product

    Given Halaman login saucedemo
    When I input <username> as username
    And I input <password> as password
    And click login button
    When click Add to Cart button on two of the product
    Then I see the number of products in the cart increasing

    Examples:
      | username                | password      |
      | standard_user           | secret_sauce  |