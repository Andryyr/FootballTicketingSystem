public interface IBank {
    boolean isCardValid(String cardNumber, String cardHolder, String cvs);
    boolean isCardValid(double sum, String cardNumber, String cardHolder, String cvs);
    boolean isReturnValid(Ticket ticket);
    void concludePayment(double sum, String cardNumber, String cardHolder, String cvs);
    void concludeReturn(double sum, String cardNumber, String cardHolder, String cvs);
}
