package com.example.day3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MoneyTransferApp {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        String fromAccountNum = "ACC001";
        String toAccountNum = "ACC002";
        double amount = 300.0;

        // Using JDBC- api with Postgres

        // 1. Load the driver
        Class.forName("org.postgresql.Driver");
        // 2. Create a connection
        String url = "jdbc:postgresql://localhost:5432/postgres";
        String user = "postgres";
        String password = "postgres";
        Connection connection = DriverManager.getConnection(url, user, password);
        // 3. Create a statement
        String sql1 = "UPDATE accounts SET balance = balance - ? WHERE number = ?";
        String sql2 = "UPDATE accounts SET balance = balance + ? WHERE number = ?";
        PreparedStatement preparedStatement1 = connection.prepareStatement(sql1);
        PreparedStatement preparedStatement2 = connection.prepareStatement(sql2);

        preparedStatement1.setDouble(1, amount);
        preparedStatement1.setString(2, fromAccountNum);
        preparedStatement2.setDouble(1, amount);
        preparedStatement2.setString(2, toAccountNum);
        // 4. Execute the statement
        int rc1 = preparedStatement1.executeUpdate();
        int rc2 = preparedStatement2.executeUpdate();
        // 5. Process the result
        if (rc1 > 0 && rc2 > 0) {
            System.out.println("Money transferred successfully");
        } else {
            System.out.println("Money transfer failed");
        }
        // 6. Close the connection
        preparedStatement1.close();
        preparedStatement2.close();
        connection.close();
        // 7. Handle exceptions



    }
}
