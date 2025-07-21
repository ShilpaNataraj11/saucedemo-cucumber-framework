Feature: Login Feature

  Scenario: Valid login
    Given user is on login page
    When user enters username and password
    And clicks the login button
    Then user should be navigated to the inventory page

  Scenario: Invalid login
    Given user is on login page
    When user enters invalid username or password
    Then error message should be displayed