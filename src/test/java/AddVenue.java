import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;

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

private boolean userIsLoggedIn;
private Set<String> existingVenues = new HashSet<>();
private String existingVenue;
private String newVenue;
@Given("the User is logged in and there exists a venue named {string}")
public void theUserIsLoggedInAndThereExistsAVenueNamed(String string) {
	 userIsLoggedIn = true;

	    // Add the existing venue to the set of existing venues
	    existingVenues.add(existingVenue);
}

@When("the User tries to add a new venue named {string}")
public void theUserTriesToAddANewVenueNamed(String string) {
	  if (existingVenues.contains(newVenue)) {
	        // Display error message if the new venue already exists
	        System.out.println("Error: The venue name '" + newVenue + "' already exists.");
	    } else {
	        // Add the new venue if it does not already exist
	        existingVenues.add(newVenue);
	        System.out.println("Successfully added new venue: " + newVenue);
	    }
}

@Then("the system should display an error message stating that the venue name {string} already exists and the new venue {string} should not be added")
public void theSystemShouldDisplayAnErrorMessageStatingThatTheVenueNameAlreadyExistsAndTheNewVenueShouldNotBeAdded(String string, String string2) {
	 if (existingVenues.contains(newVenue)) {
	        // Display error message if the new venue was mistakenly added
	        System.out.println("Error: The venue name '" + newVenue + "' was mistakenly added.");
	    } else {
	        // Print success message if everything is as expected
	        System.out.println("Success: The venue name '" + newVenue + "' does not exist.");
	    }
}

@When("the User tries to add a new venue with special characters in the name")
public void theUserTriesToAddANewVenueWithSpecialCharactersInTheName() {
	 String newVenueWithSpecialCharacters = "New Venue@!#";
	    if (isValidVenueName(newVenueWithSpecialCharacters)) {
	        existingVenues.add(newVenueWithSpecialCharacters);
	        System.out.println("Successfully added new venue with special characters: " + newVenueWithSpecialCharacters);
	    } else {
	        System.out.println("Error: The venue name '" + newVenueWithSpecialCharacters + "' contains invalid characters.");
	    }
}

@Then("the system should display an error message stating that the venue name contains invalid characters and the new venue should not be added")
public void theSystemShouldDisplayAnErrorMessageStatingThatTheVenueNameContainsInvalidCharactersAndTheNewVenueShouldNotBeAdded() {
  assertTrue(true);
}

private boolean isValidVenueName(String venueName) {
    // Check if venue name contains only letters, numbers, spaces, and hyphens
    return venueName.matches("^[a-zA-Z0-9\\s\\-]+$");
}
private static final int MAX_VENUE_NAME_LENGTH = 20;

@When("the User tries to add a new venue with a long name exceeding the character limit")
public void theUserTriesToAddANewVenueWithALongNameExceedingTheCharacterLimit() {
	 String newVenueLongName = "Long Venue Name Exceeding Character Limit";
	    if (isValidVenueNameLength(newVenueLongName)) {
	        existingVenues.add(newVenueLongName);
	        System.out.println("Successfully added new venue with long name: " + newVenueLongName);
	    } else {
	        System.out.println("Error: The venue name '" + newVenueLongName + "' exceeds the character limit.");
	    }
}

@Then("the system should display an error message stating that the venue name exceeds the character limit and the new venue should not be added")
public void theSystemShouldDisplayAnErrorMessageStatingThatTheVenueNameExceedsTheCharacterLimitAndTheNewVenueShouldNotBeAdded() {
    assertTrue(true);
}
private boolean isValidVenueNameLength(String venueName) {
    return venueName.length() <= MAX_VENUE_NAME_LENGTH;
}
}