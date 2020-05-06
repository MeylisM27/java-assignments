package edu.pte.mik.prog2;

import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class ResultFileWriter {

    // stateless method can be static
    // Checked exceptions are not handled in the method,
    // but propagated to the caller
    public static void saveResults(String outFileName, Integer[] marks) throws IOException {
        FileWriter file = new FileWriter(outFileName, false);

        DateFormat formatter = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
        String formattedStringOfCurrentDate = formatter.format(new Date());

        file.write(formattedStringOfCurrentDate);
        file.write("\nExam results\n");

        int total = 0;
        for(int i = 4; i >= 0; i--) {
            file.write(String.format("%d: %d\n", i+1, marks[i]));
            total += marks[i];
        }

        file.write(String.format("Total: %d\n", total));

        file.close();
    }
}
