package com.company.model;

public class UserFactory {
    private static Integer registrationNoCounter = 0;

    public static User createUser(String firstName, String lastName, Integer age, Password password) {
        return new User(firstName, lastName, age, password, ++registrationNoCounter);
    }
}
