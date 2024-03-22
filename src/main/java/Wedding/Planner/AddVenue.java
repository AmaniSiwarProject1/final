package Wedding.Planner;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class AddVenue {
    private String name;
    private int capacity;
    private String amenities;
    private int price;
 


    // Constructor
    public AddVenue(String name, int capacity, String amenities, int price) {
        this.name = name;
        this.capacity = capacity;
        this.amenities = amenities;
        this.price = price;
    }

    // Default Constructor
    public AddVenue() {
        // Default constructor
    }

    // Getter and Setter for Venue Name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Getter and Setter for Capacity
    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    // Getter and Setter for Amenities
    public String getAmenities() {
        return amenities;
    }

    public void setAmenities(String amenities) {
        this.amenities = amenities;
    }

    // Getter and Setter for Price
    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    // Getter and Setter for Available Date
 

    // toString method to display Venue details
    @Override
    public String toString() {
        return "Venue{" +
                "name='" + name + '\'' +
                ", capacity=" + capacity +
                ", amenities='" + amenities + '\'' +
                ", price=" + price +
                '}';
    }
}