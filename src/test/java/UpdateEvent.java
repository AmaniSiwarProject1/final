import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;
import Wedding.Planner.EventManagment;
import Wedding.Planner.AddEvent;

public class UpdateEvent {
    private EventManagment eventManager = new EventManagment();
    private AddEvent updatedEvent;

    @Given("The user wants to update an event and The event does not exist in the events list")
    public void theUserWantsToUpdateAnEventAndTheEventDoesNotExistInTheEventsList() {
       // Here you can initialize or perform any setup if needed
    }

    @When("The user provides the new event details")
    public void theUserProvidesTheNewEventDetails() {
        String brideName = "New Bride";
        String groomName = "New Groom";
        String date = "2024-12-31";
        String time = "18:00";
        int numberOfGuests = 100;
        String venue = "New Venue";
        String location = "New Location";
        String phone = "New Phone";
        String price = "New price";

        updatedEvent = new AddEvent(brideName, groomName, date, time, numberOfGuests, venue, location, phone,price);
    }

    @Then("The system displays a message that the event was not found")
    public void theSystemDisplaysAMessageThatTheEventWasNotFound() {
        List<AddEvent> eventsList = eventManager.getEvents();
        boolean eventFound = false;

        for (AddEvent event : eventsList) {
            if (event.getDate().equals(updatedEvent.getDate()) && event.getTime().equals(updatedEvent.getTime())) {
                eventFound = true;
                break;
            }
        }

        assertTrue("Event with specified date and time was not found.", !eventFound);
    }

    @Given("The user wants to update an event")
    public void theUserWantsToUpdateAnEvent() {
        updatedEvent = new AddEvent("Original Bride", "Original Groom", "2024-12-25", "18:00", 100, "Original Venue", "Original Location", "Original Phone","price");
        eventManager.addEvent(updatedEvent);
    }

    @When("The user provides new event details")
    public void theUserProvidesNewEventDetails() {
        updatedEvent.setBrideName("Updated Bride");
        updatedEvent.setGroomName("Updated Groom");
        updatedEvent.setDate("2024-12-31");
        updatedEvent.setTime("18:00");
        updatedEvent.setNumberOfGuests(150);
        updatedEvent.setVenue("Updated Venue");
        updatedEvent.setLocation("Updated Location");
        updatedEvent.setPhone("Updated Phone");
        updatedEvent.setPrice("Updated Price");
    }

    @Then("The system updates the event and The system confirms the event was updated successfully")
    public void theSystemUpdatesTheEventAndTheSystemConfirmsTheEventWasUpdatedSuccessfully() {
        assertEquals("Updated Bride", updatedEvent.getBrideName());
        assertEquals("Updated Groom", updatedEvent.getGroomName());
        assertEquals("2024-12-31", updatedEvent.getDate());
        assertEquals("18:00", updatedEvent.getTime());
        assertEquals(150, updatedEvent.getNumberOfGuests());
        assertEquals("Updated Venue", updatedEvent.getVenue());
        assertEquals("Updated Location", updatedEvent.getLocation());
        assertEquals("Updated Phone", updatedEvent.getPhone());
        assertEquals("Updated Price", updatedEvent.getPrice());
    }
    
    private String brideName;
    private String groomName;
    private String date;
    private String venue;
    private String updatedBrideName;
    private String location;
    private String updatedVenue;
    private String updatedLocation;
@Given("an event with the following original details")
public void anEventWithTheFollowingOriginalDetails() {
	 brideName = "Emily Johnson";
	    groomName = "Michael Smith";
	    date = "June 15, 2024";
	    venue = "Rosewood Manor";
}

@When("the user updates the bride's")
public void theUserUpdatesTheBrideS() {
	brideName = updatedBrideName;
}

@Then("the system should reflect the changes with the updated event details")
public void theSystemShouldReflectTheChangesWithTheUpdatedEventDetails() {
	   System.out.println("Updated Event Details:");
	    System.out.println("Bride's Name: " + brideName);
	    System.out.println("Groom's Name: " + groomName);
	    System.out.println("Date: " + date);
	    System.out.println("Venue: " + venue);
}

@Given("an event with original details")
public void anEventWithOriginalDetails() {
	  brideName = "Emily Johnson";
	    groomName = "Michael Smith";
	    date = "June 15, 2024";
	    venue = "Rosewood Manor";
	    location = "New York City";
}

@When("the user updates the event venue and the location")
public void theUserUpdatesTheEventVenueAndTheLocation() {
	 venue = updatedVenue;
	    location = updatedLocation;
}
@Given("The user wants to update the number of guests for an event and An event with a specific number of guests exists in the events list.")
public void theUserWantsToUpdateTheNumberOfGuestsForAnEventAndAnEventWithASpecificNumberOfGuestsExistsInTheEventsList() {
	 updatedEvent = new AddEvent("Original Bride", "Original Groom", "2024-12-25", "18:00", 100, "Original Venue", "Original Location", "Original Phone", "price");
     eventManager.addEvent(updatedEvent);
}

@When("The user provides a new number of guests for the event.")
public void theUserProvidesANewNumberOfGuestsForTheEvent() {
	  updatedEvent.setNumberOfGuests(120);
}

@Then("The system updates the number of guests for the event and The system confirms that the number of guests was updated successfully.")
public void theSystemUpdatesTheNumberOfGuestsForTheEventAndTheSystemConfirmsThatTheNumberOfGuestsWasUpdatedSuccessfully() {
	 assertEquals(120, updatedEvent.getNumberOfGuests());
}
@Given("The user wants to update the date and time of an event and An event with a specific date and time exists in the events list.")
public void theUserWantsToUpdateTheDateAndTimeOfAnEventAndAnEventWithASpecificDateAndTimeExistsInTheEventsList() {
	updatedEvent = new AddEvent("Original Bride", "Original Groom", "2024-12-25", "18:00", 100, "Original Venue", "Original Location", "Original Phone", "price");
    eventManager.addEvent(updatedEvent);
}

@When("The user provides a new date and time for the event.")
public void theUserProvidesANewDateAndTimeForTheEvent() {
	updatedEvent.setDate("2024-12-31");
    updatedEvent.setTime("19:30");
}

@Then("The system updates the date and time for the event and The system confirms that the date and time were updated successfully.")
public void theSystemUpdatesTheDateAndTimeForTheEventAndTheSystemConfirmsThatTheDateAndTimeWereUpdatedSuccessfully() {
	 assertEquals("2024-12-31", updatedEvent.getDate());
     assertEquals("19:30", updatedEvent.getTime());
}

@Given("The user wants to update the price of an event and An event with a specific price exists in the events list.")
public void theUserWantsToUpdateThePriceOfAnEventAndAnEventWithASpecificPriceExistsInTheEventsList() {
	  updatedEvent = new AddEvent("Original Bride", "Original Groom", "2024-12-25", "18:00", 100, "Original Venue", "Original Location", "Original Phone", "Original Price");
      eventManager.addEvent(updatedEvent);
}

@When("The user provides a new price for the event.")
public void theUserProvidesANewPriceForTheEvent() {
	 updatedEvent.setPrice("Updated Price");
}

@Then("The system updates the price for the event and The system confirms that the price was updated successfully.")
public void theSystemUpdatesThePriceForTheEventAndTheSystemConfirmsThatThePriceWasUpdatedSuccessfully() {
	assertEquals("Updated Price", updatedEvent.getPrice());
}

@Given("an event with the  original details")
public void anEventWithTheOriginalDetails() {
	 brideName = "Emily Johnson";
	    groomName = "Michael Smith";
	    date = "June 15, 2024";
	    venue = "Rosewood Manor";
}
private String updatedGroomName;
@When("the user updates the groom's name to {string}")
public void theUserUpdatesTheGroomSNameTo(String string) {
	 groomName = updatedGroomName;
	    System.out.println("Updated Groom's Name: " + groomName);
}


}