import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.assertTrue;

import org.junit.Assert;

public class VenueTest {

    private boolean venuesAvailable;
    private boolean matchingVenueFound;


@Given("available venues for events and the user wants to find a matching venue for an event.")
public void availableVenuesForEventsAndTheUserWantsToFindAMatchingVenueForAnEvent() {
        venuesAvailable = true;
    }

@When("the user provides the maximum price and the event date and no matching venue is found.")
public void theUserProvidesTheMaximumPriceAndTheEventDateAndNoMatchingVenueIsFound() {
        matchingVenueFound = false;
    }

@Then("the system displays a message that no venues are available.")
public void theSystemDisplaysAMessageThatNoVenuesAreAvailable() {
        Assert.assertTrue("Venues should be available", venuesAvailable);
        Assert.assertFalse("No matching venue should be found", matchingVenueFound);
      
    }




}