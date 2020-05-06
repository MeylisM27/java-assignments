package meylis;

import java.util.Scanner;

public class CatalogManager {
    Printer[] printers;

    public CatalogManager(int length) {
        this.printers = new Printer[length];
    }

    public void addPrinter(Printer p, int index) {
        this.printers[index] = p;
    }

    public Printer getPrinter(int index) {
        return this.printers[index];
    }


    public Printer[] filter(int workPieceHeight) {
        this.sort();
        Printer[] filteredPrinters = new Printer[this.printers.length];
        int counter = 0;
        for(int i=0; i<this.printers.length; i++) {
            if(this.printers[i].getWorkpieceHeight() >= workPieceHeight) {
                filteredPrinters[counter++] = this.printers[i];
            }
        }
        return filteredPrinters;
    }

    private void sort() {
        boolean sorted = true;
        for(int i=0; i<this.printers.length-1; i++) {
            sorted = true;
            for(int j=0; j<this.printers.length-i-1; j++) {
                if(this.printers[j].getFilamentPrice() > this.printers[j+1].getFilamentPrice()) {
                    sorted = false;
                    Printer temp = this.printers[j];
                    this.printers[j] = this.printers[j+1];
                    this.printers[j+1] = temp;
                }
            }
            if(sorted) break;
        }
    }
}
