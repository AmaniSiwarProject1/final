Feature: Add Venue Successfully


  Scenario: Add a new venue
    Given the User is logged in and there is no venue named "Venue1"
    When the User adds a new venue named "Venue1"
    Then the new venue should be added successfully
    
Scenario: Add a new venue with missing details
  Given the User is logged in
  When the User tries to add a new venue without providing all the required details
  Then the system should display an error message and the new venue should not be added