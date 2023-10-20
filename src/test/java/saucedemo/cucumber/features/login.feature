@LoginRelease
Feature: Login Page Aplikasi Saucedemo

  @Regression @Positive
  Scenario: Success Login
    Given Halaman login saucedemo
    When input username
    And input password
    And click login button
    Then user in on the dashboard page

  @Regression @Negative
  Scenario: Failed Login
    Given Halaman login saucedemo
    When input username
    And input Invalid password
    And click login button
    Then user get error message

  @TDD
  Scenario Outline: User Login to saucedemo
    Given Halaman login saucedemo
    When I input <username> as username
    And I input <password> as password
    And click login button
    Then I verify <status> login result

    Examples:
      | username                | password              | status  |
      | standard_user           | secret_sauce          | success |
      | failed_user             | secret_sauce          | failed  |
      | performance_glitch_user | secret_sauce          | success |