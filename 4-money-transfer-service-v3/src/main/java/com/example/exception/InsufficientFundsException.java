package com.example.exception;

public class InsufficientFundsException extends RuntimeException {
    public InsufficientFundsException(String accountNumber, double amount) {
        super("Insufficient funds in account: " + accountNumber + " for amount: " + amount);
    }
}
