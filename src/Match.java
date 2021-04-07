import java.util.ArrayList;
import java.util.List;

public class Match {
    private List<Place> places;
    private int ID;
    private String name;

    Match(int ID, String name, List<Place> places) {
        this.ID = ID;
        this.name = name;
        this.places = new ArrayList<>(places);
        for (int i = 0; i < places.size(); i++) {
            places.get(i).setMatch(name);
        }
    }

    public String getName() {
        return name;
    }

    public List<Place> getPlaces() {
        return places;
    }

    public void writeMatch() {
        System.out.println("id:" + ID + " " + name);
    }

    public void writePlaces() {
        for (Place place: places) {
            place.writePlace();
        }
    }
}
