import static org.junit.Assert.assertEquals;

import Wedding.Planner.EventManagement;
import Wedding.Planner.EventManagement.VenueEditor;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

public class EditVenue {
    
    private EventManagement eventManagment = new EventManagement();
    private EventManagement.VenueEditor venueEditor = eventManagment.new VenueEditor();
    
    private String message;

    @Given("The user wants to update a venue and The venue does not exist in the venues list")
    public void theUserWantsToUpdateAVenueAndTheVenueDoesNotExistInTheVenuesList() {
    }

    @When("The user provides the new venue details")
    public void theUserProvidesTheNewVenueDetails() {
    	String venueName = "Nonexistent Venue";
        int newCapacity = 100;
        String newName = "New Venue Name";
        String newAmenities = "New Amenities";
        int newPrice = 5000;
		message = eventManagment.editVenueDirectly(venueName, newName, newCapacity, newAmenities, newPrice);
    }

    @Then("The system displays a message that the venue was not found")
    public void theSystemDisplaysAMessageThatTheVenueWasNotFound() {
    	
    	String expectedMessage = "Venue 'Nonexistent Venue' not found."; 
        assertEquals(expectedMessage, message);
    }
}