import java.util.Date;

public class BuyingTicket {
    private int reserveDuration;
    private Date currentTime;
    private ITicketResereSystem TRS;

    private PlaceToReserve ptr;

    public BuyingTicket(ITicketResereSystem TRS) {
        this.TRS = TRS;
        reserveDuration = 300;
        currentTime = new Date();
    }

    public void initialize() throws Exception {
        if (TRS.areMatchesAvailable()) {
            MatchCatalog matches = TRS.getMatches();
            System.out.println("Available matches:");
            matches.writeMatches();

            System.out.println("Enter match ID");
            int matchID = TerminalScanner.getID();
            if (matchID < 0 || matchID >= matches.getMatches().size()){
                throw new Exception("Wrong ID");
            }

            if (TRS.arePlacesAvailable(matchID)) {
                System.out.println("Available places:");
                matches.getMatches().get(matchID).writePlaces();

                System.out.println("Enter place ID");
                int placeID = TerminalScanner.getID();

                if (placeID < 0 || placeID >= matches.getMatches().get(matchID).getPlaces().size()) {
                    throw new Exception("Wrong ID");
                }

                ptr = new PlaceToReserve(matchID, placeID);
                if (TRS.isPlaceAvailable(ptr)) {
                    TRS.reservePlace(ptr, currentTime, reserveDuration);
                }
                else {
                    throw new Exception("Place is no longer available");
                }
            }
            else {
                throw new Exception("There are not available places for this match");
            }
        }
        else {
            throw new Exception("Matches are not available");
        }
    }

    public void cancel() {
        TRS.freePlace(ptr);
    }

    public void conclude() {
        TRS.reservePlace(ptr);
    }

    public PlaceToReserve getPtr() {
        return ptr;
    }
}
