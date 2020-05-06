package edu.pte.mik.prog2;

import java.io.Serializable;

public class Exam implements Serializable {
    private String firstName;
    private String lastName;
    private int group;
    private int result;
    private Integer mark;
    private transient int dataNotToSerialize = 99;

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getGroup() {
        return group;
    }

    public int getResult() {
        return result;
    }

    public Integer getMark() {
        return mark;
    }

    public void setMark(Integer mark) {
        this.mark = mark;
    }

    public Exam(String firstName, String lastName, int group, int result) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.group = group;
        this.result = result;
        this.mark = null;
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", group=" + group +
                ", result=" + result +
                '}';
    }
}
