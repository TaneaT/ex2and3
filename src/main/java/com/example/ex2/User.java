package com.example.ex2;

public class User {

    private String firstName;

    private String lastName;

    private String userName;

    private Integer numberOfTasks;

    private String tasktitle;

    private String description;

    public User(String firstName, String lastName, String userName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
    }

    public User(String firstName, String lastName, Integer numberOfTasks) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.numberOfTasks = numberOfTasks;
    }

    public void setNumberOfTasks(Integer numberOfTasks) {
        this.numberOfTasks = numberOfTasks;
    }

    public String getTasktitle() {
        return tasktitle;
    }

    public void setTasktitle(String tasktitle) {
        this.tasktitle = tasktitle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }



    public User() {
    }

//    @Override
//    public String toString() {
//        return "firstName= " + firstName + "\n" +
//                " lastName=" + lastName + "\n" +
//                " userName=" + userName + "\n";
//    }

    @Override
    public String toString() {
        return "firstName=: " + firstName + "\n" +
                "lastName=: " + lastName + "\n" +
                "numberOfTasks: " + numberOfTasks + "\n";
    }
}
