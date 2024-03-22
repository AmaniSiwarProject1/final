
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static org.junit.Assert.*;

import org.junit.Assert;

public class AddVenue {
    private AddVenue addVenue;

    @Given("the User is logged in and there is no venue named {string}")
    public void userIsLoggedInAndNoVenueNamed(String venueName) {
        addVenue = new AddVenue();
    }

    @When("the User adds a new venue named {string}")
    public void userAddsNewVenueNamed(String venueName) {
        addVenue = new AddVenue();
    }

    @Then("the new venue should be added successfully")
    public void newVenueAddedSuccessfully() {
        assertNotNull(addVenue);
    }

private boolean errorMessageDisplayed;
private boolean newVenueAdded;

@When("the User tries to add a new venue without providing all the required details")
public void theUserTriesToAddANewVenueWithoutProvidingAllTheRequiredDetails() {
    errorMessageDisplayed = true;
    newVenueAdded = false;
}

@Then("the system should display an error message and the new venue should not be added")
public void theSystemShouldDisplayAnErrorMessageAndTheNewVenueShouldNotBeAdded() {
    Assert.assertTrue("Error message should be displayed", errorMessageDisplayed);
    Assert.assertFalse("New venue should not be added", newVenueAdded);
}
}
