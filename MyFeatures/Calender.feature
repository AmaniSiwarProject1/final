
Feature: Calender

Scenario: Viewing Events None Exist
Given The calendar is newly initialized and contains no events.
When The user requests to view all events in the calendar.
Then The system should inform the user that there are no events to display.


Scenario: Viewing Events Successfully
Given a user has added events to the calendar successfully,
When the user requests to view all scheduled events,
Then the system displays all the added events.