import enums.PaymentMethod;

public class ReturningMoney {
    private IBank bank;

    public ReturningMoney() {
        bank = new Bank();
    }

    public boolean isReturnValid(Ticket ticket) {
        return bank.isReturnValid(ticket);
    }

    public void concludeReturn(Ticket ticket) throws Exception {
        if (isReturnValid(ticket)) {
            System.out.println("Choose method to return: card/cash");
            PaymentMethod pm;
            try {
                pm = PaymentMethod.of(TerminalScanner.getString());
            }
            catch (Exception e) {
                throw new Exception("Invalid method");
            }

            switch (pm) {
                case CARD:
                    System.out.println("Enter card number:");
                    String cardNumber = TerminalScanner.getString();
                    System.out.println("Enter card holder:");
                    String cardHolder = TerminalScanner.getString();
                    System.out.println("Enter CVS:");
                    String cvs = TerminalScanner.getString();

                    if (bank.isCardValid(cardNumber, cardHolder, cvs)) {
                        bank.concludeReturn(ticket.getPlace().getPrice(), cardNumber, cardHolder, cvs);
                        System.out.println("Money returned");
                    }
                    else {
                        throw new Exception("Card is not valid");
                    }
                    break;
                case CASH:
                    System.out.println("Returning: " + ticket.getPlace().getPrice());
                    System.out.println("Money returned");
                    break;
            }
        }
        else {
            throw new Exception("Return is not valid");
        }
    }
}
