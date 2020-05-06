package edu.pte.mik.prog2;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.NotSerializableException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Base64;

public class ExamEvaluator {

    Log logger;
    ArrayList<Exam> exams;
    Integer[] marks;

    public void createMark(String dataFileName, String outFileName, String logFilenName) {
        //Setting log creation parameters
        logger = new Log(logFilenName);
        logger.setDebugLevel();

        logger.info("Reading exams");
        exams = new ArrayList<>();
        // Checked exception wanted to be handled here
        // to have the option to log them
        // therefore propagated by throws keyword
        try {
            exams = ExamFileReader.read(dataFileName);
        } catch ( IOException ex) {
            System.out.println("File read error occurred!");
            System.out.println(ex.getMessage());
            logger.fatal(String.format("File read error: %s", ex.getMessage()));
        }

        logger.info("Evaluating exams");
        marks = evaluateExams(exams);

        logger.info("Saving marks");
        // Checked exception wanted to be handled here
        // to have the option to log them
        // therefore propagated by throws keyword
        try {
            ResultFileWriter.saveResults(outFileName, marks);
        } catch ( IOException ex) {
            System.out.println("File write error occurred!");
            System.out.println(ex.getMessage());
            logger.error(String.format("File write error: %s", ex.getMessage()));
        }

        try {
            String defaultJson = defaultBinarySerialization();
            System.out.print("Default serialization: ");
            System.out.println(defaultJson);
        }
        catch(NotSerializableException e) {
            // If serializable object is not marked with Serializable interface,
            // this exception has been risen
            System.out.println("Object not serializable!");
            logger.error("Serialization error: Object not serializable");
        }
        catch (IOException ex) {
            System.out.println("Serialization error occurred!");
            System.out.println(ex.getMessage());
            logger.error(String.format("Serialization error: %s", ex.getMessage()));
        }

        jsonSerialization();
    }

    private String defaultBinarySerialization() throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream( baos );
        oos.writeObject( exams );
        oos.close();
        String stateString = Base64.getEncoder().encodeToString(
                baos.toByteArray()
        );
        return stateString;
    }

    private void jsonSerialization() {
        // first serialize method is called
        // because parameter type exactly matches formal parameter type
        logger.info("Serializing exams");
        String examsJson = Serializer.serialize(exams);
        System.out.println(examsJson);
        logger.debug(examsJson);

        // second serialize method is called
        // because parameter type does not matches formal parameter type of any overloads
        // but can be implicitly casted to formal parameter type of second
        logger.info("Serializing marks");
        String marksJson = Serializer.serialize(marks);
        System.out.println(marksJson);
        logger.debug(marksJson);
    }

    private Integer[] evaluateExams(ArrayList<Exam> exams) {
        Integer[] marks = new Integer[5];
        for(int i=0; i<5; i++)marks[i] = 0;

        for (Exam e : exams) {
            e.setMark(createMark(e.getResult()));
            marks[e.getMark() - 1] += 1;
        }

        return marks;
    }

    private static Integer createMark(Integer percent) {
        if(percent <= 50)return 1;
        if(percent <= 65)return 2;
        if(percent <= 80)return 3;
        if(percent <= 90)return 4;
        return 5;
    }
}
