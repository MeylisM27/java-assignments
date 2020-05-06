package com.company.io;

import java.io.IOException;
import java.util.Scanner;

public class ConsoleIO implements IO {
    Scanner consoleScanner;

    public ConsoleIO() {
        consoleScanner = new Scanner(System.in);
    }

    @Override
    public void print(String message) {
        System.out.println(message);
    }

    @Override
    public String getString(String label) throws IOException {
        System.out.println(label);
        String enteredLine = consoleScanner.nextLine();
        return enteredLine;
    }

    @Override
    public Integer getInteger(String label) throws IOException {
        System.out.println(label);
        String enteredLine = consoleScanner.nextLine();
        if(enteredLine.equalsIgnoreCase("")) return null;
        try {
            return Integer.valueOf(enteredLine);
        }catch(NumberFormatException ex) {
            throw new IOException("Could not read Integer!", ex);
        }
    }

    @Override
    public Double getDouble(String label) throws IOException {
        System.out.println(label);
        String enteredLine = consoleScanner.nextLine();
        try {
            return Double.valueOf(enteredLine);
        }catch(NumberFormatException ex) {
            throw new IOException("Could not read Double!", ex);
        }
    }

    @Override
    public void close() {
        // control is not a reserved resource,
        // no need to explicitly close it
    }


}