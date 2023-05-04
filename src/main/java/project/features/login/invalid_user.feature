Feature: Invalid user login
  Scenario: Invalid user
    Given app is open
    When entering email standard_use and password secret_sauce
    And press login button
    Then verify user login was not successful