import Wedding.Planner.AddEvent;
import Wedding.Planner.EventManagment;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class AddEventTest {
	 String brideName,groomName,date,time,numberOfGuests,venue, location,phone;
    private EventManagment eventManagement;
    private AddEvent newEvent;

    @Given("the User is logged in")
    public void theUserIsLoggedIn() {
        eventManagement = new EventManagment();
    }

    @Given("there is no event with brideName {string}, groomName {string}, date {string}, time {string}, numberOfGuests {string}, venue {string}, location {string}, and phone {string}")
    public void thereIsNoEventWithBrideNameGroomNameDateAndTimeNumberOfGuestsVenueLocationAndPhone(String brideName, String groomName, String date, String time, String numberOfGuests, String venue, String location, String phone) {
        newEvent = new AddEvent(brideName, groomName, date, time, Integer.parseInt(numberOfGuests), venue, location, phone);
    }

    @When("the User adds a new event with brideName {string}, groomName {string}, date {string}, time {string}, numberOfGuests {string}, venue {string}, location {string}, and phone {string}")
    public void theUserAddsANewEventWithBrideNameGroomNameDateTimeNumberOfGuestsVenueLocationAndPhone(String brideName, String groomName, String date, String time, String numberOfGuests, String venue, String location, String phone) {
        eventManagement.createWeddingEvent(brideName, groomName, date, time, Integer.parseInt(numberOfGuests), venue, location, phone);
    }

    @Then("the new event should be added successfully")
    public void theNewEventShouldBeAddedSuccessfully() {
        Assert.assertTrue("Event was not added successfully", eventManagement.checkEventsExist(newEvent.getBrideName(), newEvent.getGroomName(), newEvent.getDate(), newEvent.getTime(), newEvent.getNumberOfGuests(), newEvent.getVenue(), newEvent.getLocation(), newEvent.getPhone()));
    }
    @Given("there is an event with brideName {string}, groomName {string}, date {string}, time {string}, numberOfGuests {string}, venue {string}, location {string}, and phone {string}")
    public void thereIsAnEventWithBrideNameGroomNameDateTimeNumberOfGuestsVenueLocationAndPhone(String brideName, String groomName, String date, String time, String numberOfGuests, String venue, String location, String phone) {
        eventManagement.createWeddingEvent(brideName, groomName, date, time, Integer.parseInt(numberOfGuests), venue, location, phone);
    }

    @When("the User tries to add a new event with the same date, time, and venue")
    public void theUserTriesToAddANewEventWithTheSameDateTimeAndVenue() {
        eventManagement.createWeddingEvent("Bride5", "Groom5", "2024-05-20", "10:00 AM", 150, "Venue1", "Location1", "123456789");
    }

    @Then("the system should not allow adding the event and display a message about the venue being already booked")
    public void theSystemShouldNotAllowAddingTheEventAndDisplayAMessageAboutTheVenueBeingAlreadyBooked() {
        Assert.assertEquals("Venue is already booked for this time and date.", eventManagement.getErrorMessage());
    }
    @When("the User tries to add a new event with brideName {string}, groomName {string}, date {string}, time {string}, numberOfGuests {string}, venue {string}, location {string}, and phone {string}")
    public void theUserTriesToAddANewEventWithBrideNameGroomNameDateTimeNumberOfGuestsVenueLocationAndPhone(String string, String string2, String string3, String string4, String string5, String string6, String string7, String string8) {
        eventManagement.createWeddingEvent("Bride5", "Groom5", "2024-05-20", "10:00 AM", 150, "Venue1", "Location1", "123456789");

    }

    @Then("the system should not allow adding the event and display a message about the venue capacity being exceeded")
    public void theSystemShouldNotAllowAddingTheEventAndDisplayAMessageAboutTheVenueCapacityBeingExceeded() {
        Assert.assertEquals("Venue capacity exceeded for this event", eventManagement.getErrorMessage());

    }



    





}
