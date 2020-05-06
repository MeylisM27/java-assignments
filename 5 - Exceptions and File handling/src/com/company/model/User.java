package com.company.model;

public class User {
    private String firstName;
    private String lastName;
    private Integer age;

    // to uniquely identify people, I add registrationNo data member
    private Integer registrationNo;

    private Password password;

    public Integer getRegistrationNo() {
        return registrationNo;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Password getPassword() {
        return password;
    }

    public void setPassword(String newPasswordString) {
        password = Password.createFromPassword(newPasswordString);
    }

    public String getUserName() {
        return firstName.toLowerCase().charAt(0) + lastName.toLowerCase();
    }

    public User(String firstName, String lastName, Integer age, Password password, Integer registrationNo) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.password = password;
        this.registrationNo = registrationNo;
    }

    @Override
    public String toString() {
        return "Person{" +
                "registrationNo=" + registrationNo +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", user name=" + getUserName() +
                ", password=" + password +
                '}';
    }
}
