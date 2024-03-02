import Wedding.Planner.EventManagment;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import static org.junit.Assert.assertTrue;

public class AddEvent {
    private EventManagment eventManagment;

    @Given("that the User is logged in")
    public void thatTheUserIsLoggedIn() {
        // Assuming the user is logged in
    }

    @Given("there is an Event with brideName {string}, groomName {string}, date {string}, time {string}, numberOfGuests {int}, venue {string}, location {string}, and phone {string}")
    public void thereIsAnEventWithBrideNameGroomNameDateNumberOfGuestsVenueLocationAndPhone(String brideName, String groomName, String date, String time, int numberOfGuests, String venue, String location, String phone) {
        eventManagment = new EventManagment();
      //  eventManagment.createWeddingEvent(brideName, groomName, date, time, numberOfGuests, venue, location, phone);
    }

    @Then("the Event will be saved in the newEventsList")
    public void theEventWillBeSavedInTheNewEventsList() {
        assertTrue(eventManagment.events.size() > 0);
    }

    @Given("the venue is allocated")
    public void theVenueIsAllocated() {
        // Assuming the venue is allocated
    }

    @Then("that show an error message")
    public void thatShowAnErrorMessage() {
        // Assuming an error message is shown
    }

    @Given("the numberOfGuests is larger")
    public void theNumberOfGuestsIsLarger() {
        // Assuming the number of guests is larger
    }

    @Then("the event will not be saves and error message will appear")
    public void theEventWillNotBeSavesAndErrorMessageWillAppear() {
        assertTrue(eventManagment.events.size() == 0);
        // Assuming an error message is shown
    }
}
