package edu.pte.mik.manager;

import edu.pte.mik.printer.ObservablePrinter;
import edu.pte.mik.printer.Printer;
import edu.pte.mik.printer.PrinterNotReadyException;

import java.util.ArrayList;

public class PrintManager implements Observer, Printer {
    private final ObservablePrinter printer;
    private final ArrayList<PrintJob> jobs = new ArrayList<>();

    public int getJobCount() {
        return jobs.size();
    }

    public PrintJob getJob(int index) {
        if(index >=0 && index < jobs.size()) {
            return jobs.get(index);
        }
        return null;
    }

    public PrintManager(ObservablePrinter printer) {
        this.printer = printer;
        this.printer.attach(this);
    }

    @Override
    public void print(String message, String color) {
        try {
            printer.print(message, color);
        } catch(PrinterNotReadyException ex) {
            jobs.add(new PrintJob(message, color));
            System.out.println("Print job stored!");
        }
    }

    @Override
    public boolean isActive() {
        return true;
    }

    @Override
    public void update(Observable source) {
        if(printer.isActive()) {
            if (jobs.size() > 0) {
                PrintJob oldestJob = jobs.get(0);
                print(oldestJob.getMessage(), oldestJob.getColor());
                jobs.remove(0);
            }
        }
    }
}
