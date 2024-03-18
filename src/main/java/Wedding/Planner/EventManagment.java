package Wedding.Planner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class EventManagment {
    private String errorMessage;
    private Map<String, Integer> venueCapacities; 

    private List<AddEvent> events;
    private static Scanner input = new Scanner(System.in);
    
    public EventManagment() {
        events = new ArrayList<>();
        venueCapacities = new HashMap<>();
        initializeVenueCapacities();
    }
    private void initializeVenueCapacities() {
        venueCapacities.put("Venue1", 100);
        venueCapacities.put("Venue2", 150);
        venueCapacities.put("Venue3", 200);
    }
    public String getErrorMessage() {
        return errorMessage;
    }
    public void addEvent(AddEvent event) {
        if (checkEventsExist(event.getBrideName(), event.getGroomName(), event.getDate(), event.getTime(), event.getNumberOfGuests(), event.getVenue(), event.getLocation(), event.getPhone(),event.getPrice())) {
            System.out.println("Event already exists in the list.");
        } else {
            events.add(event);
            System.out.println("" );
        }
    }


    public boolean checkEventsExist(String brideName, String groomName, String date, String time, int numberOfGuests,
            String venue, String location, String phone,String price) {
        for (AddEvent existingEvent : events) {
            if (existingEvent.getBrideName() != null &&
                existingEvent.getGroomName() != null &&
                existingEvent.getDate() != null &&
                existingEvent.getTime() != null &&
                existingEvent.getVenue() != null &&
                existingEvent.getLocation() != null &&
                existingEvent.getPhone() != null &&
                existingEvent.getPrice() != null &&
                existingEvent.getBrideName().equals(brideName) &&
                existingEvent.getGroomName().equals(groomName) &&
                existingEvent.getDate().equals(date) &&
                existingEvent.getTime().equals(time) &&
                existingEvent.getNumberOfGuests() == numberOfGuests &&
                existingEvent.getVenue().equals(venue) &&
                existingEvent.getLocation().equals(location) &&
                existingEvent.getPhone().equals(phone) &&
                existingEvent.getPrice().equals(price)){
                return true; 
            }
        }
        return false; 
    }




    public void listAllEvents() {
        if (events.isEmpty()) {
            System.out.println("No events to display.");
        } else {
            System.out.println("List of Events:");
            for (int i = 0; i < events.size(); i++) {
                AddEvent event = events.get(i);
                System.out.println((i + 1) + ". " + event.getBrideName() + " and " + event.getGroomName() +
                        " - Date: " + event.getDate() + " - Time: " + event.getTime() + " - Number of Guests: " + event.getNumberOfGuests() +
                        " - Venue: " + event.getVenue() + " - Location: " + event.getLocation() + " - Phone: " + event.getPhone());
            }
        }
    }
    public void createWeddingEvent(String brideName, String groomName, String date, String time, int numberOfGuests, String venue, String location, String phone,String price) {
	    Map<String, Integer> venueCapacities = new HashMap<>();
	    venueCapacities.put("Venue1", 100);
	    venueCapacities.put("Venue2", 150);
	    venueCapacities.put("Venue3", 200);

	    for (AddEvent event : events) {
	        String eventVenue = event.getVenue();
	        if (eventVenue != null && eventVenue.equals(venue) && event.getDate().equals(date) && event.getTime().equals(time)) {
	            errorMessage = "Venue is already booked for this time and date.";
	            return;
	        }
	    }

	    if (venueCapacities.containsKey(venue) && numberOfGuests > venueCapacities.get(venue)) {
	        errorMessage = "Venue capacity exceeded for this event";
	        return;
	    }

	    addEvent(new AddEvent(brideName, groomName, date, time, numberOfGuests, venue, location, phone,price));
	}




	


    public void addEvent() {
        System.out.print("Enter Bride Name: ");
        String brideName = input.nextLine();
        System.out.print("Enter Groom Name: ");
        String groomName = input.nextLine();
        System.out.print("Enter Event Date: ");
        String eventDate = input.nextLine();
        System.out.print("Enter Event time: ");
        String eventTime = input.nextLine();
        System.out.print("Enter Number of Guests: ");
        int numberOfGuests;
        while (true) {
            try {
                numberOfGuests = Integer.parseInt(input.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            }
        }
        System.out.print("Enter Venue Name: ");
        String venueName = input.nextLine();
        System.out.print("Enter Event Location: ");
        String eventLocation = input.nextLine();
        System.out.print("Enter Your phone for contact: ");
        String phone = input.nextLine();
        System.out.print("Enter the price: ");
        String price = input.nextLine();

        addEvent(new AddEvent(brideName, groomName, eventDate, eventTime, numberOfGuests, venueName, eventLocation, phone,price));
    }

    public void addMultipleEvents(List<AddEvent> newEvents) {
        for (AddEvent event : newEvents) {
            addEvent(event);
        }
        System.out.println("Multiple events added successfully.");
    }

    public void displayAllEvents() {
        if (events.isEmpty()) {
            System.out.println("No events to display.");
        } else {
            System.out.println("List of Events:");
            for (int i = 0; i < events.size(); i++) {
                AddEvent event = events.get(i);
                System.out.println("Event " + (i + 1) + ":");
                System.out.println("Bride Name: " + event.getBrideName());
                System.out.println("Groom Name: " + event.getGroomName());
                System.out.println("Date: " + event.getDate());
                System.out.println("Time: " + event.getTime());
                System.out.println("Number of Guests: " + event.getNumberOfGuests());
                System.out.println("Venue: " + event.getVenue());
                System.out.println("Location: " + event.getLocation());
                System.out.println("Phone: " + event.getPhone());
                System.out.println("Price: " + event.getPrice());

                System.out.println();
            }
        }
    }
    public List<AddEvent> getEvents() {
        return events;
    }

   
    public void updateEvent(List<AddEvent> eventsListt) {
        Scanner scanner = new Scanner(System.in); // تعريف متغير scanner

    	   System.out.println("Enter the date of the event you want to update (yyyy-MM-dd): ");
           String eventDate = scanner.nextLine();
           System.out.println("Enter the time of the event you want to update (hh:mm a): ");
           String eventTime = scanner.nextLine();

           AddEvent selectedEvent = null;
           for (AddEvent event : getEvents()) {
               if (event.getDate().equals(eventDate) && event.getTime().equals(eventTime)) {
                   selectedEvent = event;
                   break;
               }
           }

           if (selectedEvent != null) {
               System.out.println("Current Event Information:");
               System.out.println("Bride Name: " + selectedEvent.getBrideName());
               System.out.println("Groom Name: " + selectedEvent.getGroomName());
               System.out.println("Date: " + selectedEvent.getDate());
               System.out.println("Time: " + selectedEvent.getTime());
               System.out.println("Number of Guests: " + selectedEvent.getNumberOfGuests());
               System.out.println("Venue: " + selectedEvent.getVenue());
               System.out.println("Location: " + selectedEvent.getLocation());
               System.out.println("Phone: " + selectedEvent.getPhone());
               System.out.println("Price: " + selectedEvent.getPrice());


               System.out.println("Enter New Bride Name (or press Enter to keep the same): ");
               String brideName = scanner.nextLine();
               if (!brideName.isEmpty()) {
                   selectedEvent.setBrideName(brideName);
               }

               System.out.println("Enter New Groom Name (or press Enter to keep the same): ");
               String groomName = scanner.nextLine();
               if (!groomName.isEmpty()) {
                   selectedEvent.setGroomName(groomName);
               }

               System.out.println("Enter New Date (or press Enter to keep the same): ");
               String date = scanner.nextLine();
               if (!date.isEmpty()) {
                   selectedEvent.setDate(date);
               }

               System.out.println("Enter New Time (or press Enter to keep the same): ");
               String time = scanner.nextLine();
               if (!time.isEmpty()) {
                   selectedEvent.setTime(time);
               }

               
               System.out.println("Enter New Number of Guests (or press Enter to keep the same): ");
               String numberOfGuestsStr = scanner.nextLine();
               if (!numberOfGuestsStr.isEmpty()) {
                   int numberOfGuests = Integer.parseInt(numberOfGuestsStr);
                   selectedEvent.setNumberOfGuests(numberOfGuests);
               }

               System.out.println("Enter New Venue Name (or press Enter to keep the same): ");
               String venue = scanner.nextLine();
               if (!venue.isEmpty()) {
                   selectedEvent.setVenue(venue);
               }

               System.out.println("Enter New Location (or press Enter to keep the same): ");
               String location = scanner.nextLine();
               if (!location.isEmpty()) {
                   selectedEvent.setLocation(location);
               }

               System.out.println("Enter New Phone Number (or press Enter to keep the same): ");
               String phone = scanner.nextLine();
               if (!phone.isEmpty()) {
                   selectedEvent.setPhone(phone);
               }
               System.out.println("Enter New price Number (or press Enter to keep the same): ");
               String price = scanner.nextLine();
               if (!phone.isEmpty()) {
                   selectedEvent.setPhone(price);
               }
               System.out.println("Updated Event Information:");
               System.out.println("Bride Name: " + selectedEvent.getBrideName());
               System.out.println("Groom Name: " + selectedEvent.getGroomName());
               System.out.println("Date: " + selectedEvent.getDate());
               System.out.println("Time: " + selectedEvent.getTime());
               System.out.println("Number of Guests: " + selectedEvent.getNumberOfGuests());
               System.out.println("Venue: " + selectedEvent.getVenue());
               System.out.println("Location: " + selectedEvent.getLocation());
               System.out.println("Phone: " + selectedEvent.getPhone());
               
               System.out.println("Phone: " + selectedEvent.getPrice());

               System.out.println("Event updated successfully.");
           } else {
               System.out.println("Event with date " + eventDate + " and time " + eventTime + " not found.");
           }
    }
    public void deleteEvent(String eventDate, String eventTime) {

    	  

        AddEvent selectedEvent = null;
        for (AddEvent event : events) {
            if (event.getDate().equals(eventDate) && event.getTime().equals(eventTime)) {
                selectedEvent = event;
                break;
            }
        }

        if (selectedEvent != null) {
            System.out.println("Are you sure you want to delete the following event?");
            System.out.println("Bride Name: " + selectedEvent.getBrideName());
            System.out.println("Groom Name: " + selectedEvent.getGroomName());
            System.out.println("Date: " + selectedEvent.getDate());
            System.out.println("Time: " + selectedEvent.getTime());
            System.out.println("Number of Guests: " + selectedEvent.getNumberOfGuests());
            System.out.println("Venue: " + selectedEvent.getVenue());
            System.out.println("Location: " + selectedEvent.getLocation());
            System.out.println("Phone: " + selectedEvent.getPhone());
            System.out.println("Price: " + selectedEvent.getPrice());

            System.out.println("Enter 'yes' to confirm deletion or any other key to cancel: ");
            Scanner scanner1 = new Scanner(System.in);
			String confirmation = scanner1.nextLine();

            if (confirmation.equalsIgnoreCase("yes")) {
                events.remove(selectedEvent);
                System.out.println("Event deleted successfully.");
            } else {
                System.out.println("Deletion canceled.");
            }
        } else {
            System.out.println("Event with date " + eventDate + " and time " + eventTime + " not found.");
        }
    }
    public void Venueadd(){
  	  List<Venue> venues = new ArrayList<>();
        venues.add(new Venue("Garden",500.0, "2024-04-01","15:00"));
        venues.add(new Venue("Gold Venue",  700.0, "2024-04-01","2:00"));
        venues.add(new Venue("Sunset Venue",  1000.0, "2024-04-01","5:30"));
        venues.add(new Venue("Light Venue",  800.0, "2024-04-01","10:20"));

        // Create a VenueFinder object
        VenueFinder venueFinder = new VenueFinder();

        // Get user input for max price and wedding date
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the maximum price you can pay: ");
        double maxPrice = scanner.nextDouble();

        System.out.print("Enter the wedding date (YYYY-MM-DD): ");
        String weddingDate = "";
      

        // Validate the wedding date format
        boolean validDate = false;
        while (!validDate) {
            weddingDate = scanner.next();
            if (isValidDateFormat(weddingDate)) {
                validDate = true;
            } else {
                System.out.print("Invalid date format. Please enter the date in YYYY-MM-DD format: ");
            }
        }
        System.out.print("Enter the wedding time (HH:mm): ");
        String weddingTime = "";
        boolean validTime = false;
        while (!validTime) {
            weddingTime = scanner.next();
            if (isValidTimeFormat(weddingTime)) {
                validTime = true;
            } else {
                System.out.print("Invalid time format. Please enter the time in HH:mm format: ");
            }
        }

        // Find matching venues
        List<Venue> matchingVenues = venueFinder.findMatchingVenues(venues, maxPrice, weddingDate,weddingTime);

        // Display matching venues
        if (matchingVenues.isEmpty()) {
            System.out.println("No venues found matching the criteria.");
        } else {
            System.out.println("Matching venues:");
            for (int i = 0; i < matchingVenues.size(); i++) {
                Venue venue = matchingVenues.get(i);
                System.out.println((i + 1) + ". " + venue.getName() + " - Price: $" + venue.getPrice());
            }

            System.out.print("Choose a venue (enter the number): ");
            int choice = scanner.nextInt();

            if (choice >= 1 && choice <= matchingVenues.size()) {
                Venue selectedVenue = matchingVenues.get(choice - 1);

                System.out.println("Selected Venue: " + selectedVenue.getName());
                System.out.println("Price: $" + selectedVenue.getPrice());
                System.out.println("Wedding Date: " + selectedVenue.getAvailableDate());
                System.out.println("Wedding Time: " + selectedVenue.getAvailablehour());

                System.out.print("Confirm booking? (yes/no): ");
                String confirm = scanner.next();

                if (confirm.equalsIgnoreCase("yes")) {
                    System.out.print("Enter your name: ");
                    String name = scanner.next();

                    System.out.print("Enter the bride's name: ");
                    String brideName = scanner.next();

                    // Call addEvent function to finalize booking
                    addEvent();
                    System.out.println("Booking confirmed! Event added successfully.");
                } else {
                    System.out.println("Booking canceled.");
                }
            } else {
                System.out.println("Invalid choice.");
            }
        }


        scanner.close();
    
    }
  private static boolean isValidDateFormat(String date) {
      String regex = "\\d{4}-\\d{2}-\\d{2}";
      return date.matches(regex);
  }
  private static boolean isValidTimeFormat(String time) {
      String regex = "\\d{2}:\\d{2}";
      return time.matches(regex);
  }
    
}