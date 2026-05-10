package com.java8.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Scope("prototype")
public class Controller {
	
	public Controller() {
		System.out.println("Controller Bean Created");
	}

	@Autowired
	Employee employee1;

	@Autowired
	Employee employee2;

	@Autowired
	Employee employee3;

	@GetMapping("/getStudent1")
	public int getEmployee1() {
		return employee1.hashCode();
	}

	@GetMapping("/getStudent2")
	public int getEmployee2() {
		return employee2.hashCode();
	}

	@GetMapping("/getStudent3")
	public int getEmployee3() {
		return employee3.hashCode();
	}

}
