package edu.pte.mik.prog2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        // Working directory is set in Run/Debug configuration settings
        // relative path has to be specified to the exams.txt data file
        String dataFileName = ".\\Data\\exams.txt";
        String outFileName = ".\\Data\\results.txt";
        String logFileName = ".\\Data\\log.txt";

        // Test method to present reading full contents of a text file
        // Reads all lines of the data file IN ONE STEP, then prints from a List<String>
        // handles possible exceptions -> try to use invalid data file name
        System.out.println("==================== read full content example");
        boolean success = readFullContentOfFile(dataFileName);

        // Test method to present reading contents of a text file line by line
        //Reads and prints all lines of the data file BY LINES
        //handles possible exceptions -> try to use invalid data file name
        if(success) {
            System.out.println("==================== read by lines example");
            success = readLinesOfFile(dataFileName);
        }

        /*
            Reads and parses a CSV formatted text file into list of objects
            than uses the list to summarize statistics and writes statistics into a text file
            finally creates JSON text serialization of data with overrides

            Meanwhile creates a log file to let the full process be traceable
                - writes fatal message on file read failure
                    (change source file name to to a non-existent)
                - writes error message on file write failure
                    (change destination file path to to a non-existent)
                - writes info messages to the log: to trace process
                - writes debug messages to the log: to check operation outputs
            Try switching log levels to see benefits:
                - lower level create shorter log
                - higher level creates more detailed log
            You can also put log lines into the application
         */
        System.out.println("==================== Exam processor");
        new ExamEvaluator().createMark(dataFileName, outFileName, logFileName);
    }

    private static boolean readFullContentOfFile(String fileName) {
        try {
            // full content had been read into a list of lines
            List<String> content = Files.readAllLines(
                    Paths.get(fileName),
                    StandardCharsets.UTF_8
            );

            for(String s : content){
                System.out.println(s);
            }

            return true;
        } catch (IOException e) {
            System.out.println("Error occurred in test method: readFullContentOfFile!");
            System.out.println(e.getMessage());
        }
        return false;
    }

    private static boolean readLinesOfFile(String fileName) {
        try {
            //Get file resource
            File textFile = new File(fileName);
            //Create a scanner to read the file
            Scanner textScanner = new Scanner(textFile);

            //Read file while it has new lines
            while (textScanner.hasNextLine()) {
                String line = textScanner.nextLine();

                System.out.println(line);
            }

            //close file, release resource
            textScanner.close();

            return true;
        } catch (FileNotFoundException e) {
            System.out.println("Error occurred in test method: readLinesOfFile!");
            System.out.println(e.getMessage());
        }
        return false;
    }

}
