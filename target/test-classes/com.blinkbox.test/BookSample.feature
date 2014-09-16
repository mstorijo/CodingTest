Feature: As a customer I want to look at a book sample

Scenario: Navigation on book sample works
  Given Customer is viewing a book page
  And She clicks on view book sample in full screen
  Then the book sample loads in full screen
