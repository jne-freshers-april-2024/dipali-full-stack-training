package com.microservices.userservice.serviceImpl;

import com.microservices.userservice.entity.Appointment;
import com.microservices.userservice.entity.Payment;
import com.microservices.userservice.entity.User;
import com.microservices.userservice.repository.UserRepo;
import com.microservices.userservice.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Configuration
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private RestTemplate restTemplate;


    private Logger logger= LoggerFactory.getLogger(UserService.class);

    @Override
    public User createUser(User user) {
        return userRepo.save(user);
    }

    @Override
    public List<User> getAllUser() {
        return userRepo.findAll();
    }

    @Override
    public User getUserById(int id) {
       User user=userRepo.findById(id).get();
      Appointment appointmentOfUser=restTemplate.getForObject("http://APPOINTMENT-SERVICE/appointment/"+user.getUserId(), Appointment.class);
      logger.info("{} ",appointmentOfUser);
      List<Appointment> appointments= Arrays.stream(new Appointment[]{appointmentOfUser}).toList();

        List<Appointment> appoint=appointments.stream().map(appointment ->
        {
            ResponseEntity<Payment> forEntity=restTemplate.getForEntity("http://PAYMENT-SERVICE/payment/"+appointment.getAppointment_id(), Payment.class);
            Payment payment=forEntity.getBody();
            logger.info("response status code: {} ",forEntity.getStatusCode());

            appointment.setPayment(payment);

            return appointment;
        }).collect(Collectors.toList());

      user.setAppointments(appoint);
       return user;


    }


}

