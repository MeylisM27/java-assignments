package meylis;

import java.util.Scanner;

public class Library {
    private LibraryManager libraryManager;
    private int count;

    Library() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("How many books do you want to add: ");
        count = scanner.nextInt();
        libraryManager = new LibraryManager(count);
        for(int i=0; i<count; i++) {
            System.out.println("#"+(i+1));
            libraryManager.addBook(initBook(), i);
        }
    }

    private Book initBook() {
        String title, publisher, author;
        int pageNumber;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Title: ");
        title = scanner.nextLine();
        System.out.print("Author: ");
        author = scanner.nextLine();
        System.out.print("Page number: ");
        pageNumber = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Publisher: ");
        publisher = scanner.nextLine();
        return BookFactory.createBook(title, author, pageNumber, publisher);
    }

    public void print() {
        System.out.println("\n--------BOOKS-----------");
        for(int i=0; i<this.count; i++) {
            System.out.println("--------- #" + (i+1) + " -----------");
            printFormatter(this.libraryManager.getBook(i));
        }
    }

    public void orderByAuthor() {
        libraryManager.sortByAuthor();
        this.print();
    }

    public void orderByTitle() {
        libraryManager.sortByTitle();
        this.print();
    }

    private void printFormatter(Book b) {
        System.out.printf("ID: %s\nTitle: %s\nAuthor: %s\nPage number: %d\nPublisher: %s\n", b.getID(), b.getTitle(), b.getAuthor(), b.getPageNumber(), b.getPublisher());
    }
}
