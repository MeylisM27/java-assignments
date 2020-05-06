package com.company.model;

public class Selection {
    private User selectedUser;

    public Selection(User u) { selectedUser = u; }

    public void update(String firstName, String lastName, Integer age, String password) {
        if(!firstName.equalsIgnoreCase("")) selectedUser.setFirstName(firstName);
        if(!lastName.equalsIgnoreCase("")) selectedUser.setLastName(lastName);
        if(age != null) selectedUser.setAge(age);
        if(!password.equalsIgnoreCase("")) selectedUser.setPassword(password);

    }
}
