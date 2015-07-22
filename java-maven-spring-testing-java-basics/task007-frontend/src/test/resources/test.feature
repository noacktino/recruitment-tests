Feature: CharGrouping

  Scenario: char grouping

    When I load the chargroup-page
    And I enter a simple text in the input field
    And I hit the group-button
    Then I should see the correct output
