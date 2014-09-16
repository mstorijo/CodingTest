Feature: As a customer I want to search for a book

  Scenario: Search results match search term
    Given Customer is viewing the front page
    When she searches for "alice in wonderland"
    Then the first result matches the search term


  Scenario: Search for incorrect term give no results
    Given Customer is viewing the front page
    When she searches for "wanderland"
    Then she gets no results


  Scenario: Search results and book details match
    Given Customer is viewing the front page
    When she searches for "Gaiman"
    And she selects a book
    Then all book attributes match the clicked search result

