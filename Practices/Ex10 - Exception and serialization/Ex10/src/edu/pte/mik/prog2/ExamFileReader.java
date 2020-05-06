package edu.pte.mik.prog2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ExamFileReader {

    // stateless method can be static
    // Checked exceptions are not handled in the method,
    // but propagated to the caller
    public static ArrayList<Exam> read(String fileName) throws FileNotFoundException {
        ArrayList<Exam> exams = new ArrayList<>();

        File textFile = new File(fileName);
        Scanner textScanner = new Scanner(textFile);
        while (textScanner.hasNextLine()) {
            String line = textScanner.nextLine();

            String[] data = line.split(";");

            Exam newExam = new Exam(
                    data[0],
                    data[1],
                    Integer.parseInt(data[2]),
                    Integer.parseInt(data[3])
            );

            exams.add(newExam);
        }
        textScanner.close();

        return exams;
    }
}
