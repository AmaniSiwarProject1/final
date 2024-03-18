Feature: Match Venue for Events

  Scenario: Event Not Found
 Given available venues for events and the user wants to find a matching venue for an event.
When the user provides the maximum price and the event date and no matching venue is found.
Then the system displays a message that no venues are available.
