@AboutRelease
Feature: Menu All Items Aplikasi Saucedemo functionality

  @Regression @Positive
  Scenario: Success Menu About
    Given Halaman login saucedemo
    When input username
    And input password
    And click login button
    And click Title product
    And click burger menu button on the top left side
    And click Menu All Items
    Then user in on the dashboard page