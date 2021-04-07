public class Place {
    private int ID;
    private String matchName;
    private boolean reserveFlag;
    private boolean abonementFlag;
    private String sector;
    private int row;
    private int number;
    private double price;

    public Place(int ID, String sector, int row, int number, boolean abonement) {
        this.ID = ID;
        this.sector = sector;
        this.row = row;
        this.number = number;
        this.abonementFlag = abonement;
        reserveFlag = false;

        if (abonement) {
            price = 30000.0;
        }
        else {
            price = 2000.0;
        }
    }

    public void setMatch(String match) {
        this.matchName = match;
    }

    public String getMatch() {
        return matchName;
    }

    public String getSector() {
        return sector;
    }

    public int getRow() {
        return row;
    }

    public int getNumber() {
        return number;
    }

    public double getPrice() {
        return price;
    }

    public boolean isAbonement() {
        return abonementFlag;
    }

    public boolean isReserve() {
        return reserveFlag;
    }

    public void reserve() {
        reserveFlag = true;
    }

    public void free() {
        reserveFlag = false;
    }

    public void writePlace() {
        System.out.println("ID:" + ID + "  sector:" + sector + " row:" + row + " number:" + number + (reserveFlag ? "[reserved]" : "[free]"));
    }

    public int getID() {
        return ID;
    }
}
