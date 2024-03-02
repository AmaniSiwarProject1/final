Feature: AddEvent

Scenario: Add Event Successfully
  Given the User is logged in
  And there is no event with brideName "Bride1", groomName "Groom1", date "2024-05-20", time "10:00 AM", numberOfGuests "100", venue "Venue1", location "Location1", and phone "123456789"
  When the User adds a new event with brideName "Bride1", groomName "Groom1", date "2024-05-20", time "10:00 AM", numberOfGuests "100", venue "Venue1", location "Location1", and phone "123456789"
  Then the new event should be added successfully

Scenario: Venue is Already Booked
  Given the User is logged in
  And there is an event with brideName "Bride5", groomName "Groom5", date "2024-05-20", time "10:00 AM", numberOfGuests "100", venue "Venue1", location "Location1", and phone "987654321"
  When the User tries to add a new event with the same date, time, and venue
  Then the system should not allow adding the event and display a message about the venue being already booked
   
   Scenario: Adding an event with more guests than the venue capacity
  Given the User is logged in
  And there is an event with brideName "Bride1", groomName "Groom1", date "2024-05-20", time "10:00 AM", numberOfGuests "200", venue "Venue3", location "Location1", and phone "123456789"
  When the User tries to add a new event with brideName "Bride2", groomName "Groom2", date "2024-05-20", time "12:00 PM", numberOfGuests "250", venue "Venue3", location "Location2", and phone "987654321"
  Then the system should not allow adding the event and display a message about the venue capacity being exceeded