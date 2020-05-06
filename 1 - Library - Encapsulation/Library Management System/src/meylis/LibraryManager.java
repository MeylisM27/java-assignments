package meylis;

import java.util.Scanner;

public class LibraryManager {
    private Book[] books;

    LibraryManager(int i) {
        books = new Book[i];
    }

    public void addBook(Book b, int index) {
        this.books[index] = b;
    }

    public Book getBook(int index) {
        return this.books[index];
    }

    public void sortByTitle() {
        boolean sorted = true;
        for(int i=0; i<books.length; i++) {
            sorted = true;
            for(int j=0; j< books.length-i-1; j++) {
                if(books[j].getTitle().compareToIgnoreCase(books[j+1].getTitle()) > 0) {
                    sorted = false;
                    Book temp = books[j];
                    books[j] = books[j+1];
                    books[j+1] = temp;
                }
            }
            if(sorted) return;
        }
    }

    public void sortByAuthor() {
        boolean sorted = true;
        for(int i=0; i<books.length; i++) {
            sorted = true;
            for(int j=0; j< books.length-i-1; j++) {
                if(books[j].getAuthor().compareToIgnoreCase(books[j+1].getAuthor()) > 0) {
                    sorted = false;
                    Book temp = books[j];
                    books[j] = books[j+1];
                    books[j+1] = temp;
                }
            }
            if(sorted) return;
        }
    }
}
