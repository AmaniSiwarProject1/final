package Wedding.Planner;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class AddVenue {
    private String name;
    private int capacity;
    private String amenities;
    private int price;
 


    public AddVenue(String name, int capacity, String amenities, int price) {
        this.name = name;
        this.capacity = capacity;
        this.amenities = amenities;
        this.price = price;
    }

    public AddVenue() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getAmenities() {
        return amenities;
    }

    public void setAmenities(String amenities) {
        this.amenities = amenities;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

 

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