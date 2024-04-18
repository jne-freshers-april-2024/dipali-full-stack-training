package com.learn.springannotation.service;

import org.springframework.stereotype.Service;


@Service
public class UserService {


    public String getUser()
    {
       return "getting the Users";
    }

}
