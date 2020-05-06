package edu.pte.mik.prog2;

import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Log {
    private String filePathWithName;
    private int logLevel;
    /*
        Log levels:
            1-Fatal
            2-Error
            3-Warning
            4-Info
            5-Debug
     */

    public int getLogLevel() {
        return logLevel;
    }

    /*
        when this method is public, log level can be changed, but developer has to remember
        meaning of log levels. Instead of that, separate, exactly named methods are created
        to publish options to set log level to all possible values
        -> see "Level specific setters" region

        in the setter, input validation is implemented
     */
    private void setLogLevel(int logLevel) {
        if(logLevel >=1 && logLevel <=5) {
            this.logLevel = logLevel;
        }
    }

    public String getFilePathWithName() {
        return filePathWithName;
    }

    public void setFilePathWithName(String filePathWithName) {
        this.filePathWithName = filePathWithName;
    }

    public Log(String fileNameWithPath, int logLevel) {
        this.filePathWithName = fileNameWithPath;
        this.logLevel = logLevel;
        info("---------- logger instance created ----------");
    }

    // constructor override
    // calls specific constructor with default value
    public Log(String fileNameWithPath) {
        this(fileNameWithPath, 4);
    }

    /*
        when this method is public, logging can be used, but developer has to remember
        meaning of log levels. Instead of that, separate, exactly named methods are created
        to publish log entry creation options on all possible levels
        -> see "Level specific entry creation methods" region

        Exceptions should not be handled in Log class, because logging error occurred, so
        no chance to log it, therefore would be suppressed
     */
    private void write(String message, int messageLogLevel) {
        if(messageLogLevel <= logLevel) {
            try {
                writeMessage(message, messageLogLevel);
            }
            catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    /*
        FileWriter exception sources and reasons:
            - constructor could throw IOException when unable to open file
                - file does not exist
                - file resource is reserved by other application
                - hardware error
            - write could throw IOException when unable to write content to file
                - disk is full
                - hardware error
            - close could throw IOException when unable to release file resource
                - file not opened
                - file already closed

        To handle exceptions in the caller, mark method with throws keyword
     */
    private void writeMessage(String message, int level) throws IOException {
        FileWriter file = new FileWriter(filePathWithName, true);

        DateFormat formatter = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
        file.write(String.format("%s [L%d] %s\n",
                formatter.format(new Date()),
                level,
                message)
        );

        file.close();
    }

    /*
        You can make foldable code regions like
            - Level specific setters
            - Level specific entry creation methods

        by placing region definer line comments at the beginning and at the end of the
        region:
            //region <Region title>
            //endregion
        in such a case, editor makes these regions able to be folded and shows only the region title
        this would make the code more readable

        For this:
            - highlight the code wanted to fold
            - press Ctrl+Alt+T hotkey to show "Surround with" menu
            - select "region...endregion comments" option
     */

    //region Level specific setters
    public void setFatalLevel() {
        setLogLevel(1);
    }

    public void setErrorLevel() {
        setLogLevel(2);
    }

    public void setWarningLevel() {
        setLogLevel(3);
    }

    public void setInfoLevel() {
        setLogLevel(4);
    }

    public void setDebugLevel() {
        setLogLevel(5);
    }
    //endregion

    //region Level specific entry creation methods

    /*
        Methods call write, but they do not receive IOException from there,
        because write does process if any occurs
     */

    public void fatal(String message) {
        write(message, 1);
    }

    public void error(String message) {
        write(message, 2);
    }

    public void warning(String message) {
        write(message, 3);
    }

    public void info(String message) {
        write(message, 4);
    }

    public void debug(String message) {
        write(message, 5);
    }
    //endregion
}
