package meylis;

public class Printer {
    private String type;
    private int workpieceHeight;
    private int filamentPrice;
    private String ipAddress;

    public String getType() {
        return type;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public Printer(String type, int workpieceHeight, int filamentPrice, String ipAddress) {
        this.type = type;
        this.workpieceHeight = workpieceHeight;
        this.filamentPrice = filamentPrice;
        this.ipAddress = ipAddress;
    }

    public int getWorkpieceHeight() {
        return workpieceHeight;
    }

    public int getFilamentPrice() {
        return filamentPrice;
    }
}
