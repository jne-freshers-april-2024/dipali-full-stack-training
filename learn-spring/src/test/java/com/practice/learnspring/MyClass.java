package com.practice.learnspring;


import org.springframework.beans.factory.annotation.Autowired;

public class MyClass {
  private MyDependency myDependency;

    @Autowired
    public void setMyDependency(MyDependency myDependency) {
        this.myDependency = myDependency;
    }

    public void doSomethingWithDependency() {
        myDependency.doSomething();
    }
}
