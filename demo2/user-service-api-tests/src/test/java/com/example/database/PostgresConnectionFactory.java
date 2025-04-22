package com.example.database;

import java.sql.Connection;
import java.sql.DriverManager;

public class PostgresConnectionFactory {

    public static Connection getConnection() {
        try {
            Class.forName("org.postgresql.Driver");
            return DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "postgres");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    
}
