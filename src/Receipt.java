public class Receipt {
    Payment payment;
    Place place;
    int transactionID;

    public Receipt(Payment payment, Place place, int transactionID) {
        this.place = place;
        this.payment = payment;
        this.transactionID = transactionID;
    }

    public void printReceipt() {
        System.out.println("______________________________");
        System.out.println("Transaction ID: " + transactionID);
        System.out.println(payment.getTime());
        System.out.println("Payment method: " + payment.getMethod());
        System.out.println("______________________________");

        if (place.isAbonement()) {
            System.out.println("Abonement");
        }
        else {
            System.out.println("Place for " + place.getMatch());
        }
        System.out.println("Sector: " + place.getSector());
        System.out.println("Place ID: " + place.getID());
        System.out.println("Row: " + place.getRow());
        System.out.println("Number: " + place.getNumber());
        System.out.println("_______________________________");
        System.out.println("Price: " + place.getPrice());
    }
}
