package com.java8.functionalInterface;

public class AdditionClass {

	public static void main(String[] args) {

		// 1st way
		Addition var = (a, b) -> {
			return a + b;
		};
		System.out.println(var.sum(2, 5));

		
		// 2nd way
		Addition var2 = (a, b) -> a + b;
		System.out.println(var.sum(2, 5));

	}
}
