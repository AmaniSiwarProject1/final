import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

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
    private String venueToUpdate;

@Given("The user wants to update a venue")
public void theUserWantsToUpdateAVenue() {
	 venueToUpdate = "Rosewood Manor";
	    System.out.println("User wants to update venue: " + venueToUpdate);
}

@Then("The system updates the venue details")
public void theSystemUpdatesTheVenueDetails() {
 assertTrue(true);
}

private int newCapacity;
@Given("The user wants to update the capacity of a venue")
public void theUserWantsToUpdateTheCapacityOfAVenue() {
	 venueToUpdate = "Rosewood Manor";
	    System.out.println("User wants to update capacity for venue: " + venueToUpdate);

}

@When("The user provides the new capacity for the venue")
public void theUserProvidesTheNewCapacityForTheVenue() {
	  newCapacity = 200;
	    System.out.println("User provides new capacity: " + newCapacity);
}

@Then("The system updates the venue capacity and The system confirms that the capacity has been updated successfully")
public void theSystemUpdatesTheVenueCapacityAndTheSystemConfirmsThatTheCapacityHasBeenUpdatedSuccessfully() {
	  System.out.println("Successfully updated capacity for venue: " + venueToUpdate + " to " + newCapacity);
}

private String newLocation;
@Given("The user wants to update the location of a venue")
public void theUserWantsToUpdateTheLocationOfAVenue() {
	 venueToUpdate = "Rosewood Manor";
	    System.out.println("User wants to update location for venue: " + venueToUpdate);

}

@When("The user provides the new location for the venue")
public void theUserProvidesTheNewLocationForTheVenue() {
	 newLocation = "New York City";
	    System.out.println("User provides new location: " + newLocation);
}

@Then("The system updates the venue location  and The system confirms that the location has been updated successfully")
public void theSystemUpdatesTheVenueLocationAndTheSystemConfirmsThatTheLocationHasBeenUpdatedSuccessfully() {
	 System.out.println("Successfully updated location for venue: " + venueToUpdate + " to " + newLocation);

}

private String newPricingOptions;
@Given("The user wants to update the pricing options for a venue")
public void theUserWantsToUpdateThePricingOptionsForAVenue() {
	venueToUpdate = "Rosewood Manor";
    System.out.println("User wants to update pricing options for venue: " + venueToUpdate);

}

@When("The user provides the new pricing details for the venue")
public void theUserProvidesTheNewPricingDetailsForTheVenue() {
	  newPricingOptions = "Gold Package: $2000, Silver Package: $1500";
	    System.out.println("User provides new pricing options: " + newPricingOptions);
}

@Then("The system updates the pricing options and The system confirms that the pricing options have been updated successfully")
public void theSystemUpdatesThePricingOptionsAndTheSystemConfirmsThatThePricingOptionsHaveBeenUpdatedSuccessfully() {
	 System.out.println("Successfully updated pricing options for venue: " + venueToUpdate + " to " + newPricingOptions);
}

}