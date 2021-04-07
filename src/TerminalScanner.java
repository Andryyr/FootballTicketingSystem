import java.util.Scanner;

public class TerminalScanner {
    private static final Scanner scanner = new Scanner(System.in);
    public static int getID() {
        return Integer.parseInt(scanner.nextLine());
    }

    public static String getString() {
        return scanner.nextLine();
    }

    public static double getBill() {
        return Double.parseDouble(scanner.nextLine());
    }
}
