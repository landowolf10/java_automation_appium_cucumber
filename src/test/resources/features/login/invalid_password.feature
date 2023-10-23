Feature: Invalid password login
  Scenario: Invalid password
    Given app is open
    When entering email standard_user and password secret
    And press login button
    Then verify user login was not successful