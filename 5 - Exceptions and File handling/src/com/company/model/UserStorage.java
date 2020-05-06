package com.company.model;

import java.util.ArrayList;

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

    public void removeUser(User userToBeDeleted) {
        for(User u : users) {
            if(u.getRegistrationNo() == userToBeDeleted.getRegistrationNo()) {
                users.remove(userToBeDeleted);
                break;
            }
        }
    }

    public boolean login(String userName, Password password) {
        for (User u : users) {
            if(u.getUserName().contentEquals(userName)
                    && u.getPassword().equalsTo(password)
            ) return true;
        }
        return false;
    }

    public User login(Integer registrationNo, Password password) {
        for (User u : users) {
            if(u.getRegistrationNo() == registrationNo
                    && u.getPassword().equalsTo(password)
            ) return u;
        }
        return null;
    }
}
