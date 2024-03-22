Feature: Delete Venue

  Scenario: Delete Non-Existing Venue
    Given The user entered information about the venue
    When The user attempts to delete a venue
    Then The system notifies the user that there are no venues to delete
    
      Scenario: Delete Existing Venue
    Given There exists a venue in the venues list
    When The user wants to delete a venue and The user provides the venue name
    Then The system deletes the venue
    