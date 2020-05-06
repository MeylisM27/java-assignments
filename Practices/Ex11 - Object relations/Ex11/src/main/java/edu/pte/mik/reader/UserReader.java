package edu.pte.mik.reader;

import edu.pte.mik.io.IOModule;
import edu.pte.mik.model.Password;
import edu.pte.mik.model.User;

import java.io.IOException;

// Special class to get user data from a custom Input/Output module
// The same reader can be used to read user from console or from file
public class UserReader implements IoReader {
    private final IOModule ioModule;
    private User user;

    public User getUser() {
        return user;
    }

    public UserReader(IOModule ioModule) {
        this.ioModule = ioModule;
        this.user = null;
    }

    public void get() {
        try {
            ioModule.print("========== Person form ==========");
            String firstName = ioModule.getString("First name:");
            String lastName = ioModule.getString("Last name:");
            Integer age = ioModule.getInteger("Age:");
            String password = ioModule.getString("Password:");

            user = new User(
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
