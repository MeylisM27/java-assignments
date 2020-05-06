package edu.pte.mik.form;

import edu.pte.mik.io.ConsoleIO;
import edu.pte.mik.model.Password;

import java.io.IOException;

//Handles reading login information
//using a Condole IO module
public class LoginForm implements Form {
    ConsoleIO consoleIO = new ConsoleIO();
    private String userName;
    private Password password;

    public String getUserName() {
        return userName;
    }

    public Password getPassword() {
        return password;
    }

    public void show() {
        try {
            userName = consoleIO.getString("User name:");
            password = Password.createFromPassword(consoleIO.getString("Password:"));
        } catch (IOException ex) {
            System.out.println("I/O exception occurred");
            System.out.println(ex.getMessage());
        }
    }
}
