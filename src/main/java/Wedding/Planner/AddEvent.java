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
    private String price;

    public AddEvent(String brideName, String groomName, String date,String time, int numberOfGuests, String venue, String location,String phone,String price) {
        this.brideName = brideName;
        this.groomName = groomName;
        this.date = date;
        this.time = time;
        this.numberOfGuests = numberOfGuests;
        this.venue = venue;
        this.location = location;
        this.phone=phone;
        this.price= price;

    }

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
    public void setTime(String time) {
        this.time = time;
    }
    public String getTime() {
        return time;
    }
    public String getPrice() {
        return price;
    }
    public void setPrice(String price) {
        this.price =price;
    }
    private String eventName;

    public AddEvent(String eventName) {
        this.eventName = eventName;
    }

    public String getEventName() {
        return eventName;
    }

}