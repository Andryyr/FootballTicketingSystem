import enums.PaymentMethod;

public class Terminal {
    public static void main(String[] args) {
        ITicketResereSystem TRS = new TicketReserveSystem();
        IAccountingSystem AS = new AccountingSystem();


        while (true) {
            System.out.println("Insert operation:\n" +
                    "1 - Buy ticket\n" +
                    "2 - Buy abonement\n" +
                    "3 - Return ticket/abonement\n" +
                    "Any other - cancle");
            try {
                String op = TerminalScanner.getString();
                switch (op) {
                    case "1":
                        BuyingTicket buyingTicket = new BuyingTicket(TRS);
                        buyingTicket.initialize();

                        Payment payment = new Payment();
                        Place place = TRS.getPlace(buyingTicket.getPtr());

                        payment.writePayment(place);
                        while (true) {
                            System.out.println("Do you accept? y/n");
                            String ans = TerminalScanner.getString();
                            if ("y".equals(ans)) {
                                System.out.println("Select a payment method: card/cash");
                                String method = TerminalScanner.getString();
                                payment.conclude(PaymentMethod.of(method), place);

                                if (payment.isSuccess()) {
                                    buyingTicket.conclude();
                                    int transactionID = AS.addCompletedTransaction(payment, place);
                                    Receipt receipt = new Receipt(payment, place, transactionID);
                                    Ticket ticket = AS.addTicket(place);

                                    System.out.println("Receipt:");
                                    receipt.printReceipt();
                                    System.out.println("Ticket:");
                                    ticket.printTicket();
                                }
                                else {
                                    buyingTicket.cancel();
                                    System.out.println("Failed");
                                }
                                break;
                            }
                            else if ("n".equals(ans)) {
                                buyingTicket.cancel();
                                System.out.println("Canceled");
                                break;
                            }
                        }
                        break;
                    case "2":
                        BuyingAbonement buyingAbonement = new BuyingAbonement(TRS);
                        buyingAbonement.initialize();

                        Place placeAbonement = TRS.getAbonement(buyingAbonement.getPlaceID());
                        Payment payment1 = new Payment();
                        payment1.writePayment(placeAbonement);

                        while (true) {
                            System.out.println("Do you accept? y/n");
                            String ans = TerminalScanner.getString();
                            if ("y".equals(ans)) {
                                System.out.println("Select a payment method: card/cash");
                                String method = TerminalScanner.getString();
                                payment1.conclude(PaymentMethod.of(method), placeAbonement);

                                if (payment1.isSuccess()) {
                                    buyingAbonement.conclude();
                                    int transactionID = AS.addCompletedTransaction(payment1, placeAbonement);
                                    Receipt receipt = new Receipt(payment1, placeAbonement, transactionID);
                                    Ticket ticket = AS.addTicket(placeAbonement);

                                    System.out.println("Receipt:");
                                    receipt.printReceipt();
                                    System.out.println("Abonement:");
                                    ticket.printTicket();
                                }
                                else {
                                    buyingAbonement.cancel();
                                    System.out.println("Failed");
                                }
                                break;
                            }
                            else if ("n".equals(ans)) {
                                buyingAbonement.cancel();
                                System.out.println("Canceled");
                                break;
                            }
                        }
                        break;
                    case "3":
                        System.out.println("Insert your ticketID:");
                        int ticketID = TerminalScanner.getID();

                        ReturningPurchase returningPurchase = new ReturningPurchase(AS, TRS);
                        ReturningMoney returningMoney = new ReturningMoney();

                        if (returningPurchase.isTicketValid(ticketID)) {
                            Ticket ticket = returningPurchase.getTicket(ticketID);
                            returningMoney.concludeReturn(ticket);
                            returningPurchase.cancel(ticket.getPlace());
                            ticket.notValid();
                            System.out.println("Completed");
                        }
                        else {
                            System.out.println("Invalid ticket");
                        }
                        break;
                    default:
                        return;
                }
            }
            catch (Exception e) {
                System.out.println(e.toString());
            }
        }
    }
}
