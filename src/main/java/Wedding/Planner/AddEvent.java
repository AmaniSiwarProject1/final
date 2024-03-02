package Wedding.Planner;

public class AddEvent {
    
    private String date;
    private String time;

    private String location;
    private int numberOfGuests;
    private String brideName;
    private String groomName;
    private String venue;
    private String phone;

    // Constructor
    public AddEvent(String brideName, String groomName, String date,String time, int numberOfGuests, String venue, String location,String phone) {
        this.brideName = brideName;
        this.groomName = groomName;
        this.date = date;
        this.time = time;
        this.numberOfGuests = numberOfGuests;
        this.venue = venue;
        this.location = location;
        this.phone=phone;
    }

    // Getters and Setters
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getNumberOfGuests() {
        return numberOfGuests;
    }

    public void setNumberOfGuests(int numberOfGuests) {
        this.numberOfGuests = numberOfGuests;
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

    public String getVenue() {
        return venue;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    public void setTime(String phone) {
        this.time = time;
    }
    public String getTime() {
        return time;
    }
}