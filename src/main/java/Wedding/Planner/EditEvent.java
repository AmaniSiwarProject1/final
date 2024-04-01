package Wedding.Planner;
import java.util.logging.Level;
import java.util.logging.Logger;


public class EditEvent {
    private static final Logger logger = Logger.getLogger(EditEvent.class.getName());

    private String brideName;
    private String groomName;
    private String date;
    private String time;
    private int numberOfGuests;
    private String venue;
    private String location;
    private String phone;

    public EditEvent(String brideName, String groomName, String date, String time, int numberOfGuests, String venue, String location, String phone) {
        this.brideName = brideName;
        this.groomName = groomName;
        this.date = date;
        this.time = time;
        this.numberOfGuests = numberOfGuests;
        this.venue = venue;
        this.location = location;
        this.phone = phone;
    }

    public String getBrideName() {
        return brideName;
    }

    public void setBrideName(String brideName) {
        this.brideName = brideName;
    }

    public String getGroomName() {
        return groomName;
    }

    public void setGroomName(String groomName) {
        this.groomName = groomName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getNumberOfGuests() {
        return numberOfGuests;
    }

    public void setNumberOfGuests(int numberOfGuests) {
        this.numberOfGuests = numberOfGuests;
    }

    public String getVenue() {
        return venue;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void displayEventDetails() {
    	if (logger.isLoggable(Level.INFO)) {
    	    logger.info("Event Details:");
    	    logger.info(String.format("Bride Name: %s", brideName));
    	    logger.info(String.format("Groom Name: %s", groomName));
    	    logger.info(String.format("Date: %s", date));
    	    logger.info(String.format("Time: %s", time));
    	    logger.info(String.format("Number of Guests: %d", numberOfGuests));
    	    logger.info(String.format("Venue: %s", venue));
    	    logger.info(String.format("Location: %s", location));
    	    logger.info(String.format("Phone: %s", phone));
    	}

    }
}