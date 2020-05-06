package com.homework;

public class Book extends Publication {
    private String author;
    private Integer pageNumber;

    static Integer handlingCost = 100;

    public Book(String title, String publisher, String author, Integer pageNumber) {
        super(title, publisher);
        this.author = author;
        this.pageNumber = pageNumber;
    }

    public String getAuthor() {
        return author;
    }

    public Integer getPageNumber() {
        return pageNumber;
    }

    @Override
    public String toString() {
        return "Book{" +
                "Title=" + getTitle() + '\'' +
                "Publisher=" + getPublisher() + '\'' +
                "author='" + author + '\'' +
                ", pageNumber=" + pageNumber +
                '}';
    }
}
