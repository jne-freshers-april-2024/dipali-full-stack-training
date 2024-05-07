package com.microservices.userservice.entity;

public class Payment {

    private int payment_id;
    private double amount;
    private String status;

    public Payment() {
    }

    public Payment(int payment_id, double amount, String status) {
        this.payment_id = payment_id;
        this.amount = amount;
        this.status = status;
    }

    public int getPayment_id() {
        return payment_id;
    }

    public void setPayment_id(int payment_id) {
        this.payment_id = payment_id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
