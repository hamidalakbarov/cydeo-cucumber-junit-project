
Feature: Google search functionality
  Agile story: As a user, when I am on the Google search page I should be able to search anything and see relevant results

  Background: User is on the search page
    Given user is on the Google search page

  Scenario: Search page default title verification
    Then user should see title is Google

  Scenario: Google Search Title Verification
    When user searches for given keyword
    Then user should see keyword in title of the page

