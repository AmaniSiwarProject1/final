package Wedding.Planner;
public class Venue {
    private String id;
    private String name;
    private double price;
    private String availableDate;
    private String hour;
    public Venue( String name, double price, String availableDate, String hour) {
      
        this.name = name;
        this.price = price;
        this.availableDate = availableDate;
        this.hour =hour;
    }

    

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getAvailableDate() {
        return availableDate;
    }
    public String getAvailablehour() {
        return hour;
    }

    // Setters if needed
    
    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setAvailableDate(String availableDate) {
        this.availableDate = availableDate;
    }
    
    public void setAvailablehour(String availablehour) {
        this.hour = hour;
    }
    @Override
    public String toString() {
        return "Venue{" +
                " name='" + name + '\'' +
                ", price=" + price +
                ", availableDate='" + availableDate + '\'' + ", hour='" + hour+ '\''+
                '}';
    }
}