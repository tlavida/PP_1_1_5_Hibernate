//package jm.task.core.jdbc.dao;
//
//import jm.task.core.jdbc.model.User;
//import jm.task.core.jdbc.util.Util;
//
//import java.sql.*;
//import java.util.ArrayList;
//import java.util.List;
//
//public class UserDaoJDBCImpl implements UserDao {
//    private final Connection connection = Util.getConnection();
//    public UserDaoJDBCImpl() {
//
//    }
//
//    public void createUsersTable() {
//        String creteUsersTable = ("CREATE TABLE IF NOT EXISTS USER(" +
//                "id mediumint not null  auto_increment, " +
//                "name varchar(10)," +
//                "lastName varchar(15)," +
//                "age tinyint," +
//                "primary key (id))");
//
//        try (Statement statement = connection.createStatement()) {
//            statement.execute(creteUsersTable);
//            System.out.println("Таблица создана");
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public void dropUsersTable() {
//        String dropUsersTable = ("DROP TABLE IF EXISTS USER");
//
//        try (Statement statement = connection.createStatement()) {
//            statement.execute(dropUsersTable);
//            System.out.println("Таблица удалена");
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public void saveUser(String name, String lastName, byte age) {
//        String saveUser = ("INSERT INTO USER(name, lastName, age) VALUES (?, ?, ?);");
//
//        try (PreparedStatement preparedStatement = connection.prepareStatement(saveUser)) {
//            preparedStatement.setString(1, name);
//            preparedStatement.setString(2, lastName);
//            preparedStatement.setByte(3, age);
//            preparedStatement.executeUpdate();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public void removeUserById(long id) {
//        String removeUserById = ("DELETE FROM USER WHERE id = ?");
//
//        try (PreparedStatement preparedStatement = connection.prepareStatement(removeUserById)) {
//            preparedStatement.setLong(1, id);
//            preparedStatement.executeUpdate();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public List<User> getAllUsers() {
//        List<User> result = new ArrayList<>();
//        String getAllUsers = ("SELECT * FROM USER");
//
//        try (PreparedStatement statement = connection.prepareStatement(getAllUsers);
//             ResultSet resultSet = statement.executeQuery()) {
//            while (resultSet.next()) {
//                User user = new User();
//                user.setId(resultSet.getLong("id"));
//                user.setName(resultSet.getString("name"));
//                user.setLastName(resultSet.getString("lastName"));
//                user.setAge(resultSet.getByte("age"));
//                result.add(user);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return result;
//    }
//
//    public void cleanUsersTable() {
//        String cleanUsersTable = ("TRUNCATE TABLE USER");
//
//        try (Statement statement = connection.createStatement()) {
//            statement.executeUpdate(cleanUsersTable);
//            System.out.println("Таблица очищена");
//        } catch (SQLException e) {
//            e.printStackTrace();
//            System.out.println("Таблица не очищена");
//        }
//
//    }
//}
