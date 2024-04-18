package com.practice.learnspring;

import com.practice.learnspring.controller.UserController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
class LearnSpringApplicationTests {

    public static void main(String[] args) {
        ConfigurableApplicationContext context=SpringApplication.run(LearnSpringApplicationTests.class, args);
        Student s=context.getBean(Student.class);
        s.show();
        s.college.showCollege();

//        UserController user=context.getBean(UserController.class);
//        System.out.println(user.getUser());
//        UserController controller=context.getBean(UserController.class);
//        controller.toString();

        ConfigurableApplicationContext context1=SpringApplication.run(LearnSpringApplicationTests.class);
        MyClass myClass=context1.getBean(MyClass.class);
        myClass.doSomethingWithDependency();

    }



}
