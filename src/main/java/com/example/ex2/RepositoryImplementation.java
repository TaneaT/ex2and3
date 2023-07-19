package com.example.ex2;



import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RepositoryImplementation implements TaskManagerRepository {

    Scanner scanner = new Scanner(System.in);

    @Override
    public void createTableUser() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/db1?user=root";
        try (Connection connection = DriverManager.getConnection(url)) {

            PreparedStatement createTable = connection.prepareStatement("CREATE TABLE user(\n" +
                    "first_name VARCHAR(40),\n" +
                    "last_name VARCHAR(40),\n" +
                    "user_name VARCHAR(40) PRIMARY KEY\n" +
                    ");");

            createTable.execute();
            createTable.close();

        }
    }

    @Override
    public void createTableTask() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/db1?user=root";
        try (Connection connection = DriverManager.getConnection(url)) {

            PreparedStatement createTable = connection.prepareStatement("CREATE TABLE task(\n" +
                    "user_name VARCHAR(40),\n" +
                    "task_title VARCHAR(40),\n" +
                    "description VARCHAR(300),\n" +
                    "FOREIGN KEY (user_name) REFERENCES user(user_name)\n" +
                    ");");

            createTable.execute();
            createTable.close();

        }
    }

    @Override
    public void createUser(User user) throws SQLException{
        String url = "jdbc:mysql://localhost:3306/db1?user=root";
        try (Connection connection = DriverManager.getConnection(url)) {

            PreparedStatement createUser = connection.prepareStatement("INSERT INTO user VALUES (?,?,?)");
            createUser.setString(1, user.getFirstName());
            createUser.setString(2, user.getLastName());
            createUser.setString(3, user.getUserName());

            createUser.executeUpdate();
            createUser.close();

        }
    }

    @Override
    public void createTask() throws SQLException{
        String url = "jdbc:mysql://localhost:3306/db1?user=root";
        try (Connection connection = DriverManager.getConnection(url)) {
            User user = new User();

            PreparedStatement createTask = connection.prepareStatement("INSERT INTO task VALUES(?,?,?)");

            createTask.setString(1, user.getUserName());
            createTask.setString(2, user.getTasktitle());
            createTask.setString(3, user.getDescription());

            createTask.executeUpdate();
        }

    }

    @Override
    public List<User> showAllUsers()throws SQLException {
        String url = "jdbc:mysql://localhost:3306/db1?user=root";
        try (Connection connection = DriverManager.getConnection(url)) {

            PreparedStatement showUsers = connection.prepareStatement("SELECT user.first_name, user.last_name, COUNT(task.user_name) AS numberOfTasks FROM user LEFT JOIN task ON user.user_name = task.user_name GROUP BY user.user_name;");

            ResultSet resultSet = showUsers.executeQuery();

            List<User> users = new ArrayList<>();

            while (resultSet.next()) {
                String first_name = resultSet.getString(1);
                String last_name = resultSet.getString(2);
                Integer numberOfTasks = resultSet.getInt("NumberOfTasks");

                User user = new User(first_name, last_name, numberOfTasks);

                users.add(user);
            }

            for (User user : users){
                System.out.println(user);
            }

            showUsers.close();

            return users;
        }
    }

    @Override
    public void showUsersTasks() throws SQLException{
        String url = "jdbc:mysql://localhost:3306/db1?user=root";
        try (Connection connection = DriverManager.getConnection(url)) {

            System.out.println("Enter the user name: ");
            String userName = scanner.nextLine();

            PreparedStatement showTasks = connection.prepareStatement("SELECT task.task_title, task.description FROM task JOIN user ON task.user_name = user.user_name WHERE task.user_name = ?");

            showTasks.setString(1,userName);
            ResultSet resultSet = showTasks.executeQuery();

            while(resultSet.next()){
                String title = resultSet.getString("task_title");
                String description = resultSet.getString("description");

                System.out.println(title);
                System.out.println(description);
            }



            showTasks.close();

        }
    }


}
