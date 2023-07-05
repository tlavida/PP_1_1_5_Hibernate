package jm.task.core.jdbc;


import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;

public class Main {
    public static void main(String[] args) {
        // реализуйте алгоритм здесь
        UserService userService = new UserServiceImpl();

        userService.createUsersTable();

        userService.saveUser("Name1", "LastName1", (byte) 30);
        userService.saveUser("Name2", "LastName2", (byte) 20);
        userService.saveUser("Name3", "LastName3", (byte) 25);
        userService.saveUser("Name4", "LastName4", (byte) 33);
        userService.saveUser("Name5", "LastName5", (byte) 28);

        userService.removeUserById(1);
        userService.getAllUsers();
        userService.cleanUsersTable();
        userService.dropUsersTable();
    }
}
