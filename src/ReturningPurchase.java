import java.util.List;

public class ReturningPurchase {
    IAccountingSystem AS;
    ITicketResereSystem TRS;
    List<Ticket> tickets;

    public ReturningPurchase(IAccountingSystem AS, ITicketResereSystem TRS) {
        tickets = AS.getTickets();
        this.TRS = TRS;
    }

    public boolean isTicketValid(int ID) {
        return tickets.get(ID).isValid();
    }

    public Place identify(int ID) {
        return tickets.get(ID).getPlace();
    }

    public Ticket getTicket(int ID) {
        return tickets.get(ID);
    }

    public void cancel(Place place) {
        TRS.freePlace(place);
    }

    public void conclude(Place place) {
        TRS.reservePlace(place);
    }
}
