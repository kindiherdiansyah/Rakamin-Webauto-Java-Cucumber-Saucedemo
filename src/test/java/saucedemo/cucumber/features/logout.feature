@LogoutRelease
Feature: Menu Logout Aplikasi Saucedemo

  @Regression @Positive
  Scenario: Success Logout
    Given Halaman login saucedemo
    When input username
    And input password
    And click login button
    And click burger menu button on the top left side
    And click Menu Logout
    Then user back to login page saucedemo

  @TDD
  Scenario Outline: Verify User Logout to saucedemo
    Given Halaman login saucedemo
    When I input <username> as username
    And I input <password> as password
    And click login button
    And click burger menu button on the top left side
    And click Menu Logout
    Then I verify <status> logout result back to login page saucedemo

    Examples:
      | username                | password              | status  |
      | standard_user           | secret_sauce          | success |