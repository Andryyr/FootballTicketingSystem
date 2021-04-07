import java.util.ArrayList;
import java.util.List;

public class AccountingSystem implements IAccountingSystem {
    List<Ticket> ticketsDB;
    List<Integer> transactionsID;
    List<Payment> transactionsPayments;
    List<Place> transactionsPlaces;

    public AccountingSystem() {
        ticketsDB = new ArrayList<>();
        transactionsID = new ArrayList<>();
        transactionsPayments = new ArrayList<>();
        transactionsPlaces = new ArrayList<>();
    }

    @Override
    public int addCompletedTransaction(Payment payment, Place place) {
        transactionsID.add(transactionsID.size());
        transactionsPayments.add(payment);
        transactionsPlaces.add(place);
        return transactionsID.size() - 1;
    }

    @Override
    public Ticket addTicket(Place place) {
        ticketsDB.add(new Ticket(ticketsDB.size(), place));
        return ticketsDB.get(ticketsDB.size() - 1);
    }

    @Override
    public List<Ticket> getTickets() {
        return ticketsDB;
    }
}
