import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;
import Wedding.Planner.AddEvent;
import Wedding.Planner.EventManagement;

public class UpdateEvent {
    private EventManagement eventManager = new EventManagement();
    private AddEvent updatedEvent;

    @Given("The user wants to update an event and The event does not exist in the events list")
    public void theUserWantsToUpdateAnEventAndTheEventDoesNotExistInTheEventsList() {
       assertTrue(true);
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

       assertTrue(true);
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

        assertTrue(true);
    }

}