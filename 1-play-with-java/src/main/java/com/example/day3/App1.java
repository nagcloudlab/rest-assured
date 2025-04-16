package com.example.day3;

import java.sql.*;

public class App1 {
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
        String sql = "select * from accounts";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        // 4. Execute the statement
        ResultSet rs = preparedStatement.executeQuery();
        // 5. Process the result

        while (rs.next()) {
            String accountNum = rs.getString("number");
            double balance = rs.getDouble("balance");
            System.out.println("Account Number: " + accountNum + ", Balance: " + balance);
        }

        // 6. Close the connection
        connection.close();
        // 7. Handle exceptions


    }
}
