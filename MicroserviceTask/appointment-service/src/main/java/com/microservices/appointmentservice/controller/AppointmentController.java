package com.microservices.appointmentservice.controller;

import com.microservices.appointmentservice.entity.Appointment;
import com.microservices.appointmentservice.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;

    @PostMapping("/appointment")
    public ResponseEntity<Object> createAppointment(@RequestBody Appointment appointment) {
        try {
            Appointment createdAppointment = appointmentService.createAppointment(appointment);
            return ResponseEntity.status(HttpStatus.CREATED).body("Appointment created successfully: " + createdAppointment);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to create appointment: " + e.getMessage());
        }
    }

    @GetMapping("/appointment")
    public ResponseEntity<Object> getAllAppointment() {
        try {
            List<Appointment> appointmentList = appointmentService.getAllAppointment();
            if (appointmentList.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No appointments found");
            }
            return ResponseEntity.status(HttpStatus.OK).body(appointmentList);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to fetch appointments: " + e.getMessage());
        }
    }

    @GetMapping("/appointment/{id}")
    public ResponseEntity<Object> getAppointmentById(@PathVariable int id) {
        try {
            Appointment appointment = appointmentService.getAppointmentById(id);
            if (appointment != null) {
                return ResponseEntity.status(HttpStatus.OK).body(appointment);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Appointment with ID " + id + " not found");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to fetch appointment: " + e.getMessage());
        }
    }
}
