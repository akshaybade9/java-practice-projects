package com.java8.methodreference;


public class MathOperations {
	
	private int age;
	
	
	
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public static int add(int a, int b) {
		return a + b;
	}
	
	public  boolean validateMethod(int num) {
		return num>0;
	}
	
	int length(){
		return "Ak".length();
	}
	
	public static int calculateLength(MathOperations str) {
		return str.length();
	}

}
