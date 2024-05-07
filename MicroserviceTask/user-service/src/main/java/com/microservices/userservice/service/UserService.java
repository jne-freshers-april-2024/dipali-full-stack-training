package com.microservices.userservice.service;

import com.microservices.userservice.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    public User createUser(User user);

    public List<User> getAllUser();

    public User getUserById(int id);



}
