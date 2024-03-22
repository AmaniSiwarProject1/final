import static org.junit.Assert.assertEquals;

import Wedding.Planner.EventManagment;
import Wedding.Planner.EventManagment.VenueEditor;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

public class EditVenue {
    
    private EventManagment eventManagment = new EventManagment();
    private EventManagment.VenueEditor venueEditor = eventManagment.new VenueEditor();
    
    private String message;

    @Given("The user wants to update a venue and The venue does not exist in the venues list")
    public void theUserWantsToUpdateAVenueAndTheVenueDoesNotExistInTheVenuesList() {
        // هذه الخطوة لتوفير السياق، لا حاجة لتنفيذ أي كود هنا
    }

    @When("The user provides the new venue details")
    public void theUserProvidesTheNewVenueDetails() {
    	String venueName = "Nonexistent Venue"; // اسم مكان توقعي لا يوجد فعلًا
        int newCapacity = 100;
        String newName = "New Venue Name";
        String newAmenities = "New Amenities";
        int newPrice = 5000;
		message = eventManagment.editVenueDirectly(venueName, newName, newCapacity, newAmenities, newPrice);
    }

    @Then("The system displays a message that the venue was not found")
    public void theSystemDisplaysAMessageThatTheVenueWasNotFound() {
    	
    	String expectedMessage = "Venue 'Nonexistent Venue' not found."; // تحديد الرسالة المتوقعة داخل الدالة
        assertEquals(expectedMessage, message);
    }
}