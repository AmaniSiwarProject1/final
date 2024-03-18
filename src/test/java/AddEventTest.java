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









}
