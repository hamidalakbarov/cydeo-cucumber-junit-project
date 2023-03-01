@bing @regression
Feature: Bing Search Functionality
  US: As a user, when I am on the Bing search page I should be able to search anything and see relevant results

  Background: The search page is opened
    Given user is on the Bing search page

  Scenario: Search result title verification
    When user searches for orange on Bing search box
    Then user should see title as a orange - Search


  Scenario: Search result title verification
    When user searches for "orange" on Bing search box
    Then user should see title as a "orange - Search"
