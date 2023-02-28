
# .feature file to create business layer by using gherkin language
# There is one user story and multiple acceptance criteria.
# Each AC will become to scenario
# Each scenario will have multiple steps
# Each step will have its own definition, definition into Java code, a regular method
# If we have same steps in multiple scenarios we will use one step definition for both.


Feature: Library login feature

  User Story:
  As a user, I should be able to login with correct credentials to different accounts. And dashboard should be displayed.
  Accounts are: librarian, student, admin

  # Using Background: keyword
  # This step will be executed before each scenario in this Feature file
  Background: For all scenarios in this feature file user is on the login page of library application
     # step 1
    Given user is on the login page of library application

  # AC1
  Scenario: Login as librarian
    # step 2
    When user enters librarian username
    # step 3
    And user enters librarian password
    # step 4
    Then user should see the dashboard

  # AC2
  Scenario: Login as student
    # step 2
    When user enters student username
    # step 3
    And user enters student password
    # step 4
    Then user should see the dashboard

  # AC3
  Scenario: Login as an admin
    # step 2
    When user enters admin username
    # step 3
    And user enters admin password
    # step 4
    Then user should see the dashboard

# ----------------------------------------------------------------------------------------------------------------------
  # tags are used to control which scenarios to run by using CukesRunner class. We can create and use any tag
  # If the tag is used on feature level, it will apply to all the scenarios, each and every scenario will be executed
  # If the tag is used on scenario level, only that scenario will be executed
  # One scenario can have multiple tags

  # There are 3 types of tags for controlling which scenario to run:
  #   1. or
  #   2. and
  #   3. and not
# ----------------------------------------------------------------------------------------------------------------------
  # dryRun







