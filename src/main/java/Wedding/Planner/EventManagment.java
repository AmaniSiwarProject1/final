package Wedding.Planner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class EventManagment {
    private String errorMessage;
    private Map<String, Integer> venueCapacities; // HashMap لتخزين سعة كل قاعة

    private List<AddEvent> events;
    private static Scanner input = new Scanner(System.in); // Use static to avoid creating multiple instances

    
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
        if (checkEventsExist(event.getBrideName(), event.getGroomName(), event.getDate(), event.getTime(), event.getNumberOfGuests(), event.getVenue(), event.getLocation(), event.getPhone())) {
            System.out.println("Event already exists in the list.");
        } else {
            events.add(event);
            System.out.println("Event added successfully for: " + event.getBrideName() + " and " + event.getGroomName());
        }
    }


    public boolean checkEventsExist(String brideName, String groomName, String date, String time, int numberOfGuests,
            String venue, String location, String phone) {
        for (AddEvent existingEvent : events) {
            // تحقق من عدم وجود قيم null قبل استخدام equals()
            if (existingEvent.getBrideName() != null &&
                existingEvent.getGroomName() != null &&
                existingEvent.getDate() != null &&
                existingEvent.getTime() != null &&
                existingEvent.getVenue() != null &&
                existingEvent.getLocation() != null &&
                existingEvent.getPhone() != null &&
                // تحقق من تطابق كل الخصائص بين الحدث الحالي والحدث المطلوب
                existingEvent.getBrideName().equals(brideName) &&
                existingEvent.getGroomName().equals(groomName) &&
                existingEvent.getDate().equals(date) &&
                existingEvent.getTime().equals(time) &&
                existingEvent.getNumberOfGuests() == numberOfGuests &&
                existingEvent.getVenue().equals(venue) &&
                existingEvent.getLocation().equals(location) &&
                existingEvent.getPhone().equals(phone)) {
                return true; // الحدث موجود بالفعل
            }
        }
        return false; // الحدث غير موجود
    }




	public void listAllEvents() {
        if (events.isEmpty()) {
            System.out.println("No events to display.");
        } else {
            System.out.println("List of Events:");
            for (int i = 0; i < events.size(); i++) {
                AddEvent event = events.get(i);
                System.out.println((i + 1) + ". " + event.getBrideName() + " and " + event.getGroomName() +
                        " - " + event.getDate() + " - " + event.getLocation() + " - " + event.getPhone());
            }
        }
    }

	public void createWeddingEvent(String brideName, String groomName, String date, String time, int numberOfGuests, String venue, String location, String phone) {
	    // تعريف وتعبئة الخريطة venueCapacities
	    Map<String, Integer> venueCapacities = new HashMap<>();
	    venueCapacities.put("Venue1", 100);
	    venueCapacities.put("Venue2", 150);
	    venueCapacities.put("Venue3", 200);

	    // التحقق من القاعة محجوزة بالفعل
	    for (AddEvent event : events) {
	        String eventVenue = event.getVenue();
	        if (eventVenue != null && eventVenue.equals(venue) && event.getDate().equals(date) && event.getTime().equals(time)) {
	            errorMessage = "Venue is already booked for this time and date.";
	            return;
	        }
	    }

	    // التحقق من السعة المسموح بها للقاعة
	    if (venueCapacities.containsKey(venue) && numberOfGuests > venueCapacities.get(venue)) {
	        errorMessage = "Venue capacity exceeded for this event";
	        return;
	    }

	    // إذا مرت جميع التحققات، قم بإضافة الحدث
	    addEvent(new AddEvent(brideName, groomName, date, time, numberOfGuests, venue, location, phone));
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

        addEvent(new AddEvent(brideName, groomName, eventDate, eventTime, numberOfGuests, venueName, eventLocation, phone));
    }

    public void addMultipleEvents(List<AddEvent> newEvents) {
        for (AddEvent event : newEvents) {
            addEvent(event);
        }
        System.out.println("Multiple events added successfully.");
    }

    public void displayEventListSize() {
        System.out.println("Number of events in the list: " + events.size());
    }

   
    





 

	
}