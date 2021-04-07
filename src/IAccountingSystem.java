import java.util.List;

public interface IAccountingSystem {
    int addCompletedTransaction(Payment payment, Place place);
    Ticket addTicket(Place place);
    List<Ticket> getTickets();
}
