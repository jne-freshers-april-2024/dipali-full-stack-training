package com.practice.learnspring;

import org.springframework.stereotype.Component;
//import java.lang.String;

@Component
public class College {

    private String clgName;

    private String clgAddress;

    public College() {
    }

    public College(String clgName, String clgAddress) {
        this.clgName = clgName;
        this.clgAddress = clgAddress;
    }

    public String getClgName() {
        return clgName;
    }

    public void setClgName(String clgName) {
        this.clgName = clgName;
    }

    public String getClgAddress() {
        return clgAddress;
    }

    public void setClgAddress(String clgAddress) {
        this.clgAddress = clgAddress;
    }

    @Override
    public String toString() {
        return "College{" +
                "clgName='" + clgName + '\'' +
                ", clgAddress='" + clgAddress + '\'' +
                '}';
    }

    void showCollege()
    {
        System.out.println("show the College List");
    }
}
