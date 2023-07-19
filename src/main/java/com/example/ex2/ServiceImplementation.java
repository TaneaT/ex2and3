package com.example.ex2;



import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class ServiceImplementation implements TaskManagerService{

    Scanner scanner = new Scanner(System.in);

    TaskManagerRepository taskManagerRepository;

    public ServiceImplementation(TaskManagerRepository taskManagerRepository) {
        this.taskManagerRepository = taskManagerRepository;
    }

    @Override
    public void createTableUser() {
        try{
           taskManagerRepository.createTableUser();
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }

    }

    @Override
    public void createTableTask() {
        try{
            taskManagerRepository.createTableTask();
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }

    }

    @Override
    public void addUser(User user) {

        try{
            System.out.println("Enter first name: ");
            user.setFirstName(scanner.nextLine());
            System.out.println("Enter last name: ");
            user.setLastName(scanner.nextLine());
            System.out.println("Enter user name: ");
            user.setUserName(scanner.nextLine());
            taskManagerRepository.createUser(user);

        } catch (SQLException e){
            System.out.println(e.getMessage());
        }

    }

    @Override
    public void addTask() {
        try{
            User user = new User();
            System.out.println("Enter user name: ");
            user.setUserName(scanner.nextLine());
            System.out.println("Enter task title: ");
            user.setTasktitle(scanner.nextLine());
            System.out.println("Enter description: ");
            user.setDescription(scanner.nextLine());
            taskManagerRepository.createTask();
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }

    }

    @Override
    public List<User> showAllUser() {
        List<User> users = new ArrayList<>();
        try{
            return taskManagerRepository.showAllUsers();
        } catch (SQLException e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public void showUsersTasks() {
        try{
            taskManagerRepository.showUsersTasks();
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }

    }
}
