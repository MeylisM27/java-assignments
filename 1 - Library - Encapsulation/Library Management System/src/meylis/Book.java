package meylis;

public class Book {
    private String ID;
    private String title;
    private String author;
    private int pageNumber;
    private String publisher;

    public Book(String title, String author, int pageNumber, String publisher, String ID) {
        this.title = title;
        this.author = author;
        this.pageNumber = pageNumber;
        this.publisher = publisher;
        this.ID = ID;
    }

    public String getID() {
        return ID;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public String getPublisher() {
        return publisher;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }
}
