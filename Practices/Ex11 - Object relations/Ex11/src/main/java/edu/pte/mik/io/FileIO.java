package edu.pte.mik.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

// an IO module to handle file based labeled input
// this is a resource reserving class,
// close has to be called when resource is no more required
// the main aim is to read data from a file having specific structure
// therefore no need for label presentation
public class FileIO implements IOModule {
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
