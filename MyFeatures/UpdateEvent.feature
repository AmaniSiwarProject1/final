Feature: Update Event

Scenario: Event Not Found
   Given The user wants to update an event and The event does not exist in the events list
   When The user provides the new event details
   Then The system displays a message that the event was not found

Scenario: Update Event Details
   Given The user wants to update an event
   When The user provides new event details
   Then The system updates the event and The system confirms the event was updated successfully