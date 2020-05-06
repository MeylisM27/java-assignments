package com.company.io;

import java.io.IOException;

public interface IO {
    void print(String message) throws IOException;
    String getString(String label) throws IOException;
    Integer getInteger(String label) throws IOException;
    Double getDouble(String label) throws IOException;
    void close() throws IOException;
}