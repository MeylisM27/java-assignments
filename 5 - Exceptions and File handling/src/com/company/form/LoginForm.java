package com.company.form;

import com.company.io.ConsoleIO;
import com.company.model.Password;

import java.io.IOException;

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

