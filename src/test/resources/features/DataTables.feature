@datatables
Feature: Cucumber Data Tables implementation practice

  US: As a user, I want to be able to enter my favorite pets into table

  Scenario: List of pets that I love
    When user provides favorite list of favorite pets
    Then user should see pets as a below list
    # using PIPES for each element that will be stored into a list
      | Dog    |
      | Cat    |
      | Fish   |
      | Horse  |
      | Parrot |
      |        |

  Scenario: Officer reads data about driver
    Then officer is able to see any data he wants
      # we using triple PIPES for map data structure
      | name     | Elon   |
      | lastName | Musk   |
      | address  | Austin |
      | state    | TX     |
      | car      | Tesla  |
