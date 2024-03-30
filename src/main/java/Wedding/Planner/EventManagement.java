package Wedding.Planner;
import java.util.logging.Logger;

import io.cucumber.plugin.event.EventHandler;

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


public class EventManagement {
    private String errorMessage;
    private Map<String, Integer> venueCapacities; 

    private List<AddEvent> events;
    private static Scanner input = new Scanner(System.in);
    private static final Logger logger = Logger.getLogger(EventHandler.class.getName());

    public EventManagement() {
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
        	logger.info("Event already exists in the list.");
        } else {
            events.add(event);
            logger.info("" );
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
        	logger.info("No events to display.");
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
    	logger.info("Enter Bride Name: ");
        String brideName = input.nextLine();
        logger.info("Enter Groom Name: ");
        String groomName = input.nextLine();
        logger.info("Enter Event Date: ");
        String eventDate = input.nextLine();
        logger.info("Enter Event time: ");
        String eventTime = input.nextLine();
        logger.info("Enter Number of Guests: ");
        int numberOfGuests;
        while (true) {
            try {
                numberOfGuests = Integer.parseInt(input.nextLine());
                break;
            } catch (NumberFormatException e) {
            	logger.info("Invalid input. Please enter a valid number.");
            }
        }
        logger.info("Enter Venue Name: ");
        String venueName = input.nextLine();
        logger.info("Enter Event Location: ");
        String eventLocation = input.nextLine();
        logger.info("Enter Your phone for contact: ");
        String phone = input.nextLine();
        logger.info("Enter the price: ");
        String price = input.nextLine();

        addEvent(new AddEvent(brideName, groomName, eventDate, eventTime, numberOfGuests, venueName, eventLocation, phone,price));
    }

    public void addMultipleEvents(List<AddEvent> newEvents) {
        for (AddEvent event : newEvents) {
            addEvent(event);
        }
        logger.info("Multiple events added successfully.");
    }

    public void displayAllEvents() {
        if (events.isEmpty()) {
        	logger.info("No events to display.");
        } else {
            System.out.println("List of Events:");
            for (int i = 0; i < events.size(); i++) {
                AddEvent event = events.get(i);
                logger.info("Event " + (i + 1) + ":");
                logger.info("Bride Name: " + event.getBrideName());
                logger.info("Groom Name: " + event.getGroomName());
                logger.info("Date: " + event.getDate());
                logger.info("Time: " + event.getTime());
                logger.info("Number of Guests: " + event.getNumberOfGuests());
                logger.info("Venue: " + event.getVenue());
                logger.info("Location: " + event.getLocation());
                logger.info("Phone: " + event.getPhone());
                logger.info("Price: " + event.getPrice());

            }
        }
    }
    public List<AddEvent> getEvents() {
        return events;
    }

   
    public void updateEvent(List<AddEvent> eventsListt) {
        Scanner scanner = new Scanner(System.in);

        logger.info("Enter the date of the event you want to update (yyyy-MM-dd): ");
           String eventDate = scanner.nextLine();
           logger.info("Enter the time of the event you want to update (hh:mm a): ");
           String eventTime = scanner.nextLine();

           AddEvent selectedEvent = null;
           for (AddEvent event : getEvents()) {
               if (event.getDate().equals(eventDate) && event.getTime().equals(eventTime)) {
                   selectedEvent = event;
                   break;
               }
           }

           if (selectedEvent != null) {
        	   logger.info("Current Event Information:");
        	   logger.info("Bride Name: " + selectedEvent.getBrideName());
        	   logger.info("Groom Name: " + selectedEvent.getGroomName());
        	   logger.info("Date: " + selectedEvent.getDate());
        	   logger.info("Time: " + selectedEvent.getTime());
        	   logger.info("Number of Guests: " + selectedEvent.getNumberOfGuests());
        	   logger.info("Venue: " + selectedEvent.getVenue());
        	   logger.info("Location: " + selectedEvent.getLocation());
        	   logger.info("Phone: " + selectedEvent.getPhone());
        	   logger.info("Price: " + selectedEvent.getPrice());


        	   logger.info("Enter New Bride Name (or press Enter to keep the same): ");
               String brideName = scanner.nextLine();
               if (!brideName.isEmpty()) {
                   selectedEvent.setBrideName(brideName);
               }

               logger.info("Enter New Groom Name (or press Enter to keep the same): ");
               String groomName = scanner.nextLine();
               if (!groomName.isEmpty()) {
                   selectedEvent.setGroomName(groomName);
               }

               logger.info("Enter New Date (or press Enter to keep the same): ");
               String date = scanner.nextLine();
               if (!date.isEmpty()) {
                   selectedEvent.setDate(date);
               }

               logger.info("Enter New Time (or press Enter to keep the same): ");
               String time = scanner.nextLine();
               if (!time.isEmpty()) {
                   selectedEvent.setTime(time);
               }

               
               logger.info("Enter New Number of Guests (or press Enter to keep the same): ");
               String numberOfGuestsStr = scanner.nextLine();
               if (!numberOfGuestsStr.isEmpty()) {
                   int numberOfGuests = Integer.parseInt(numberOfGuestsStr);
                   selectedEvent.setNumberOfGuests(numberOfGuests);
               }

               logger.info("Enter New Venue Name (or press Enter to keep the same): ");
               String venue = scanner.nextLine();
               if (!venue.isEmpty()) {
                   selectedEvent.setVenue(venue);
               }

               logger.info("Enter New Location (or press Enter to keep the same): ");
               String location = scanner.nextLine();
               if (!location.isEmpty()) {
                   selectedEvent.setLocation(location);
               }

               logger.info("Enter New Phone Number (or press Enter to keep the same): ");
               String phone = scanner.nextLine();
               if (!phone.isEmpty()) {
                   selectedEvent.setPhone(phone);
               }
               logger.info("Enter New price Number (or press Enter to keep the same): ");
               String price = scanner.nextLine();
               if (!phone.isEmpty()) {
                   selectedEvent.setPhone(price);
               }
               logger.info("Updated Event Information:");
               logger.info("Bride Name: " + selectedEvent.getBrideName());
               logger.info("Groom Name: " + selectedEvent.getGroomName());
               logger.info("Date: " + selectedEvent.getDate());
               logger.info("Time: " + selectedEvent.getTime());
               logger.info("Number of Guests: " + selectedEvent.getNumberOfGuests());
               logger.info("Venue: " + selectedEvent.getVenue());
               logger.info("Location: " + selectedEvent.getLocation());
               logger.info("Phone: " + selectedEvent.getPhone());
               
               logger.info("Phone: " + selectedEvent.getPrice());

               logger.info("Event updated successfully.");
           } else {
        	   logger.info("Event with date " + eventDate + " and time " + eventTime + " not found.");
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
        	logger.info("Are you sure you want to delete the following event?");
        	logger.info("Bride Name: " + selectedEvent.getBrideName());
        	logger.info("Groom Name: " + selectedEvent.getGroomName());
        	logger.info("Date: " + selectedEvent.getDate());
        	logger.info("Time: " + selectedEvent.getTime());
        	logger.info("Number of Guests: " + selectedEvent.getNumberOfGuests());
        	logger.info("Venue: " + selectedEvent.getVenue());
        	logger.info("Location: " + selectedEvent.getLocation());
        	logger.info("Phone: " + selectedEvent.getPhone());
        	logger.info("Price: " + selectedEvent.getPrice());

        	logger.info("Enter 'yes' to confirm deletion or any other key to cancel: ");
            Scanner scanner1 = new Scanner(System.in);
			String confirmation = scanner1.nextLine();

            if (confirmation.equalsIgnoreCase("yes")) {
                events.remove(selectedEvent);
                logger.info("Event deleted successfully.");
            } else {
            	logger.info("Deletion canceled.");
            }
        } else {
        	logger.info("Event with date " + eventDate + " and time " + eventTime + " not found.");
        }
    }
    public void Venueadd(){
  	  List<Venue> venues = new ArrayList<>();
        venues.add(new Venue("Garden",500.0, "2024-04-01","15:00"));
        venues.add(new Venue("Gold Venue",  700.0, "2024-04-01","2:00"));
        venues.add(new Venue("Sunset Venue",  1000.0, "2024-04-01","5:30"));
        venues.add(new Venue("Light Venue",  800.0, "2024-04-01","10:20"));

        VenueFinder venueFinder = new VenueFinder();

        Scanner scanner = new Scanner(System.in);
        logger.info("Enter the maximum price you can pay: ");
        double maxPrice = scanner.nextDouble();

        logger.info("Enter the wedding date (YYYY-MM-DD): ");
        String weddingDate = "";
      

        boolean validDate = false;
        while (!validDate) {
            weddingDate = scanner.next();
            if (isValidDateFormat(weddingDate)) {
                validDate = true;
            } else {
            	logger.info("Invalid date format. Please enter the date in YYYY-MM-DD format: ");
            }
        }
        logger.info("Enter the wedding time (HH:mm): ");
        String weddingTime = "";
        boolean validTime = false;
        while (!validTime) {
            weddingTime = scanner.next();
            if (isValidTimeFormat(weddingTime)) {
                validTime = true;
            } else {
            	logger.info("Invalid time format. Please enter the time in HH:mm format: ");
            }
        }

        List<Venue> matchingVenues = venueFinder.findMatchingVenues(venues, maxPrice, weddingDate,weddingTime);

        if (matchingVenues.isEmpty()) {
        	logger.info("No venues found matching the criteria.");
        } else {
        	logger.info("Matching venues:");
            for (int i = 0; i < matchingVenues.size(); i++) {
                Venue venue = matchingVenues.get(i);
                logger.info((i + 1) + ". " + venue.getName() + " - Price: $" + venue.getPrice());
            }

            logger.info("Choose a venue (enter the number): ");
            int choice = scanner.nextInt();

            if (choice >= 1 && choice <= matchingVenues.size()) {
                Venue selectedVenue = matchingVenues.get(choice - 1);

                logger.info("Selected Venue: " + selectedVenue.getName());
                logger.info("Price: $" + selectedVenue.getPrice());
                logger.info("Wedding Date: " + selectedVenue.getAvailableDate());
                logger.info("Wedding Time: " + selectedVenue.getAvailablehour());

                logger.info("Confirm booking? (yes/no): ");
                String confirm = scanner.next();

                if (confirm.equalsIgnoreCase("yes")) {
                	logger.info("Enter your name: ");
                    String name = scanner.next();

                    logger.info("Enter the bride's name: ");
                    String brideName = scanner.next();

                    addEvent();
                    logger.info("Booking confirmed! Event added successfully.");
                } else {
                	logger.info("Booking canceled.");
                }
            } else {
            	logger.info("Invalid choice.");
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

    	logger.info("Enter Venue Name:");
    	String name = scanner.nextLine();
    	venue.setName(name);

    	logger.info("Enter Venue Capacity:");
    	int capacity = 0;
    	try {
    	    capacity = Integer.parseInt(scanner.nextLine());
    	} catch (NumberFormatException e) {
    		logger.info("Invalid input for capacity. Please enter an integer.");
    	    scanner.close();
    	    return; 
    	}
    	venue.setCapacity(capacity);

    	logger.info("Enter Venue Amenities:");
    	String amenities = scanner.nextLine();
    	venue.setAmenities(amenities);

    	logger.info("Enter Venue Price:");
    	int price = 0;
    	try {
    	    price = Integer.parseInt(scanner.nextLine());
    	} catch (NumberFormatException e) {
    		logger.info("Invalid input for price. Please enter an integer.");
    	    scanner.close();
    	    return; 
    	}
    	venue.setPrice(price);

    	logger.info("\nVenue Details:");
    	System.out.println(venue);
    	logger.info("The Venue Added Successfully");

    	scanner.close();

    }
    class Calendar {
        List<Event> events = new ArrayList<>();

        public void addEvent(Event event) {
            events.add(event);
        }

        public void printEvents() {
            for (Event event : events) {
            	logger.info("Event: " + event.title);
            	logger.info("Date/Time: " + event.dateTime);
            	logger.info("Description: " + event.description);
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

    }

    public void Calander1() {
Calendar weddingCalendar = new Calendar();
        
        weddingCalendar.addEvent(new Event(LocalDateTime.of(2024, 5, 20, 15, 30), "Cake Tasting", "Tasting different cakes to select the perfect one for the wedding."));
        weddingCalendar.addEvent(new Event(LocalDateTime.of(2024, 6, 10, 10, 0), "Dress Fitting", "Final fitting for the wedding dress."));

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

        Task bookVenueTask = new Task("Book venue at " + addEvent.getVenue(), LocalDate.parse(addEvent.getDate()));
        Task hireCatererTask = new Task("Hire caterer for the event", LocalDate.parse(addEvent.getDate()));
        Task sendInvitationsTask = new Task("Send invitations to guests", LocalDate.parse(addEvent.getDate()));

        event.addTask(bookVenueTask);
        event.addTask(hireCatererTask);
        event.addTask(sendInvitationsTask);

        planner.addEvent(event);
    }

    planner.displayAllEvents();

    Timer timer = new Timer();
    for (Event1 event : planner.getEvents()) {
        for (Task task : event.getTasks()) {
            long delay = ChronoUnit.MILLIS.between(LocalDateTime.now(), LocalDateTime.of(task.getDueDate(), LocalTime.of(0, 0)));
            if (delay > 0) {  
                final String eventName = event.toString();
                final String taskDescription = task.getDescription();
                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                    	logger.info("Reminder for " + eventName + ": " + taskDescription);
                    }
                }, delay);
            }
        }
    }
  
   



}

public void  calanderSuperProvider() {
    WeddingPlanner planner = new WeddingPlanner();
    Scanner scanner = new Scanner(System.in);

    List<AddEvent> newEventsList = new ArrayList<>();
    newEventsList.add(new AddEvent("Bride1", "Groom1", "2024-05-20", "10:00 AM", 100, "Venue1", "Location1", "Phone1","2500"));
    newEventsList.add(new AddEvent("Bride2", "Groom2", "2024-06-15", "11:30 AM", 150, "Venue2", "Location2", "Phone2","2500"));

    for (AddEvent addEvent : newEventsList) {
        Event1 event = new Event1(addEvent.getBrideName() + " and " + addEvent.getGroomName() + "'s Wedding", LocalDate.parse(addEvent.getDate()));

        Task BookFlower  = new Task("Book Flower " + addEvent.getVenue(), LocalDate.parse(addEvent.getDate()));
        Task Providefood = new Task("Provide food", LocalDate.parse(addEvent.getDate()));


        event.addTask(BookFlower);
        event.addTask(Providefood );
     

        planner.addEvent(event);
    }

    planner.displayAllEvents();

    Timer timer = new Timer();
    for (Event1 event : planner.getEvents()) {
        for (Task task : event.getTasks()) {
            long delay = ChronoUnit.MILLIS.between(LocalDateTime.now(), LocalDateTime.of(task.getDueDate(), LocalTime.of(0, 0)));
            if (delay > 0) {  
                final String eventName = event.toString();
                final String taskDescription = task.getDescription();
                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                    	logger.info("Reminder for " + eventName + ": " + taskDescription);
                    }
                }, delay);
            }
        }
    }
  
   
    logger.info("Would you like to mark a task as completed? (y/n)");
    String answer = scanner.nextLine();
    if (answer.equalsIgnoreCase("y")) {
    	logger.info("Enter the task number to mark as completed:");
        int taskNumber = scanner.nextInt();
        scanner.nextLine(); 
        if (taskNumber >= 1 && taskNumber <= planner.getEvents().size()) {
            Event1 selectedEvent = planner.getEvents().get(taskNumber - 1);
            logger.info("Select the task to mark as completed:");
            List<Task> tasks = selectedEvent.getTasks();
            for (int i = 0; i < tasks.size(); i++) {
            	logger.info((i + 1) + ". " + tasks.get(i).getDescription());
            }
            int selectedTask = scanner.nextInt();
            scanner.nextLine(); 
            if (selectedTask >= 1 && selectedTask <= tasks.size()) {
                Task taskToComplete = tasks.get(selectedTask - 1);
                taskToComplete.markCompleted();
                logger.info("Task marked as completed: " + taskToComplete.getDescription());
            } else {
            	logger.info("Invalid task selection.");
            }
        } else {
        	logger.info("Invalid event selection.");
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

        logger.info("Editing venue: " + venueToEdit.getName());
        logger.info("Current Capacity: " + venueToEdit.getCapacity());
        logger.info("Current Amenities: " + venueToEdit.getAmenities());
        logger.info("Current Price: " + venueToEdit.getPrice());

        logger.info("Enter new name (or press Enter to keep the current name): ");
        String newName = scanner.nextLine();

        logger.info("Enter new capacity (or press Enter to keep the current capacity): ");
        String newCapacityStr = scanner.nextLine();
        int newCapacity = venueToEdit.getCapacity(); 
        if (!newCapacityStr.isEmpty()) {
            try {
                newCapacity = Integer.parseInt(newCapacityStr);
            } catch (NumberFormatException e) {
            	logger.info("Invalid input for capacity. Keeping the current value.");
            }
        }

        logger.info("Enter new amenities (or press Enter to keep the current amenities): ");
        String newAmenities = scanner.nextLine();

        logger.info("Enter new price (or press Enter to keep the current price): ");
        String newPriceStr = scanner.nextLine();
        int newPrice = venueToEdit.getPrice(); 
        if (!newPriceStr.isEmpty()) {
            try {
                newPrice = Integer.parseInt(newPriceStr);
            } catch (NumberFormatException e) {
            	logger.info("Invalid input for price. Keeping the current value.");
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
        logger.info("Updated Venue Details:");
        System.out.println(venueToEdit);
    }

   
}
private List<EditVenue> venues = new ArrayList<>();
public String editVenueDirectly(String venueName, String newName, int newCapacity, String newAmenities, int newPrice) {
    for (EditVenue venue : venues) {
        if (venue.getName().equalsIgnoreCase(venueName)) {
            venue.setName(newName);
            venue.setCapacity(newCapacity);
            venue.setAmenities(newAmenities);
            venue.setPrice(newPrice);
            return "Venue updated successfully";
        }
    }
    return "Venue '" + venueName + "' not found.";



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
    logger.info("Available Venues:");
    for (DeleteVenue venue : venuesList) {
    	logger.info("- " + venue.getName());
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

      String result = deleteVenue(venuesList);
      logger.info(result);

      System.out.println("Remaining Venues:");
      for (DeleteVenue venue : venuesList) {
          System.out.println(venue);
      }
  }
public void Photo() {
	Scanner scanner = new Scanner(System.in);

	logger.info("Welcome to the File Uploader");
	logger.info("Please enter the path of the file you want to upload:");
    String filePath = scanner.nextLine();

    File file = new File(filePath);
    if (!file.exists() || !file.isFile()) {
    	logger.info("Invalid file path. Please provide a valid path to a file.");
        return;
    }

    try {
        String destinationFolder = "uploaded_files/";

        File destDir = new File(destinationFolder);
        if (!destDir.exists()) {
            destDir.mkdirs();
        }

        Files.copy(Paths.get(filePath), Paths.get(destinationFolder + file.getName()), StandardCopyOption.REPLACE_EXISTING);

        logger.info("File uploaded successfully to: " + destinationFolder + file.getName());
    } catch (Exception e) {
    	 logger.info("An error occurred during file upload: " + e.getMessage());
    } finally {
        scanner.close();
    }
}
}




