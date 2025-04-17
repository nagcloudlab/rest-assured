package com.example.dto;

public class TransferResponse {

    /*

     */

    private String transferId;
    private String status;
    private String fromAccount;
    private String toAccount;
    private double amount;
    public TransferResponse() {
    }
    public TransferResponse(String transferId, String status, String fromAccount, String toAccount, double amount) {
        this.transferId = transferId;
        this.status = status;
        this.fromAccount = fromAccount;
        this.toAccount = toAccount;
        this.amount = amount;
    }
    public String getTransferId() {
        return transferId;
    }
    public void setTransferId(String transferId) {
        this.transferId = transferId;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public String getFromAccount() {
        return fromAccount;
    }
    public void setFromAccount(String fromAccount) {
        this.fromAccount = fromAccount;
    }
    public String getToAccount() {
        return toAccount;
    }
    public void setToAccount(String toAccount) {
        this.toAccount = toAccount;
    }
    public double getAmount() {
        return amount;
    }
    public void setAmount(double amount) {
        this.amount = amount;
    }




}
