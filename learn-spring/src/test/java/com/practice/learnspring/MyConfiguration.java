package com.practice.learnspring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfiguration {

    @Bean
    public MyDependency myDependency()
    {
        return new MyDependency();
    }

    @Bean
    public MyClass myClass()
    {
        return new MyClass();
    }
}
