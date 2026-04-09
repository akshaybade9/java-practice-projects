package com.java8.functionalInterface;

import java.util.function.Function;

public class FunctionPractice {
	
	
	public static void main(String[] args) {
		
		//1st way
		Function<String, Integer> f = (str)->{
			return str.length();
		};
		System.out.println(f.apply("Akshay"));
		
		
		//2nd way
		Function<String, Integer> f2 =str-> str.length();
		System.out.println(f2.apply("Akshay"));
		
		
	}

}
