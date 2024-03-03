package Wedding.Planner;

public class EditEvent {
    private String brideName;
    private String groomName;
    private String date;
    private String time;
    private int numberOfGuests;
    private String venue;
    private String location;
    private String phone;

    // Constructor
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

    // Getters and Setters
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

    // Method to display event details
    public void displayEventDetails() {
        System.out.println("Event Details:");
        System.out.println("Bride Name: " + brideName);
        System.out.println("Groom Name: " + groomName);
        System.out.println("Date: " + date);
        System.out.println("Time: " + time);
        System.out.println("Number of Guests: " + numberOfGuests);
        System.out.println("Venue: " + venue);
        System.out.println("Location: " + location);
        System.out.println("Phone: " + phone);
    }
}
