package edu.pte.mik.printer;

public interface Printer {
    void print(String message, String color) throws PrinterNotReadyException;
    boolean isActive();
}
