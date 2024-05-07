package com.microservices.userservice.entity;


import jakarta.persistence.Transient;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


public class Appointment {


    private int appointment_id;
    private LocalDate date;
    private String status;
    private LocalDateTime slot;


    private Payment payment;


    public Appointment() {
    }

    public Appointment(int appointment_id, LocalDate date, String status, LocalDateTime slot, Payment payment) {
        this.appointment_id = appointment_id;
        this.date = date;
        this.status = status;
        this.slot = slot;
        this.payment = payment;
    }

    public int getAppointment_id() {
        return appointment_id;
    }

    public void setAppointment_id(int appointment_id) {
        this.appointment_id = appointment_id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getSlot() {
        return slot;
    }

    public void setSlot(LocalDateTime slot) {
        this.slot = slot;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }
}
