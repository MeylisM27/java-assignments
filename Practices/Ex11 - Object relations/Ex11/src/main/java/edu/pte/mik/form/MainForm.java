package edu.pte.mik.form;

import edu.pte.mik.io.ConsoleIO;
import edu.pte.mik.io.FileIO;
import edu.pte.mik.model.AlreadyRegisteredException;
import edu.pte.mik.model.UserStorage;
import edu.pte.mik.reader.UserReader;

import java.io.IOException;

//Controller implementing main form functions
//central control of the application
public class MainForm implements Form {

    private final UserStorage userStorage;
    private final ConsoleIO consoleIO;

    public MainForm() {
        userStorage = new UserStorage();
        consoleIO = new ConsoleIO();
    }

    public void show() {
        System.out.println("========== Main form ==========");

        try {
            String selection;
            do {
                printMainMenu();
                selection = consoleIO.getString("What is your selection?").toLowerCase();

                if(selection.equalsIgnoreCase("p")) {
                    printUsers();
                }

                if(selection.equalsIgnoreCase("r")) {
                    registerUser();
                }

                if(selection.equalsIgnoreCase("f")) {
                    registerUsersFromFile();
                }

                if(selection.equalsIgnoreCase("l")) {
                    login();
                }

            } while (!selection.equalsIgnoreCase("x"));
        }catch (IOException ex) {
            System.out.println("An error occurred!");
            System.out.println(ex.getMessage());
        }
    }

    private void printMainMenu() {
        System.out.println("========== Main menu ==========");
        System.out.println("P - Print users to console");
        System.out.println("R - Register single user from console");
        System.out.println("F - Register users from file");
        System.out.println("L - login user");
        System.out.println("X - exit");
    }

    private void printUsers() {
        for(int i=0; i < userStorage.getUserCount(); i++) {
            System.out.println(userStorage.getUser(i));
        }
    }

    private void registerUser() {
        UserReader userForm = new UserReader(consoleIO);
        userForm.get();
        if(userForm.getUser() != null) {
            try {
                userStorage.addUser(userForm.getUser());
            }catch (AlreadyRegisteredException ex) {
                System.out.println(ex.getMessage());
                System.out.println(ex.getAlreadyRegisteredUser());
            }
        }
    }

    private void registerUsersFromFile() {
        FileIO fileIO = new FileIO(".\\Data\\users.txt");
        try {
            String hasNext;
            UserReader userForm = new UserReader(fileIO);
            do {
                userForm.get();
                userStorage.addUser(userForm.getUser());
                hasNext = fileIO.getString("");
            }while(hasNext.equalsIgnoreCase("i"));
            fileIO.close();
        }catch (AlreadyRegisteredException ex) {
            System.out.println(ex.getMessage());
            System.out.println(ex.getAlreadyRegisteredUser());
        }catch (IOException ex) {
            System.out.println("Import exception occurred!");
            System.out.println(ex.getMessage());
        }
    }

    private void login() {
        LoginForm loginForm = new LoginForm();
        loginForm.show();

        if(
                userStorage.login(
                        loginForm.getUserName(),
                        loginForm.getPassword()
                )
        ) {
            System.out.println("Login succeeded!");
        }
        else {
            System.out.println("Login failed!");
        }
    }
}
