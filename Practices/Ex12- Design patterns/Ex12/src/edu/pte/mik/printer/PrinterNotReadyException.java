package edu.pte.mik.printer;

public class PrinterNotReadyException extends Exception {
    private final String printMessage;
    private final String color;

    public String getPrintMessage() {
        return printMessage;
    }

    public String getColor() {
        return color;
    }

    public PrinterNotReadyException(String printMessage, String color) {
        super("Printer is not ready, try again later!");
        this.printMessage = printMessage;
        this.color = color;
    }
}
