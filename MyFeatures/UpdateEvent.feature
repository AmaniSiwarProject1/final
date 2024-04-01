Feature: Update Event

Scenario: Event Not Found
   Given The user wants to update an event and The event does not exist in the events list
   When The user provides the new event details
   Then The system displays a message that the event was not found

Scenario: Update Event Details
   Given The user wants to update an event
   When The user provides new event details
   Then The system updates the event and The system confirms the event was updated successfully
   
   
Scenario: Updating Only Bride's Name
Given an event with the following original details
When the user updates the bride's 
Then the system should reflect the changes with the updated event details


Scenario: Updating Event Venue and Location
Given an event with original details
When the user updates the event venue and the location 
Then the system should reflect the changes with the updated event details

Scenario: Updating Number of Guests
Given The user wants to update the number of guests for an event and An event with a specific number of guests exists in the events list.
When The user provides a new number of guests for the event.
Then The system updates the number of guests for the event and The system confirms that the number of guests was updated successfully.

Scenario: Updating Event Date and Time
Given The user wants to update the date and time of an event and An event with a specific date and time exists in the events list.
When The user provides a new date and time for the event.
Then The system updates the date and time for the event and The system confirms that the date and time were updated successfully.

Scenario: Updating Event Price
Given The user wants to update the price of an event and An event with a specific price exists in the events list.
When The user provides a new price for the event.
Then The system updates the price for the event and The system confirms that the price was updated successfully.


Scenario: Updating Groom's Name
Given an event with the  original details
When the user updates the groom's name to "NewGroom"
Then the system should reflect the changes with the updated event details