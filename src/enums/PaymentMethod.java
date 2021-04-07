package enums;

public enum PaymentMethod {
    CARD,
    CASH;

    public static PaymentMethod of(String str) {
        return valueOf(str.toUpperCase());
    }
}
