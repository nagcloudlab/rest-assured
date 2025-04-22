package com.example.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


import com.example.database.PostgresConnectionFactory;

public class UserDao {

    public List<User> getAllUsers() {
        try(Connection connection=PostgresConnectionFactory.getConnection()){
            ResultSet rs= connection.createStatement().executeQuery("SELECT * FROM users");
            List<User> users = new ArrayList<>();
            while (rs.next()) {
                String name = rs.getString("name");
                String email = rs.getString("email");
                String mobile = rs.getString("mobile");
                User user = new User(name, email, mobile);
                users.add(user);
            }
            return users;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public User getUserById(int id) {
        try(Connection connection=PostgresConnectionFactory.getConnection()){
            ResultSet rs= connection.createStatement().executeQuery("SELECT * FROM users WHERE id = " + id);
            if (rs.next()) {
                String name = rs.getString("name");
                String email = rs.getString("email");
                String mobile = rs.getString("mobile");
                return new User(name, email, mobile);
            }
            return null;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public void createUser(User user) {
        try(Connection connection=PostgresConnectionFactory.getConnection()){
            String query = "INSERT INTO users (name, email, mobile) VALUES ('" + user.getName() + "', '" + user.getEmail() + "', '" + user.getMobile() + "')";
            connection.createStatement().executeUpdate(query);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void updateUser(int id, User user) {
        try(Connection connection=PostgresConnectionFactory.getConnection()){
            String query = "UPDATE users SET name = '" + user.getName() + "', email = '" + user.getEmail() + "', mobile = '" + user.getMobile() + "' WHERE id = " + id;
            connection.createStatement().executeUpdate(query);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public void deleteUser(int id) {
        try(Connection connection=PostgresConnectionFactory.getConnection()){
            String query = "DELETE FROM users WHERE id = " + id;
            connection.createStatement().executeUpdate(query);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public void deleteAllUsers() {
        try(Connection connection=PostgresConnectionFactory.getConnection()){
            String query = "DELETE FROM users";
            connection.createStatement().executeUpdate(query);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
}
