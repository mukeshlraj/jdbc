package com.gfg.demo;

import lombok.Value;
import org.springframework.stereotype.Component;

import java.sql.*;

@Component
public class UserRepository {
    private Connection connection;
    //@Value()
    private UserRepository() throws SQLException {
        connection = getConnection();
        createTable();
    }

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/user_db", "root", "mysql123");
    }

    private void createTable() throws SQLException {
        Statement statement = connection.createStatement();
        boolean result = statement.execute("create table if not exists user(id int primary key, " +
                "name varchar(20), country varchar(20), age int)");
    }

    public void saveUser(User user) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("insert into user(id, name, country, age)" +
                "values (?,?,?,?)");
        statement.setInt(1,user.getId());
        statement.setString(2, user.getName());
        statement.setString(3, user.getCountry());
        statement.setInt(4, user.getAge());

        int result = statement.executeUpdate();
    }

    public User getUser(int id) throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from user where id = " + id);

        resultSet.next();

        int userId = resultSet.getInt("id");
        String name = resultSet.getString("name");
        String country = resultSet.getString("country");
        int age = resultSet.getInt("age");

        return User.builder()
                .age(age)
                .id(userId)
                .name(name)
                .country(country)
                .build();
    }

}
