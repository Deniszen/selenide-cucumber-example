@test
Feature: Google search

  @success
  Scenario: Search
    Given user open google service
    When user typed "selenium" into search string
    Then user has seen 10 results on page
    And user saw a 1 link to "https://ru.wikipedia.org › wiki › Selenium"