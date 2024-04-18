package com.practice.learnspring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component

public class Student {

    private int id;
    private String name;
    private String depName;

    @Autowired
    College college;



    public Student() {
        System.out.println("student Constructor");
    }

    public Student(int id, String name, String depName) {
        this.id = id;
        this.name = name;
        this.depName = depName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepName() {
        return depName;
    }

    public void setDepName(String depName) {
        this.depName = depName;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", depName='" + depName + '\'' +
                '}';
    }

    public void show()
    {
        System.out.println("show the Students list");
    }
}
