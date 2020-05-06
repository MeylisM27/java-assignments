package edu.pte.mik.ui;

import edu.pte.mik.manager.PrintManager;
import edu.pte.mik.printer.HandPrinter;
import edu.pte.mik.printer.PrinterNotReadyException;

import java.util.Scanner;

public class MainConsoleForm implements ConsoleForm {
    Scanner consoleScanner;
    PrintManager printManager;

    public MainConsoleForm() {
        consoleScanner = new Scanner(System.in);
        printManager = new PrintManager(HandPrinter.getInstance());
    }

    @Override
    public void show() {
        String selection;

        do {
            showMainMenu();
            System.out.print("Enter selection: ");
            selection = consoleScanner.nextLine();
            if(selection.equalsIgnoreCase("p")){
                printWithPrinter();
            }
            if(selection.equalsIgnoreCase("r")){
                HandPrinter.getInstance().setActive(true);
            }
            if(selection.equalsIgnoreCase("m")){
                printWithManager();
            }
            if(selection.equalsIgnoreCase("l")){
                listJobs();
            }
        }while(!selection.equalsIgnoreCase("x"));
    }

    private void showMainMenu() {
        System.out.println("---=== Main menu ===---");
        System.out.println("P - Print message with a color directly with printer");
        System.out.println("R - Mark printer that writer is ready");
        System.out.println("M - Print message with a color using print manager");
        System.out.println("L - List print jobs");
        System.out.println("X - Exit");
    }

    private void printWithPrinter() {
        PrintForm printForm = new PrintForm();
        printForm.show();
        try {
            HandPrinter.getInstance().print(printForm.getMessage(), printForm.getColor());
        }catch (PrinterNotReadyException ex) {
            System.out.println("!!!!!! " + ex.getMessage());
        }
    }

    private void printWithManager() {
        PrintForm printForm = new PrintForm();
        printForm.show();
        printManager.print(printForm.getMessage(), printForm.getColor());
    }

    private void listJobs() {
        if(printManager.getJobCount() > 0) {
            for (int i = 0; i < printManager.getJobCount(); i++) {
                System.out.println(printManager.getJob(i));
            }
        }
        else {
            System.out.println("Print queue is empty");
        }
    }

}
