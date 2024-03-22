Feature: Edit Venue Details

  Scenario: Venue Not Found
    Given The user wants to update a venue and The venue does not exist in the venues list
    When The user provides the new venue details
    Then The system displays a message that the venue was not found
