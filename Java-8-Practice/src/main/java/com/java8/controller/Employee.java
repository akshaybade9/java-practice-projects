package com.java8.controller;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
//@Scope("prototype")
public class Employee {

	public Employee() {
		System.out.println("Employee Bean Created");
	}

}
