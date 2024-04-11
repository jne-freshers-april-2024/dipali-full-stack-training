package com.spring.learnspringframework.test;

import java.io.Serializable;

class Pojo
{
	private String text;
	private int number;
	@Override
	public String toString() {
		return text+" : "+number;
	}
	
}

class JavaBean implements Serializable{

	public JavaBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	 
	private String text;
	private int number;
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	
}

				
public class SpringBeanVsJavaBean {
	public static void main(String[] args) {
		Pojo pojo=new Pojo();
		System.out.println(pojo);
	}
}
