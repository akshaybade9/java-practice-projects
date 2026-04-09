package com.java8.methodreference;

public class Main {
	
	public static void main(String[] args) {
		
		
//		// by lambda
//		MethodRefInterface m = (a, b) -> {
//			return a * b;
//		};
//
//		System.out.println(m.calculate(3, 4));
//		
//		MethodRefInterface m2 = MathOperations::add;
//		System.out.println(m2.calculate(4, 5));
//		
//		
//		MathOperations operations = new MathOperations();
//		operations.setAge(13);
//		ValidateInterface v = operations::validateMethod;
//		System.out.println(v.validate(17));
//		System.out.println(v.validate(-9));
//		
//		StringOprations s2 = (str)->{
//			return str.length();
//		};
//		
//		StringOprations s = String::length;
//		System.out.println(s.operate("Akshay"));
//		
//		
//		CustomerInterface c = MathOperations::getAge;
//		System.out.println(c.get(operations));
		
		Creator<User> user = (name)->{
			return new User(name);
		};
		
		Creator<User> u = User::new;
		
	}

}
