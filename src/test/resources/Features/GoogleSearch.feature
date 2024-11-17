Feature: Feature to test the google search functionality

  Scenario: Validate google search is working
    Given browser is open
    And user is on google search page
    When user enters text in searchbox
    And clicks on search button
    Then user is navigated to the search results page
