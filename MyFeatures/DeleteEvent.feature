Feature: Delete Event

 Scenario: Delete Non-Existing Event
    Given  The user entered information about the event
    When The user attempts to delete an event
    Then The system notifies the user that there are no events to delete
    

Scenario: Event Deleted Successfully
   Given The user wants to delete an event
    When The user provides the event details
    Then The system deletes the event
    
Scenario: Cancel Deletion
    Given There exists an event in the events list
    When The user attempts to delete the event
    Then The system prompts the user to confirm deletion and The user cancels the deletion and The event remains in the events list
    
    
 Scenario: Delete All Events
    Given There are multiple events in the events list and The user wants to delete all events
    When The user confirms the deletion action
    Then The system deletes all events and The system notifies the user that all events have been successfully deleted