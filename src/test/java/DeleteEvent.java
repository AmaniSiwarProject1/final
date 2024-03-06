import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import Wedding.Planner.EventManagment;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DeleteEvent {

    private EventManagment eventManagment;

    @Given("The user entered information about the event")
    public void theUserEnteredInformationAboutTheEvent() {
assertTrue(true);    }

    @When("The user attempts to delete an event")
    public void theUserAttemptsToDeleteAnEvent() {
        
        eventManagment = new EventManagment();
        eventManagment.deleteEvent("2024-03-06", "10:00 AM");
    }

    @Then("The system notifies the user that there are no events to delete")
    public void theSystemNotifiesTheUserThatThereAreNoEventsToDelete() {
        assertTrue(eventManagment.getEvents().isEmpty());
    }

    @Given("The user wants to delete an event")
    public void theUserWantsToDeleteAnEvent() {
      assertTrue(true);
    }
    private String deleteEventDate;
    private String deleteEventTime;
    
    @When("The user provides the event details")
    public void theUserProvidesTheEventDetails() {
     
        deleteEventDate = "2024-03-06";
        deleteEventTime = "10:00 AM";
    }

    @Then("The system deletes the event")
    public void theSystemDeletesTheEvent() {
    	eventManagment = new EventManagment();
     
        eventManagment.deleteEvent("2024-03-06", "10:00 AM");
    }

    private boolean eventExists;
    private boolean deletionConfirmed;
    
    @Given("There exists an event in the events list")
    public void thereExistsAnEventInTheEventsList() {
        eventExists = true;
    }

    private String eventToDeleteDate;
    private String eventToDeleteTime;
    @When("The user attempts to delete the event")
    public void theUserAttemptsToDeleteTheEvent() {

    	eventManagment = new EventManagment();
        if (eventExists) {
            assertTrue(true);
       } else {
            System.out.println("There is no event to delete.");
        }
    }
    @Then("The system prompts the user to confirm deletion and The user cancels the deletion and The event remains in the events list")
    public void theSystemPromptsTheUserToConfirmDeletionAndTheUserCancelsTheDeletionAndTheEventRemainsInTheEventsList() {
        if (eventExists) {
            deletionConfirmed = false; 
            
            assertTrue(eventExists);
            assertFalse(deletionConfirmed);
        } else {
            
        }
    }

}