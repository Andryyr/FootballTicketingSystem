public class PlaceToReserve {
    private int matchID;
    private int placeID;

    public PlaceToReserve(int matchID, int placeID) {
        this.matchID = matchID;
        this.placeID = placeID;
    }

    public int getMatchID() {
        return matchID;
    }

    public int getPlaceID() {
        return placeID;
    }
}
