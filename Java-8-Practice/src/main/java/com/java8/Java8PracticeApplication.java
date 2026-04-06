package com.java8;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.java8.defualtMethods.Calculator;
import com.java8.defualtMethods.CalculatorImpl;

@SpringBootApplication
public class Java8PracticeApplication {

	public static void main(String[] args) {
		SpringApplication.run(Java8PracticeApplication.class, args);
		
		CalculatorImpl impl = new CalculatorImpl();
		int calculator = impl.calculator(2, 8);
		System.out.println(calculator);
		System.out.println(Calculator.isValidAmount(1, 2));
		
	}

}
