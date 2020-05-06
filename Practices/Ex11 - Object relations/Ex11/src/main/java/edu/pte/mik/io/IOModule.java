package edu.pte.mik.io;

import java.io.IOException;

// An interface to specify behaviors required from
// Out generic Input/Output modules
//
// Generic behavior:
//  - present label to help exactly know which data is requested
//  - get specific type of data
public interface IOModule {
    void print(String message) throws IOException;
    String getString(String label) throws IOException;
    Integer getInteger(String label) throws IOException;
    Double getDouble(String label) throws IOException;
    void close() throws IOException;
}
