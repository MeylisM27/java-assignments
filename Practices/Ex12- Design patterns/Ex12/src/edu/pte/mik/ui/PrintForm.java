package edu.pte.mik.ui;

import java.util.Scanner;

public class PrintForm implements ConsoleForm {
    private final Scanner consoleScanner;
    private String message;
    private String color;

    public String getMessage() {
        return message;
    }

    public String getColor() {
        return color;
    }

    public PrintForm() {
        consoleScanner = new Scanner(System.in);
    }

    @Override
    public void show() {
        System.out.print("Message: ");
        message = consoleScanner.nextLine();
        System.out.print("Color: ");
        color = consoleScanner.nextLine();
    }
}
