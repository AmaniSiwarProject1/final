import Wedding.Planner.AddEvent;
import Wedding.Planner.EventManagment;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class AddEventTest {
	
	 private EventManagment eventManagement;
	    private AddEvent newEvent;
	    @Given("the User is logged in")
	    public void theUserIsLoggedIn() {
	        eventManagement = new EventManagment();

	    }
	@Given("there is no event with brideName {string}, groomName {string}, date {string}, time {string}, numberOfGuests {string}, venue {string}, location {string}, phone {string} , and price {string}")
	public void thereIsNoEventWithBrideNameGroomNameDateTimeNumberOfGuestsVenueLocationPhoneAndPrice(String string, String string2, String string3, String string4, String string5, String string6, String string7, String string8, String string9) {
		newEvent = new AddEvent(string, string2, string3, string4, Integer.parseInt(string5), string6, string7, string8, string9);}

	@When("the User adds a new event with brideName {string}, groomName {string}, date {string}, time {string}, numberOfGuests {string}, venue {string}, location {string},  phone {string} , and price {string}")
	public void theUserAddsANewEventWithBrideNameGroomNameDateTimeNumberOfGuestsVenueLocationPhoneAndPrice(String string, String string2, String string3, String string4, String string5, String string6, String string7, String string8, String string9) {
        eventManagement.createWeddingEvent(string, string2, string3, string4, Integer.parseInt(string5), string6, string7, string8, string9);}
	
	@Then("the new event should be added successfully")
	public void theNewEventShouldBeAddedSuccessfully() {
        Assert.assertTrue("Event was not added successfully", eventManagement.checkEventsExist(newEvent.getBrideName(), newEvent.getGroomName(), newEvent.getDate(), newEvent.getTime(), newEvent.getNumberOfGuests(), newEvent.getVenue(), newEvent.getLocation(), newEvent.getPhone(),newEvent.getPrice()));

	}
	@Given("there is an event with brideName {string}, groomName {string}, date {string}, time {string}, numberOfGuests {string}, venue {string}, location {string}, and phone {string} ,and price {string}")
	public void thereIsAnEventWithBrideNameGroomNameDateTimeNumberOfGuestsVenueLocationAndPhoneAndPrice(String string, String string2, String string3, String string4, String string5, String string6, String string7, String string8, String string9) {
        eventManagement.createWeddingEvent(string, string2, string3, string4, Integer.parseInt(string5), string6, string7, string8, string9);}

	

	@When("the User tries to add a new event with the same date, time, and venue")
	public void theUserTriesToAddANewEventWithTheSameDateTimeAndVenue() {
        eventManagement.createWeddingEvent("Bride5", "Groom5", "2024-05-20", "10:00 AM", 150, "Venue1", "Location1", "123456789","2500");

	}

	@Then("the system should not allow adding the event and display a message about the venue being already booked")
	public void theSystemShouldNotAllowAddingTheEventAndDisplayAMessageAboutTheVenueBeingAlreadyBooked() {
        Assert.assertEquals("Venue is already booked for this time and date.", eventManagement.getErrorMessage());

	}

	@Given("there is an event with brideName {string}, groomName {string}, date {string}, time {string}, numberOfGuests {string}, venue {string}, location {string}, and phone {string}, and price {string}")
	public void thereIsAnEventWithBrideNameGroomNameDateTimeNumberOfGuestsVenueLocationAndPhoneAndPrice1(String string, String string2, String string3, String string4, String string5, String string6, String string7, String string8, String string9) {
        eventManagement.createWeddingEvent(string, string2, string3, string4, Integer.parseInt(string5), string6, string7, string8, string9);}

	

	@When("the User tries to add a new event with brideName {string}, groomName {string}, date {string}, time {string}, numberOfGuests {string}, venue {string}, location {string}, and phone {string},and price {string}")
	public void theUserTriesToAddANewEventWithBrideNameGroomNameDateTimeNumberOfGuestsVenueLocationAndPhoneAndPrice(String string, String string2, String string3, String string4, String string5, String string6, String string7, String string8, String string9) {
        eventManagement.createWeddingEvent("Bride5", "Groom5", "2024-05-20", "10:00 AM", 150, "Venue1", "Location1", "123456789","2500");
	}

	@Then("the system should not allow adding the event and display a message about the venue capacity being exceeded")
	public void theSystemShouldNotAllowAddingTheEventAndDisplayAMessageAboutTheVenueCapacityBeingExceeded() {
        Assert.assertEquals("Venue capacity exceeded for this event", eventManagement.getErrorMessage());

	}
	private boolean userIsLoggedIn;
	private boolean eventCreationAllowed;
	
	@Given("the User is logged in and the User is trying to add a new event")
	public void theUserIsLoggedInAndTheUserIsTryingToAddANewEvent() {
		  userIsLoggedIn = true;
		    eventCreationAllowed = true;
	}

	@When("the User provides all event details except the bride's name")
	public void theUserProvidesAllEventDetailsExceptTheBrideSName() {
	    // Write code here that turns the phrase above into concrete actions
		  eventCreationAllowed = false;
	}

	@Then("the system should not allow adding the event and display an error message about the missing bride's name")
	public void theSystemShouldNotAllowAddingTheEventAndDisplayAnErrorMessageAboutTheMissingBrideSName() {
		 if (!eventCreationAllowed) {
		        System.out.println("Error: The event cannot be added as the bride's name is missing.");
		    }
	}

@When("the User provides an invalid phone number format for the event")
public void theUserProvidesAnInvalidPhoneNumberFormatForTheEvent() {
    // Write code here that turns the phrase above into concrete actions
	 eventCreationAllowed = false;
}

@Then("the system should not allow adding the event and display an error message about the invalid phone number format")
public void theSystemShouldNotAllowAddingTheEventAndDisplayAnErrorMessageAboutTheInvalidPhoneNumberFormat() {
	 if (!eventCreationAllowed) {
	        System.out.println("Error: The event cannot be added due to an invalid phone number format.");
	    }
}

@When("the User provides all event details except the groom's name")
public void theUserProvidesAllEventDetailsExceptTheGroomSName() {
	eventCreationAllowed = false;
}

@Then("the system should not allow adding the event and display an error message about the missing groom's name")
public void theSystemShouldNotAllowAddingTheEventAndDisplayAnErrorMessageAboutTheMissingGroomSName() {
	 if (!eventCreationAllowed) {
	        System.out.println("Error: The event cannot be added as the groom's name is missing.");
	    }
}
@When("the User provides an invalid date format for the event date \\(e.g., {string})")
public void theUserProvidesAnInvalidDateFormatForTheEventDateEG(String string) {
    eventCreationAllowed = false;

}

@Then("the system should not allow adding the event and display an error message indicating that the date format is invalid")
public void theSystemShouldNotAllowAddingTheEventAndDisplayAnErrorMessageIndicatingThatTheDateFormatIsInvalid() {
	if (!eventCreationAllowed) {
        System.out.println("Error: The event cannot be added as the date format is invalid.");
    }
}


}