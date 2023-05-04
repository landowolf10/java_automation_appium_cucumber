Feature: Successful login
  Scenario: Successful login
    Given app is open
    When entering email standard_user and password secret_sauce
    And press login button
    #Then verify user successfully logged in