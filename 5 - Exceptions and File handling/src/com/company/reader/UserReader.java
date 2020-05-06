package com.company.reader;

import com.company.io.IO;
import com.company.model.Password;
import com.company.model.Selection;
import com.company.model.User;
import com.company.model.UserFactory;

import java.io.IOException;

public class UserReader implements IOReader {
    private final IO ioModule;
    private User user;

    public User getUser() {
        return user;
    }

    public UserReader(IO ioModule) {
        this.ioModule = ioModule;
        this.user = null;
    }

    public void update(User u) {
        try {
            ioModule.print("========== Update form ==========");
            String firstName = ioModule.getString("First name:");
            String lastName = ioModule.getString("Last name:");
            Integer age = ioModule.getInteger("Age:");
            String password = ioModule.getString("Password:");

            Selection selectedUser = new Selection(u);
            selectedUser.update(firstName, lastName, age, password);

        }
        catch(IOException ex) {
            System.out.println("I/O exception occurred");
            System.out.println(ex.getMessage());
        }
    }

    public void get() {
        try {
            ioModule.print("========== Person form ==========");
            String firstName = ioModule.getString("First name:");
            String lastName = ioModule.getString("Last name:");
            Integer age = ioModule.getInteger("Age:");
            String password = ioModule.getString("Password:");

            user = UserFactory.createUser(
                    firstName, lastName, age,
                    Password.createFromPassword(password)
            );
        }
        catch(IOException ex) {
            System.out.println("I/O exception occurred");
            System.out.println(ex.getMessage());
        }
    }
}

