package com.java8.functionalInterface;

public class SquareClass {

	
	public static void main(String[] args) {

		
		// 1st way
		Square var3 = (s) -> {
			return s * s;
		};
		System.out.println(var3.square(5));

		// 2nd way
		Square var = (s) -> s * s;
		System.out.println(var.square(5));

		// 3rd way
		Square var2 = s -> s * s;
		System.out.println(var2.square(5));


	}
}
