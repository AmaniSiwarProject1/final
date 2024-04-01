Feature: AddEvent

Scenario: Add Event Successfully
  Given the User is logged in
  And there is no event with brideName "Bride1", groomName "Groom1", date "2024-05-20", time "10:00 AM", numberOfGuests "100", venue "Venue1", location "Location1", phone "123456789" , and price "2500"
  When the User adds a new event with brideName "Bride1", groomName "Groom1", date "2024-05-20", time "10:00 AM", numberOfGuests "100", venue "Venue1", location "Location1",  phone "123456789" , and price "2500"
  Then the new event should be added successfully
  
  
  Scenario: Venue is Already Booked
  Given the User is logged in
  And there is an event with brideName "Bride5", groomName "Groom5", date "2024-05-20", time "10:00 AM", numberOfGuests "100", venue "Venue1", location "Location1", and phone "987654321" ,and price "2500"
  When the User tries to add a new event with the same date, time, and venue
  Then the system should not allow adding the event and display a message about the venue being already booked
    Scenario: Adding an event with more guests than the venue capacity
  Given the User is logged in
  And there is an event with brideName "Bride1", groomName "Groom1", date "2024-05-20", time "10:00 AM", numberOfGuests "200", venue "Venue3", location "Location1", and phone "123456789", and price "2500"
  When the User tries to add a new event with brideName "Bride2", groomName "Groom2", date "2024-05-20", time "12:00 PM", numberOfGuests "250", venue "Venue3", location "Location2", and phone "987654321",and price "2500"
  Then the system should not allow adding the event and display a message about the venue capacity being exceeded
  
  
  Scenario: Adding an Event with Missing Bride's Name
Given the User is logged in and the User is trying to add a new event
When the User provides all event details except the bride's name
Then the system should not allow adding the event and display an error message about the missing bride's name

Scenario: Adding an Event with Invalid Phone Number
Given the User is logged in and the User is trying to add a new event
When the User provides an invalid phone number format for the event
Then the system should not allow adding the event and display an error message about the invalid phone number format

Scenario: Adding an Event with Missing Groom's Name
Given the User is logged in and the User is trying to add a new event
When the User provides all event details except the groom's name
Then the system should not allow adding the event and display an error message about the missing groom's name



Scenario: Adding an Event with Invalid Date Format
Given the User is logged in and the User is trying to add a new event
When the User provides an invalid date format for the event date (e.g., "20-May-2024")
Then the system should not allow adding the event and display an error message indicating that the date format is invalid