@SmokeFeature
Feature: 

	@SmokeTest
  Scenario: 
    Given user is on login page
    When user enters username and password
    And clicks on login button
    Then user is navigated to the home page
