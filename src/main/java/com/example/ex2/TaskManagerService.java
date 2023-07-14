package com.example.ex2;

import java.util.List;

public interface TaskManagerService {

    void createTableUser();

    void createTableTask();

    void addUser(User user);

    void addTask();

    List<User> showAllUser();

    void showUsersTasks();
}
