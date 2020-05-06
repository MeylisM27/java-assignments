package edu.pte.mik.model;

// A class to store user data
// UserName is a calculated property
public class User {
    private String firstName;
    private String lastName;
    private Integer age;

    // password is a typed reference to a Password object
    private Password password;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Password getPassword() {
        return password;
    }

    public void setPassword(String newPasswordString) {
        password = Password.createFromPassword(newPasswordString);
    }

    // Calculated property: username from first letter of first name and the last name
    public String getUserName() {
        return firstName.toLowerCase().charAt(0) + lastName.toLowerCase();
    }

    public User(String firstName, String lastName, Integer age, Password password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.password = password;
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", user name=" + getUserName() +
                ", password=" + password +
                '}';
    }
}
