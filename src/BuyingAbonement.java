import java.util.List;
import java.util.Date;

public class BuyingAbonement {
    private int reserveDuration;
    Date currentTime;
    ITicketResereSystem TRS;

    private int placeID;

    public BuyingAbonement(ITicketResereSystem TRS) {
        this.TRS = TRS;
        reserveDuration = 300;
        currentTime = new Date();
    }

    public void initialize() throws Exception {
        if (TRS.areAbonementsAvailable()) {
            System.out.println("Available abonements:");
            TRS.writeAbonementPlaces();
            List<Place> places = TRS.getAbonementPlaces();

            System.out.println("Enter abonement ID");
            placeID = TerminalScanner.getID();
            if (placeID < 0 || placeID >= places.size()) {
                throw new Exception("Wrong ID");
            }

            if (TRS.isAbonementAvailable(placeID)) {
                TRS.reserveAbonement(placeID, currentTime, reserveDuration);
            }
            else {
                throw new Exception("Abonement is no longer available");
            }
        }
        else {
            throw new Exception("Abonements are not available");
        }
    }

    public void cancel() {
        TRS.freePlace(placeID);
    }

    public void conclude() {
        TRS.reservePlace(placeID);
    }

    public int getPlaceID() {
        return placeID;
    }
}
