package Wedding.Planner;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Timer;
import java.util.TimerTask;
 
import java.time.LocalTime;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;


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
    public void AddnewVenue() {
    	Scanner scanner = new Scanner(System.in);

    	AddVenue venue = new AddVenue();

    	System.out.println("Enter Venue Name:");
    	String name = scanner.nextLine();
    	venue.setName(name);

    	System.out.println("Enter Venue Capacity:");
    	int capacity = 0;
    	try {
    	    capacity = Integer.parseInt(scanner.nextLine());
    	} catch (NumberFormatException e) {
    	    System.out.println("Invalid input for capacity. Please enter an integer.");
    	    scanner.close();
    	    return; // Exit the method
    	}
    	venue.setCapacity(capacity);

    	System.out.println("Enter Venue Amenities:");
    	String amenities = scanner.nextLine();
    	venue.setAmenities(amenities);

    	System.out.println("Enter Venue Price:");
    	int price = 0;
    	try {
    	    price = Integer.parseInt(scanner.nextLine());
    	} catch (NumberFormatException e) {
    	    System.out.println("Invalid input for price. Please enter an integer.");
    	    scanner.close();
    	    return; // Exit the method
    	}
    	venue.setPrice(price);

    	System.out.println("\nVenue Details:");
    	System.out.println(venue);
    	System.out.println("The Venue Added Successfully");

    	scanner.close();

    }
//////////////////////////اارخص مكان بالعالم كله جديد
    class Calendar {
        List<Event> events = new ArrayList<>();

        public void addEvent(Event event) {
            events.add(event);
        }

        public void printEvents() {
            for (Event event : events) {
                System.out.println("Event: " + event.title);
                System.out.println("Date/Time: " + event.dateTime);
                System.out.println("Description: " + event.description);
                System.out.println();
            }
        }
        }
    class Event {
        LocalDateTime dateTime;
        String title;
        String description;

        public Event(LocalDateTime dateTime, String title, String description) {
            this.dateTime = dateTime;
            this.title = title;
            this.description = description;
        }

        // Getters and setters (omitted for brevity)
    }

    public void Calander1() {
Calendar weddingCalendar = new Calendar();
        
        // Adding some events
        weddingCalendar.addEvent(new Event(LocalDateTime.of(2024, 5, 20, 15, 30), "Cake Tasting", "Tasting different cakes to select the perfect one for the wedding."));
        weddingCalendar.addEvent(new Event(LocalDateTime.of(2024, 6, 10, 10, 0), "Dress Fitting", "Final fitting for the wedding dress."));

        // Printing the events
        weddingCalendar.printEvents();
    }
    public int getEventsCount() {
        return events.size();
    }

public void  calander2() {
    WeddingPlanner planner = new WeddingPlanner();

    List<AddEvent> newEventsList = new ArrayList<>();
    newEventsList.add(new AddEvent("Bride1", "Groom1", "2024-05-20", "10:00 AM", 100, "Venue1", "Location1", "Phone1","2500"));
    newEventsList.add(new AddEvent("Bride2", "Groom2", "2024-06-15", "11:30 AM", 150, "Venue2", "Location2", "Phone2","2500"));
    newEventsList.add(new AddEvent("Bride3", "Groom3", "2024-07-10", "02:00 PM", 200, "Venue3", "Location3", "Phone3","4000"));

    for (AddEvent addEvent : newEventsList) {
        Event1 event = new Event1(addEvent.getBrideName() + " and " + addEvent.getGroomName() + "'s Wedding", LocalDate.parse(addEvent.getDate()));

        // Adding Tasks to the Event
        Task bookVenueTask = new Task("Book venue at " + addEvent.getVenue(), LocalDate.parse(addEvent.getDate()));
        Task hireCatererTask = new Task("Hire caterer for the event", LocalDate.parse(addEvent.getDate()));
        Task sendInvitationsTask = new Task("Send invitations to guests", LocalDate.parse(addEvent.getDate()));

        event.addTask(bookVenueTask);
        event.addTask(hireCatererTask);
        event.addTask(sendInvitationsTask);

        planner.addEvent(event);
    }

    // Displaying all events and tasks
    planner.displayAllEvents();

    // Setting reminders for tasks
    Timer timer = new Timer();
    for (Event1 event : planner.getEvents()) {
        for (Task task : event.getTasks()) {
            long delay = ChronoUnit.MILLIS.between(LocalDateTime.now(), LocalDateTime.of(task.getDueDate(), LocalTime.of(0, 0)));
            if (delay > 0) {  // Setting reminders only for future tasks
                final String eventName = event.toString();
                final String taskDescription = task.getDescription();
                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        System.out.println("Reminder for " + eventName + ": " + taskDescription);
                    }
                }, delay);
            }
        }
    }
  
   



}
public boolean hasEvent(String event) {
    return events.contains(event);
}

public void  calanderSuperProvider() {
    WeddingPlanner planner = new WeddingPlanner();
    Scanner scanner = new Scanner(System.in);

    List<AddEvent> newEventsList = new ArrayList<>();
    newEventsList.add(new AddEvent("Bride1", "Groom1", "2024-05-20", "10:00 AM", 100, "Venue1", "Location1", "Phone1","2500"));
    newEventsList.add(new AddEvent("Bride2", "Groom2", "2024-06-15", "11:30 AM", 150, "Venue2", "Location2", "Phone2","2500"));

    for (AddEvent addEvent : newEventsList) {
        Event1 event = new Event1(addEvent.getBrideName() + " and " + addEvent.getGroomName() + "'s Wedding", LocalDate.parse(addEvent.getDate()));

        // Adding Tasks to the Event
        Task BookFlower  = new Task("Book Flower " + addEvent.getVenue(), LocalDate.parse(addEvent.getDate()));
        Task Providefood = new Task("Provide food", LocalDate.parse(addEvent.getDate()));


        event.addTask(BookFlower);
        event.addTask(Providefood );
     

        planner.addEvent(event);
    }

    // Displaying all events and tasks
    planner.displayAllEvents();

    // Setting reminders for tasks
    Timer timer = new Timer();
    for (Event1 event : planner.getEvents()) {
        for (Task task : event.getTasks()) {
            long delay = ChronoUnit.MILLIS.between(LocalDateTime.now(), LocalDateTime.of(task.getDueDate(), LocalTime.of(0, 0)));
            if (delay > 0) {  // Setting reminders only for future tasks
                final String eventName = event.toString();
                final String taskDescription = task.getDescription();
                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        System.out.println("Reminder for " + eventName + ": " + taskDescription);
                    }
                }, delay);
            }
        }
    }
  
   
    System.out.println("Would you like to mark a task as completed? (y/n)");
    String answer = scanner.nextLine();
    if (answer.equalsIgnoreCase("y")) {
        System.out.println("Enter the task number to mark as completed:");
        int taskNumber = scanner.nextInt();
        scanner.nextLine(); // Consume newline left by nextInt()

        if (taskNumber >= 1 && taskNumber <= planner.getEvents().size()) {
            Event1 selectedEvent = planner.getEvents().get(taskNumber - 1);
            System.out.println("Select the task to mark as completed:");
            List<Task> tasks = selectedEvent.getTasks();
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println((i + 1) + ". " + tasks.get(i).getDescription());
            }
            int selectedTask = scanner.nextInt();
            scanner.nextLine(); // Consume newline left by nextInt()

            if (selectedTask >= 1 && selectedTask <= tasks.size()) {
                Task taskToComplete = tasks.get(selectedTask - 1);
                taskToComplete.markCompleted();
                System.out.println("Task marked as completed: " + taskToComplete.getDescription());
            } else {
                System.out.println("Invalid task selection.");
            }
        } else {
            System.out.println("Invalid event selection.");
        }
    }

    scanner.close();
}

public String viewEventsMessage() {
    if (events.isEmpty()) {
        return "There are no events to display.";
    } else {

        return "There are events scheduled.";
    }
}

public class VenueEditor {
    private Scanner scanner;
    private List<EditVenue> venues;
    private String resultMessage;
  

    
    public String editVenue(String venueName, String newName, Integer newCapacity, String newAmenities, Integer newPrice) {
        for (EditVenue venue : venues) {
            if (venue.getName().equalsIgnoreCase(venueName)) {
                // Update venue details as per the provided arguments...
                return "Venue edited successfully";
            }
        }
        return "Venue '" + venueName + "' not found.";
    }
    public String getResultMessage() {
        return resultMessage;
    }
    public VenueEditor() {
        scanner = new Scanner(System.in);
        venues = new ArrayList<>();
        // Add some initial venues for testing
        venues.add(new EditVenue("Grand Hall", 500, "Catering, Sound System", 1500));
        venues.add(new EditVenue("Conference Center", 300, "Projector, WiFi", 1000));
        venues.add(new EditVenue("Garden Pavilion", 200, "Outdoor Space, Tables", 800));
    }

    public void editVenue(String venueName) {
        EditVenue venueToEdit = null;
        for (EditVenue venue : venues) {
            if (venue.getName().equalsIgnoreCase(venueName)) {
                venueToEdit = venue;
                break;
            }
        }

        if (venueToEdit == null) {
            resultMessage = "Venue '" + venueName + "' not found.";
            return;
        }

        System.out.println("Editing venue: " + venueToEdit.getName());
        System.out.println("Current Capacity: " + venueToEdit.getCapacity());
        System.out.println("Current Amenities: " + venueToEdit.getAmenities());
        System.out.println("Current Price: " + venueToEdit.getPrice());

        System.out.print("Enter new name (or press Enter to keep the current name): ");
        String newName = scanner.nextLine();

        System.out.print("Enter new capacity (or press Enter to keep the current capacity): ");
        String newCapacityStr = scanner.nextLine();
        int newCapacity = venueToEdit.getCapacity(); // Default to current value
        if (!newCapacityStr.isEmpty()) {
            try {
                newCapacity = Integer.parseInt(newCapacityStr);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input for capacity. Keeping the current value.");
            }
        }

        System.out.print("Enter new amenities (or press Enter to keep the current amenities): ");
        String newAmenities = scanner.nextLine();

        System.out.print("Enter new price (or press Enter to keep the current price): ");
        String newPriceStr = scanner.nextLine();
        int newPrice = venueToEdit.getPrice(); // Default to current value
        if (!newPriceStr.isEmpty()) {
            try {
                newPrice = Integer.parseInt(newPriceStr);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input for price. Keeping the current value.");
            }
        }

        if (!newName.isEmpty()) {
            venueToEdit.setName(newName);
        }
        venueToEdit.setCapacity(newCapacity);
        if (!newAmenities.isEmpty()) {
            venueToEdit.setAmenities(newAmenities);
        }
        venueToEdit.setPrice(newPrice);

        resultMessage = "Venue edited successfully:\n" + venueToEdit.toString();
        System.out.println("Updated Venue Details:");
        System.out.println(venueToEdit);
    }

   
}
private List<EditVenue> venues = new ArrayList<>();
public String editVenueDirectly(String venueName, String newName, int newCapacity, String newAmenities, int newPrice) {
    for (EditVenue venue : venues) {
        if (venue.getName().equalsIgnoreCase(venueName)) {
            // تحديث تفاصيل الأماكن
            venue.setName(newName);
            venue.setCapacity(newCapacity);
            venue.setAmenities(newAmenities);
            venue.setPrice(newPrice);
            return "Venue updated successfully";
        }
    }
    return "Venue '" + venueName + "' not found.";

////////////////////////////////////


}


private static List<DeleteVenue> venuesList = new ArrayList<>();
public static String deleteVenue(String venueName) {
    for (DeleteVenue venue : venuesList) {
        if (venue.getName().equalsIgnoreCase(venueName)) {
            venuesList.remove(venue);
            return "Venue '" + venueName + "' deleted successfully.";
        }
    }
    return "Venue '" + venueName + "' not found.";
}
public static String deleteVenue(List<DeleteVenue> venuesList) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Available Venues:");
    for (DeleteVenue venue : venuesList) {
        System.out.println("- " + venue.getName());
    }

    System.out.print("Enter the name of the venue you want to delete: ");
    String venueName = scanner.nextLine();

    for (DeleteVenue venue : venuesList) {
        if (venue.getName().equalsIgnoreCase(venueName)) {
            venuesList.remove(venue);
            return "Venue '" + venueName + "' deleted successfully.";
        }
    }
    return "Venue '" + venueName + "' not found.";
}
public void deleteVenue() {
	  List<DeleteVenue> venuesList = new ArrayList<>();
      venuesList.add(new DeleteVenue("Venue 1", 100, "Amenities 1", 500));
      venuesList.add(new DeleteVenue("Venue 2", 200, "Amenities 2", 1000));

      // Delete a venue by name
      String result = deleteVenue(venuesList);
      System.out.println(result);

      // Print remaining venues
      System.out.println("Remaining Venues:");
      for (DeleteVenue venue : venuesList) {
          System.out.println(venue);
      }
  }
public void Photo() {
	Scanner scanner = new Scanner(System.in);

    System.out.println("Welcome to the File Uploader");
    System.out.println("Please enter the path of the file you want to upload:");
    String filePath = scanner.nextLine();

    File file = new File(filePath);
    if (!file.exists() || !file.isFile()) {
        System.out.println("Invalid file path. Please provide a valid path to a file.");
        return;
    }

    try {
        // Destination folder where the file will be "uploaded"
        String destinationFolder = "uploaded_files/";

        // Create destination directory if it doesn't exist
        File destDir = new File(destinationFolder);
        if (!destDir.exists()) {
            destDir.mkdirs();
        }

        // Copy the file to the destination folder
        Files.copy(Paths.get(filePath), Paths.get(destinationFolder + file.getName()), StandardCopyOption.REPLACE_EXISTING);

        System.out.println("File uploaded successfully to: " + destinationFolder + file.getName());
    } catch (Exception e) {
        System.out.println("An error occurred during file upload: " + e.getMessage());
    } finally {
        scanner.close();
    }
}
}




