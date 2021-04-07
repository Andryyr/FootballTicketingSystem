import java.util.List;
import java.util.Date;

public interface ITicketResereSystem {
    List<Place> getAbonementPlaces();
    void writeAbonementPlaces();
    boolean areAbonementsAvailable();
    boolean isAbonementAvailable(int ID);
    boolean areMatchesAvailable();
    void reserveAbonement(int ID, Date currentTime, int reserveDuration);
    void reservePlace(int ID);
    void freePlace(int ID);

    void freePlace(Place place);

    void reservePlace(Place place);

    MatchCatalog getMatches();

    boolean arePlacesAvailable(int matchID);

    boolean isPlaceAvailable(PlaceToReserve ptr);

    void reservePlace(PlaceToReserve ptr, Date currentTime, int reserveDuration);

    void freePlace(PlaceToReserve ptr);

    void reservePlace(PlaceToReserve ptr);

    Place getPlace(PlaceToReserve ptr);

    Place getAbonement(int placeID);
}
