Feature: AddEvent

Scenario: Add Event successfully
Given that the User is logged in
And there is an Event with brideName "Bride1", groomName "ali",date "2024-5-23",time  "10:00 AM", numberOfGuests 150 , venue "ahlam" ,location"nablus"and phone  "0599689793"

Then the Event will be saved in the newEventsList  


Scenario: Add Event and no available  venue
Given that the User is logged in
And there is an Event with brideName "Bride1", groomName "Groom1",date "2024-05-20",time  "10:00 AM", numberOfGuests 100 , venue "Venue1" ,location"Location1"and phone  "Phone1"
And the venue is allocated 
Then that show an error message


Scenario: add Event large number of guets
Given that the User is logged in
And there is an Event with brideName "Bride2", groomName "Groom2",date "2024-06-15",time  "11:30 AM", numberOfGuests 150 , venue "Venue2" ,location"Location2"and phone  "Phone2"
And the numberOfGuests is larger
Then the event will not be saves and error message will appear