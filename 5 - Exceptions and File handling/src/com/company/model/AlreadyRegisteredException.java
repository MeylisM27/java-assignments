package com.company.model;

public class AlreadyRegisteredException extends Exception {
    private User alreadyRegisteredUser;

    public User getAlreadyRegisteredUser() {
        return alreadyRegisteredUser;
    }

    public AlreadyRegisteredException(User alreadyRegisteredUser) {
        super("User already registered!");
        this.alreadyRegisteredUser = alreadyRegisteredUser;
    }
}