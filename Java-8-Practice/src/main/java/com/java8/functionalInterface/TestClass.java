package com.java8.functionalInterface;

public class TestClass {

	public static void main(String[] args) {

		// 1st way
		MyInterface m = new MyInterface() {
			@Override
			public void start() {
				System.out.println("Anonymous Class");

			}
		};

		m.start();
		
		
		//2nd Way
		MyInterface m2 = ()->{
			System.out.println("Lambda Expression");
		};
		
		m2.start();
		
		
		//3rd way
		MyInterface m3=()->System.out.println("Shorter Lambda Use");
		m3.start();
		
		
		
		
		
		

	}

}
