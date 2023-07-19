package com.example.ex2;

import java.sql.SQLException;
import java.util.List;

public interface TaskManagerRepository {


    void createTableUser() throws SQLException;

    void createTableTask() throws SQLException;

    void createUser(User user) throws SQLException;

    void createTask() throws SQLException;

    List<User> showAllUsers() throws SQLException;

    void showUsersTasks() throws SQLException;


}
