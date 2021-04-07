public class Bank implements IBank {
    @Override
    public boolean isCardValid(String cardNumber, String cardHolder, String cvs) {
        return true;
    }

    @Override
    public boolean isCardValid(double sum, String cardNumber, String cardHolder, String cvs) {
        return true;
    }

    @Override
    public boolean isReturnValid(Ticket ticket) {
        return true;
    }

    @Override
    public void concludePayment(double sum, String cardNumber, String cardHolder, String cvs) {
        return;
    }

    @Override
    public void concludeReturn(double sum, String cardNumber, String cardHolder, String cvs) {
        return;
    }
}
