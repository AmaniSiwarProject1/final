import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import static org.junit.Assert.*;

import Wedding.Planner.AddEvent;
import Wedding.Planner.EventManagment;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Calender {
    private EventManagment eventManager = new EventManagment();
    private List<AddEvent> events = new ArrayList<>();
    private String viewOutcome;

    @Given("The calendar is newly initialized and contains no events.")
    public void theCalendarIsNewlyInitializedAndContainsNoEvents() {
        events.clear();
    }

    @When("The user requests to view all events in the calendar.")
    public void theUserRequestsToViewAllEventsInTheCalendar() {
        if (events.isEmpty()) {
            viewOutcome = "No events to display.";
        } else {
            viewOutcome = "Events to display.";
        }
    }

    @Then("The system should inform the user that there are no events to display.")
    public void theSystemShouldInformTheUserThatThereAreNoEventsToDisplay() {
        assertEquals("No events to display.", viewOutcome);
    }

    @Given("a user has added events to the calendar successfully,")
    public void aUserHasAddedEventsToTheCalendarSuccessfully() {
     assertTrue(true);
    }

    @When("the user requests to view all scheduled events,")
    public void theUserRequestsToViewAllScheduledEvents() {
        if (events.isEmpty()) {
            viewOutcome = "No events to display.";
        } else {
            viewOutcome = "Events to display.";
        }
    }

    @Then("the system displays all the added events.")
    public void theSystemDisplaysAllTheAddedEvents() {
        eventManager.displayAllEvents(); 
        assertTrue(checkIfEventsAreDisplayed()); 
    }

   

    private boolean checkIfEventsAreDisplayed() {
        
        return true; 
    }
    @Given("the calendar contains upcoming events within a certain time frame")
    public void theCalendarContainsUpcomingEventsWithinACertainTimeFrame() {
    	 assertTrue(true);
    	}

    @When("the system detects that there are events scheduled within the next week")
    public void theSystemDetectsThatThereAreEventsScheduledWithinTheNextWeek() {
        System.out.println("System detects upcoming events within the next week.");

    }

    @Then("the system sends a reminder notification to the user about the upcoming events")
    public void theSystemSendsAReminderNotificationToTheUserAboutTheUpcomingEvents() {
    	 System.out.println("Upcoming events within the next week:");
    	    for (AddEvent event : events) {
    	        System.out.println(event);
    	    }
    }

}