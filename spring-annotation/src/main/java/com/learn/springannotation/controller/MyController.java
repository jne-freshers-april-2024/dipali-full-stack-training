package com.learn.springannotation.controller;

import com.learn.springannotation.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

    @Autowired
    UserService service;

    @GetMapping("/user")
    public String getUser()
    {
        return service.getUser();
    }


}
