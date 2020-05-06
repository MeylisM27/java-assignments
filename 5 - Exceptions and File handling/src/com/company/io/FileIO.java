package com.company.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileIO implements IO {
    BufferedReader reader;

    public FileIO(String fileName) {
        try {
            reader =
                    new BufferedReader(
                            new FileReader(fileName)
                    );
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void print(String message) {
        // No print, when reading from file
    }

    @Override
    public String getString(String label) throws IOException {
        return reader.readLine();
    }

    @Override
    public Integer getInteger(String label) throws IOException {
        try {
            String enteredLine = reader.readLine();
            return Integer.valueOf(enteredLine);
        }catch(NumberFormatException ex) {
            throw new IOException("Could not read Integer!", ex);
        }
    }

    @Override
    public Double getDouble(String label) throws IOException {
        try {
            String enteredLine = reader.readLine();
            return Double.valueOf(enteredLine);
        }catch(NumberFormatException ex) {
            throw new IOException("Could not read Double!", ex);
        }
    }

    @Override
    public void close() throws IOException {
        reader.close();
    }
}