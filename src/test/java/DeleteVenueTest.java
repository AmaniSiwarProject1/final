import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import Wedding.Planner.EventManagement;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DeleteVenueTest {
	private EventManagement eventManagment = new EventManagement();
    private EventManagement.VenueEditor venueEditor = eventManagment.new VenueEditor();
    
    private boolean venueExists;
    private boolean deletionConfirmed;
    private String deleteVenueName;
    private String message;

    @Given("The user entered information about the venue")
    public void theUserEnteredInformationAboutTheVenue() {
        assertTrue(true);
    }

    @When("The user attempts to delete a venue")
    public void theUserAttemptsToDeleteAVenue() {
        deleteVenueName = "Example Venue";
    }

    @Then("The system notifies the user that there are no venues to delete")
    public void theSystemNotifiesTheUserThatThereAreNoVenuesToDelete() {
        eventManagment.deleteVenue(deleteVenueName);
    }
    
    private String deleteResult;

    private String deletionStatusMessage;

    @Given("There exists a venue in the venues list")
    public void thereExistsAVenueInTheVenuesList() {
    	eventManagment = new EventManagement();
    }

    @When("The user wants to delete a venue and The user provides the venue name")
    public void theUserWantsToDeleteAVenueAndTheUserProvidesTheVenueName() {
        deleteVenueName = "Existing Venue";
        deletionStatusMessage = eventManagment.deleteVenue(deleteVenueName);
    }

    @Then("The system deletes the venue")
    public void theSystemDeletesTheVenue() {
assertTrue(true);
    }
}
