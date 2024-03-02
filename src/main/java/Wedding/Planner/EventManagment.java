package Wedding.Planner;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EventManagment {
    public List<AddEvent> events;
    private static Scanner input2 = new Scanner(System.in);

    public EventManagment() {
        events = new ArrayList<>();
    }

    public void addEvent(AddEvent event) {
        events.add(event);
        System.out.println("Event added successfully for: " + event.getBrideName() + " and " + event.getGroomName());
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

    public void createWeddingEvent(String brideName, String groomName, String date, String time, String numberOfGuests, String venue, String location, String phone) {
        AddEvent weddingEvent = new AddEvent(brideName, groomName, date, time, Integer.parseInt(numberOfGuests), venue, location, phone);
        addEvent(weddingEvent);
    }

    public void addEvent() {
        System.out.print("Enter Bride Name: ");
        String brideName = input2.nextLine();
        System.out.print("Enter Groom Name: ");
        String groomName = input2.nextLine();
        System.out.print("Enter Event Date: ");
        String eventDate = input2.nextLine();
        System.out.print("Enter Event time: ");
        String eventTime = input2.nextLine();
        System.out.print("Enter Number of Guests: ");
        int numberOfGuests;
        while (true) {
            try {
                numberOfGuests = Integer.parseInt(input2.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            }
        }
        System.out.print("Enter Venue Name: ");
        String venueName = input2.nextLine();
        System.out.print("Enter Event Location: ");
        String eventLocation = input2.nextLine();
        System.out.print("Enter Your phone for contact: ");
        String phone = input2.nextLine();

        AddEvent newEvent = new AddEvent(brideName, groomName, eventDate, eventTime, numberOfGuests, venueName, eventLocation, phone);
        addEvent(newEvent);
    }

    public void addMultipleEvents(List<AddEvent> newEvents) {
        events.addAll(newEvents);
        System.out.println("Multiple events added successfully.");
    }

    public void displayEventListSize() {
        System.out.println("Number of events in the list: " + events.size());
    }
}
