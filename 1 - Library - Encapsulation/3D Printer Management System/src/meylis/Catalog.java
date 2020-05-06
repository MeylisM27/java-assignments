package meylis;

import java.util.Scanner;

public class Catalog {
    private CatalogManager catalogManager;
    private int numberOfPrinters;

    public Catalog() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("How many printers do you want to add: ");
        numberOfPrinters = scanner.nextInt();
        this.catalogManager = new CatalogManager(numberOfPrinters);
        for(int i=0; i<numberOfPrinters; i++) {
            System.out.println("#"+(i+1));
            catalogManager.addPrinter(registerPrinter(), i);
        }
    }

    public void print() {
        System.out.println("\n------------PRINTERS-----------");
        for(int i=0; i<numberOfPrinters; i++) {
            System.out.println("-------------- #" + (i+1) +" -------------");
            printFormatter(catalogManager.getPrinter(i));
        }
    }

    private Printer registerPrinter() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Type: ");
        String type = scanner.nextLine();
        System.out.print("Workpiece Height(in cm): ");
        int workpieceHeight = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Filament Price(HUF/m): ");
        int filamentPrice = scanner.nextInt();
        scanner.nextLine();
        return PrinterFactory.createPrinter(type, workpieceHeight, filamentPrice);
    }

    public void filter() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nEnter the Workpiece Height to filter: ");
        int height = scanner.nextInt();
        Printer[] filtered = catalogManager.filter(height);
        for(int i=0; i<numberOfPrinters; i++) {
                if(filtered[i] != null)  {
                    System.out.println("------------------");
                    printFormatter(filtered[i]);
                }
        }
    }

    public void printFormatter(Printer p) {
        System.out.printf("Type: %s\nWorkpiece Height: %d cm\nFilament Price(HUF/m): %d HUF\nIP Adress: %s\n",p.getType(), p.getWorkpieceHeight(), p.getFilamentPrice(), p.getIpAddress());
    }
}
