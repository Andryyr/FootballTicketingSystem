import java.util.ArrayList;
import java.util.List;

public class Stadium {
    private MatchCatalog matchCatalog;
    private List<Place> abonementPlaces;
    private List<Place> emptyStadium;

    public Stadium() {
        emptyStadium = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                emptyStadium.add(new Place(emptyStadium.size(), "A", i, j, false));
            }
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                emptyStadium.add(new Place(emptyStadium.size(), "B", i, j, false));
            }
        }

        abonementPlaces = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                abonementPlaces.add(new Place(abonementPlaces.size(), "Fan", i, j, true));
            }
        }

        matchCatalog = new MatchCatalog(emptyStadium);
        matchCatalog.addMatch("Krasnodar vs Orenburg");
        matchCatalog.addMatch("Gasovik vs Krasnodar");
    }

    public List<Place> getAbonementPlaces() {
        return abonementPlaces;
    }

    public MatchCatalog getMatchCatalog() {
        return matchCatalog;
    }

    public void writeAbonementPlaces() {
        for (Place place: abonementPlaces) {
            place.writePlace();
        }
    }
}
