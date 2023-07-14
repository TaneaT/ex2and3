package com.example.ex2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
@Component
public class ServiceImplementation implements TaskManagerService{
@Autowired
    TaskManagerRepository taskManagerRepository;
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

            taskManagerRepository.createUser(user);
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }

    }

    @Override
    public void addTask() {
        try{
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
