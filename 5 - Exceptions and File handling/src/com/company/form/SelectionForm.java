package com.company.form;

import com.company.io.ConsoleIO;
import com.company.model.Password;
import com.company.model.User;
import com.company.model.UserStorage;
import com.company.reader.UserReader;

import java.io.IOException;

public class SelectionForm implements Form {
    ConsoleIO consoleIO = new ConsoleIO();
    private Integer registrationNo;
    private Password password;

    public Integer getRegistrationNo() {
        return registrationNo;
    }

    public Password getPassword() {
        return password;
    }

    public void showMenu() {
        System.out.println("--- What you wanna do? ---");
        System.out.println("U - update");
        System.out.println("D - delete");
        System.out.println("X - exit");
    }

    private User authUser(SelectionForm selectionForm, UserStorage userStorage) {
        User u;
        if(
                (u = userStorage.login(
                        selectionForm.getRegistrationNo(),
                        selectionForm.getPassword()
                )) != null
        ) {
            return u;
        }
        return null;

    }

    public void promptMenu(SelectionForm selectionForm, UserStorage userStorage) {
        ConsoleIO consoleIO = new ConsoleIO();
        String selection;
        User u;

        try {
            do {
                u = authUser(selectionForm, userStorage);

                if(u == null) {
                    System.out.println("Login failed!");
                    break;
                }

                showMenu();
                selection = consoleIO.getString("Choose the operation:");

                if(selection.equalsIgnoreCase("u")) {
                    UserReader myUserReader = new UserReader(consoleIO);
                    myUserReader.update(u);
                }

                if(selection.equalsIgnoreCase("d")) {
                    userStorage.removeUser(u);
                    break;
                }

            } while(!selection.equalsIgnoreCase("x"));

        } catch (IOException ex) {
            System.out.println("An error occurred!");
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void show() {
        try {
            registrationNo = consoleIO.getInteger("Registration number:");
            password = Password.createFromPassword(consoleIO.getString("Password:"));
        } catch (IOException ex) {
            System.out.println("I/O exception occurred");
            System.out.println(ex.getMessage());
        }
    }
}
