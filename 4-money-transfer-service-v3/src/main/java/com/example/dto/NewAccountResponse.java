package com.example.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class NewAccountResponse {

    private String number;
    private double balance;
    private String status;
    private String message;

    @Override
    public String toString() {
        return "NewAccountResponse{" +
                "number='" + number + '\'' +
                ", balance=" + balance +
                '}';
    }

}
