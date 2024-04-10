package com.sprintboot.jpaandhibernate.course.jdbc;

import com.sprintboot.jpaandhibernate.course.Course;
import com.sprintboot.jpaandhibernate.course.springdatajpa.CourseSpringDataJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CourseCommandLineRunner implements CommandLineRunner {

//    @Autowired
//    private CourseJdbcRepository repository;

//    @Autowired
//    private CourseJdbcRepository repository;

    @Autowired
    private CourseSpringDataJpaRepository repository;

    @Override
    public void run(String... args) throws Exception {
        repository.save(new Course(1,"LearnJavaScript Jpa","In3Days"));
        repository.save(new Course(2,"LearnHTML&CSS Jpa","In2Days"));
        repository.save(new Course(3,"LearnSpringBoot Jpa","In5Days"));

        repository.deleteById(1l);

        System.out.println(repository.findById(2l));
        System.out.println(repository.findById(3l));

        System.out.println(repository.findAll());
        System.out.println(repository.count());
        System.out.println(repository.findByAuthor("In2Days"));
        System.out.println(repository.findByName("LearnSpringBoot Jpa"));


    }
}
