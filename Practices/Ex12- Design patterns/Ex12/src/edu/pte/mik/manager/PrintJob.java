package edu.pte.mik.manager;

public class PrintJob {
    private final String message;
    private final String color;

    public String getMessage() {
        return message;
    }

    public String getColor() {
        return color;
    }

    public PrintJob(String message, String color) {
        this.message = message;
        this.color = color;
    }

    @Override
    public String toString() {
        return "PrintJob{" +
                "message='" + message + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}
