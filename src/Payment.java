import enums.PaymentMethod;
import enums.PaymentStatus;

import java.util.Date;

public class Payment {
    private PaymentStatus status;
    private PaymentMethod method;
    private Date time;

    public Payment() {
        time = new Date();
        status = PaymentStatus.Started;
    }

    public boolean isSuccess() {
        if (status == PaymentStatus.Success) {
            return true;
        }
        else {
            return false;
        }
    }

    public void conclude(PaymentMethod pm, Place place) {
        method = pm;
        switch (method) {
            case CASH:
                double price = place.getPrice();
                double deposit = 0;
                System.out.println("Insert bills. -1 to stop");
                while (deposit < price) {
                    double bill = TerminalScanner.getBill();
                    if (bill == -1) {
                        break;
                    }
                    else {
                        deposit += bill;
                    }
                }
                if (deposit < price) {
                    status = PaymentStatus.Failed;
                    System.out.println("Returning: " + deposit);
                }
                else {
                    double change = deposit - price;
                    status = PaymentStatus.Success;
                    System.out.println("Success");
                    System.out.println("Change: " + change);
                }
                break;
            case CARD:
                System.out.println("Card number:");
                String cardNumber = TerminalScanner.getString();
                System.out.println("Card holder:");
                String cardHolder = TerminalScanner.getString();
                System.out.println("CVS");
                String cvs = TerminalScanner.getString();
                IBank bank = new Bank();
                if (bank.isCardValid(place.getPrice(), cardNumber, cardHolder, cvs)) {
                    bank.concludePayment(place.getPrice(), cardNumber, cardHolder, cvs);
                    status = PaymentStatus.Success;
                }
                else {
                    status = PaymentStatus.Failed;
                    System.out.println("This card is not valid for this transaction");
                }
                break;
        }
    }

    public void writePayment(Place place) {
        if (place.isAbonement()) {
            System.out.println("Abonenemt");
        }
        else {
            System.out.println("Place for " + place.getMatch());
        }
        place.writePlace();
        System.out.println("_______________________________________");
        System.out.println("Price: " + place.getPrice());
    }

    public String getTime() {
        return time.toString();
    }

    public String getMethod() {
        return method.toString();
    }
}
