public class Ticket {
    private int ID;
    private Place place;
    private boolean valid;

    public Ticket(int ID, Place place) {
        this.ID = ID;
        this.place = place;
        valid = true;
    }

    public Place getPlace() {
        return place;
    }

    public void printTicket() {
        System.out.println("___________________________________");
        System.out.println("Match: " + place.getMatch());
        System.out.println("Sector: " + place.getSector());
        System.out.println("Row: " + place.getRow());
        System.out.println("Place number: " + place.getNumber());
        System.out.println("Price " + place.getPrice());
        System.out.println("Ticket ID:" + ID);
        System.out.println("___________________________________");
    }

    public boolean isValid() {
        return valid;
    }

    public void notValid() {
        valid = false;
    }
}
