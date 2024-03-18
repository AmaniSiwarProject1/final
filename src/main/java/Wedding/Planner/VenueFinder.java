package Wedding.Planner;
import java.util.ArrayList;
import java.util.List;

public class VenueFinder {

    public List<Venue> findMatchingVenues(List<Venue> venues, double maxPrice, String weddingDate,String hour) {
        List<Venue> matchingVenues = new ArrayList<>();
        for (Venue venue : venues) {
            if (venue.getPrice() <= maxPrice && venue.getAvailableDate().equals(weddingDate) && venue.getAvailablehour().equals(hour)) {
                matchingVenues.add(venue);
            }
        }
        return matchingVenues;
    }

}