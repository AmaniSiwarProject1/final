Feature: Add Venue Successfully


  Scenario: Add a new venue
    Given the User is logged in and there is no venue named "Venue1"
    When the User adds a new venue named "Venue1"
    Then the new venue should be added successfully
    
Scenario: Add a new venue with missing details
  Given the User is logged in
  When the User tries to add a new venue without providing all the required details
  Then the system should display an error message and the new venue should not be added
  
  
  Scenario: Add a new venue with duplicate name
    Given the User is logged in and there exists a venue named "Existing Venue"
    When the User tries to add a new venue named "Existing Venue"
    Then the system should display an error message stating that the venue name "Existing Venue" already exists and the new venue "Existing Venue" should not be added
    
 Scenario: Add a new venue with special characters in the name
Given the User is logged in
When the User tries to add a new venue with special characters in the name
Then the system should display an error message stating that the venue name contains invalid characters and the new venue should not be added
    
 Scenario: Add a new venue with a long name
Given the User is logged in
When the User tries to add a new venue with a long name exceeding the character limit 
Then the system should display an error message stating that the venue name exceeds the character limit and the new venue should not be added