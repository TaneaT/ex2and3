package com.example.ex2;


import java.util.Scanner;


public class Ex2Application  {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        TaskManagerRepository taskManagerRepository = new RepositoryImplementation();
        TaskManagerService taskManagerService = new ServiceImplementation(taskManagerRepository);

        taskManagerService.createTableUser();
        taskManagerService.createTableTask();

        int choice = 0;

        while (choice != 5) {


            System.out.println(" \n Task Manager");
            System.out.println("1. Create new user ");
            System.out.println("2. Show all users ");
            System.out.println("3. Add task to the user ");
            System.out.println("4. Show user's tasks");
            System.out.println("5. Exit  \n");

            System.out.println("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {

                case 1:
                    taskManagerService.addUser(new User());
                    break;


                case 2:
                    taskManagerService.showAllUser();
                    break;


                case 3:
                    taskManagerService.addTask();
                    break;


                case 4:
                    taskManagerService.showUsersTasks();
                    break;


                case 5:
                    System.out.println("Closing the app...");
                    break;

            }

        }
    }
    }


