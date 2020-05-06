package meylis;

public class PrinterFactory {
    static private String ipAddress = "192.168.1.";
    static private Integer counter = 0;

    public static Printer createPrinter(String type, int workpieceHeight, int filamentPrice) {
        return new Printer(type, workpieceHeight, filamentPrice, generateIpAdress());
    }

    private static String generateIpAdress() {
        return ipAddress.concat(Integer.toString(counter++));
    }
}
