package com.homework;

public class Publication {
    private String title;
    private String publisher;

    static Integer baseRentalFee = 100;

    public Publication(String title, String publisher) {
        this.title = title;
        this.publisher = publisher;
    }

    public String getTitle() {
        return title;
    }

    public String getPublisher() {
        return publisher;
    }
}
