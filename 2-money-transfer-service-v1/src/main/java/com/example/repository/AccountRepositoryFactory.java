package com.example.repository;

public class AccountRepositoryFactory {
    public static AccountRepository getAccountRepository(String tech) {
        if (tech.equalsIgnoreCase("jdbc")) {
            return new JdbcAccountRepository();
        } else if (tech.equalsIgnoreCase("jpa")) {
            return new JpaAccountRepository();
        } else {
            throw new IllegalArgumentException("Invalid technology: " + tech);
        }
    }
}
