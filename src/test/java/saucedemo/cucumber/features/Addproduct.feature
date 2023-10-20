@ProductRelease
Feature: Product functionality

  @TDD @Positive
  Scenario Outline: Ensure amount of card incremented when product added to cart

    Given Halaman login saucedemo
    When I input <username> as username
    And I input <password> as password
    And click login button
    When click Add to Cart button on one of the product or more
    Then I see the number of products in the cart increasing

    Examples:
      | username                | password      |
      | standard_user           | secret_sauce  |