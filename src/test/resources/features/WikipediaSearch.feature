@wikiSearch
Feature: Wikipedia Search Functionality

  # using Background for pre-conditions for all the scenarios in current feature file
  # using parameterization to be able to use different test data against the same step definition

  Background: All scenarios start with user being on Wikipedia home page
    Given user is on the Wikipedia home page

  Scenario: Wikipedia Search Functionality Title Verification
    When user types "Steve Jobs" in the wiki search box
    And user clicks wiki search button
    Then user sees "Steve Jobs" is in the "wiki title"
  @scenarioOutline @regression
  Scenario: Wikipedia Search Functionality Header Verification
    When user types "Steve Jobs" in the wiki search box
    And user clicks wiki search button
    Then user sees "Steve Jobs" is in the "main header"

  @scenarioOutline
  Scenario: Wikipedia Search Functionality Image Header Verification
    When user types "Steve Jobs" in the wiki search box
    And user clicks wiki search button
    Then user sees "Stev Job" is in the "image header"

  Scenario Outline: Wikipedia Search Functionality with Scenario Outline
    Given user is on the Wikipedia home page
    When user types "<keyword>" in the wiki search box
    And user clicks wiki search button
    Then user sees "<title>" is in the "wiki title"
    Then user sees "<mainHeader>" is in the "main header"
    Then user sees "<imageHeader>" is in the "image header"
    Examples: Search values are going to use these scenario outlines
      | keyword      | title        | mainHeader   | imageHeader  |
      | Steve Jobs   | Steve Jobs   | Steve Jobs   | Steve Jobs   |
      | Marc Benioff | Marc Benioff | Marc Benioff | Marc Benioff |
      #| Elon Musk    | Elon Musk    | Elon Musk    | Elon Musk    |


  Scenario Outline: Wikipedia Search Functionality with Scenario Outline
    Given user is on the Wikipedia home page
    When user types "<searchWOrd>" in the wiki search box
    And user clicks wiki search button
    Then user sees "<title>" is in the "wiki title"
    Examples: these scenario outlines will be used as a search value
      | searchWOrd        | title             |
      | Cristiano Ronaldo | Cristiano Ronaldo |
      | Marc Benioff      | Marc Benioff      |
