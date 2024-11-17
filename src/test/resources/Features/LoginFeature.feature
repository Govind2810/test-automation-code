Feature: Test login functionality

  Scenario: 
    Given browser is open and ready for automation
    And user is on login page
    When user enters the valid username and password
    And user clicks on login button
    Then user should be able to login
