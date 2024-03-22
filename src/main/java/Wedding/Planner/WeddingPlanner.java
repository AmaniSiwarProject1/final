package Wedding.Planner;
import java.util.ArrayList;
import java.util.List;
public class WeddingPlanner {
	  private List<Event1> events;

	    public WeddingPlanner() {
	        this.events = new ArrayList<>();
	    }

	    public void addEvent(Event1 event) {
	        events.add(event);
	    }

	    public void displayAllEvents() {
	        for (Event1 event : events) {
	            event.displayEventDetails();
	        }
	    }

	    public List<Event1> getEvents() {
	        return events;
	    
    }}