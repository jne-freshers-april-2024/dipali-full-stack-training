package com.microservices.appointmentservice.service;

import com.microservices.appointmentservice.entity.Appointment;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AppointmentService {

    public Appointment createAppointment(Appointment appointment);

    public List<Appointment> getAllAppointment();

    public Appointment getAppointmentById(int id);
}
