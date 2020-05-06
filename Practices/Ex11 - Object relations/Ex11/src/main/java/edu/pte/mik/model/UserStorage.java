package edu.pte.mik.model;

import java.util.ArrayList;

// A well known storage, using an ArrayList to store users, which is final not to change it
public class UserStorage {
    private final ArrayList<User> users = new ArrayList<>();

    public int getUserCount() {
        return users.size();
    }

    public User getUser(int index) {
        if(index >= 0 && index < users.size()) {
            return users.get(index);
        }
        return null;
    }

    public void addUser(User newUser) throws AlreadyRegisteredException {
        for(User u : users) {
            if(u.getUserName().equalsIgnoreCase(newUser.getUserName())) {
                throw new AlreadyRegisteredException(newUser);
            }
        }
        users.add(newUser);
    }

    // login method check if there is a user with specified user name and password (only hash stored)
    public boolean login(String userName, Password password) {
        for (User u : users) {
            if(u.getUserName().contentEquals(userName)
                    && u.getPassword().equalsTo(password)
            ) return true;
        }
        return false;
    }
}
