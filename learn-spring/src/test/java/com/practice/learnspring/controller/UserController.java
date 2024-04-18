package com.practice.learnspring.controller;

import com.practice.learnspring.service.MyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserController {

//    public String getUser()
//    {
//        return "Sushma Parande";
//    }

        private MyService service;

        @Autowired
        public UserController(MyService service) {
        this.service = service;
    }
}
