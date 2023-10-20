@AboutRelease
Feature: Menu About Aplikasi Saucedemo functionality

  @Regression @Positive
  Scenario: Success Menu About
    Given Halaman login saucedemo
    When input username
    And input password
    And click login button
    And click burger menu button on the top left side
    And click Menu About
    Then user is redirected to the page saucelabs.com

  @TDD
  Scenario Outline: Verify Menu About Aplikasi Saucedemo functionality
    Given Halaman login saucedemo
    When I input <username> as username
    And I input <password> as password
    And click login button
    And click burger menu button on the top left side
    And click Menu About
    Then I verify <status> About result to the page saucelabs.com

    Examples:
      | username                | password              | status  |
      | standard_user           | secret_sauce          | success |