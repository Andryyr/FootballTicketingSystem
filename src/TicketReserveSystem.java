import java.util.List;
import java.util.Date;

public class TicketReserveSystem implements ITicketResereSystem {
    public Stadium stadium;

    public TicketReserveSystem() {
        this.stadium = new Stadium();
    }

    @Override
    public List<Place> getAbonementPlaces() {
        return stadium.getAbonementPlaces();
    }

    @Override
    public void writeAbonementPlaces() {
        stadium.getAbonementPlaces().forEach(Place::writePlace);
    }

    @Override
    public boolean areAbonementsAvailable() {
        return true;
    }

    @Override
    public boolean isAbonementAvailable(int ID) {
        return true;
    }

    @Override
    public boolean areMatchesAvailable() {
        return true;
    }

    @Override
    public void reserveAbonement(int ID, Date currentTime, int reserveDuration) {
        stadium.getAbonementPlaces().get(ID).reserve();
    }

    @Override
    public void reservePlace(int ID) {
        stadium.getAbonementPlaces().get(ID).reserve();
    }

    @Override
    public void freePlace(int ID) {
        stadium.getAbonementPlaces().get(ID).free();
    }

    @Override
    public void freePlace(Place place) {
        place.free();
    }

    @Override
    public void reservePlace(Place place) {
        place.reserve();
    }

    @Override
    public MatchCatalog getMatches() {
        return stadium.getMatchCatalog();
    }

    @Override
    public boolean arePlacesAvailable(int matchID) {
        return true;
    }

    @Override
    public boolean isPlaceAvailable(PlaceToReserve ptr) {
        return true;
    }

    @Override
    public void reservePlace(PlaceToReserve ptr, Date currentTime, int reserveDuration) {
        stadium.getMatchCatalog().getMatches().get(ptr.getMatchID()).getPlaces().get(ptr.getPlaceID()).reserve();
    }

    @Override
    public void freePlace(PlaceToReserve ptr) {
        stadium.getMatchCatalog().getMatches().get(ptr.getMatchID()).getPlaces().get(ptr.getPlaceID()).reserve();
    }

    @Override
    public void reservePlace(PlaceToReserve ptr) {
        stadium.getMatchCatalog().getMatches().get(ptr.getMatchID()).getPlaces().get(ptr.getPlaceID()).free();
    }

    @Override
    public Place getPlace(PlaceToReserve ptr) {
        return stadium.getMatchCatalog().getMatches().get(ptr.getMatchID()).getPlaces().get(ptr.getPlaceID());
    }

    @Override
    public Place getAbonement(int placeID) {
        return stadium.getAbonementPlaces().get(placeID);
    }
}
