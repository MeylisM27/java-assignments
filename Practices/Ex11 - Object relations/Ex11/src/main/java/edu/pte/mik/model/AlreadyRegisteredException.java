package edu.pte.mik.model;

// A custom exception is created to represent multiple registrations
// stores duplicated user object
// Exceptions has to be subclassed from Exception class
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
