package com.homework;

public class Journal extends Publication {
    private Integer issueYear;

    static Integer handlingCost = 23;

    public Journal(String title, String publisher, Integer issueYear) {
        super(title, publisher);
        this.issueYear = issueYear;
    }

    public Integer getIssueYear() {
        return issueYear;
    }

    @Override
    public String toString() {
        return "Journal{" +
                "Title=" + getTitle() + '\'' +
                "Publisher=" + getPublisher() + '\'' +
                "issueYear=" + issueYear +
                '}';
    }
}
