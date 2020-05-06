package com.homework;

import java.util.Scanner;

public class Main {
    final static Integer PUBLICATIONS_NUMBER = 8;

    public static void main(String[] args) {
	    Library myLibrary = new Library(PUBLICATIONS_NUMBER);
	    myLibrary.storePublication(new Book("Outliers","Little Brown", "Malcolm Gladwell", 250 ));
        myLibrary.storePublication(new Book("The Outsiders (review included)","Viking Press", "S. E. Hinton", 128 ));
        myLibrary.storePublication(new Book("Digital Minimalism","Penguin Random House", "Cal Newport", 190 ));
        myLibrary.storePublication(new Journal("Wired","American Magazine", 2019));
        myLibrary.storePublication(new Journal("MIT Technology Review","MIT", 2017));
        myLibrary.storePublication(new Journal("Popular Science, Reviews","Best Publishers", 2018));

        //Search by title
        search(myLibrary);

        //List
        print(myLibrary);
    }

    static public void print(Library l) {
        System.out.println("\n--------- List of all publications ---------");
        for(int i=0; i<l.getIndexCounter(); i++) {
            System.out.println(l.getPublication(i));
        }
        System.out.println("----------------------------------------------\n");
    }

    static public void print(Publication p, int numberOfDays) {
        if(p instanceof Book) {
            System.out.printf("Title: %s, Author: %s, Publisher: %s, Number of pages: %d, Gross price: %d HUF\n", p.getTitle(), ((Book) p).getAuthor(), p.getPublisher(), ((Book) p).getPageNumber(), (Book.baseRentalFee+Book.handlingCost)*numberOfDays);
        } else if(p instanceof Journal) {
            System.out.printf("Title: %s, Publisher: %s, Issue year: %d, Gross price: %d HUF\n", p.getTitle(), p.getPublisher(), ((Journal) p).getIssueYear(), (Journal.baseRentalFee+Journal.handlingCost)*numberOfDays);
        }
    }

    static public void search(Library l) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("For how many days you wanna loan: ");
        Integer days = scanner.nextInt();
        for (Publication p : l.searchByTitle("review")) {
            if(p == null) break;
            print(p, days);
        }
    }
}
