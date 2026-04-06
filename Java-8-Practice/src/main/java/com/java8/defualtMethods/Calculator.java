package com.java8.defualtMethods;

public interface Calculator {
	
	default int calculator(int a, int b) {
		if (isValidAmount(a, a)) {
			return a + b;
		} else {
			return 0;
		}
	}
	
	//cannot right method from Object class
	
//	default boolean equals(Object anObject) {
//        if (this == anObject) {
//            return true;
//        }
//    }
	
	static boolean isValidAmount(int amount, int amount2) {
		logInTime();
		if (amount > 0 && amount2 > 0) {
			return true;
		}
		return false;
	}

	static String logInTime() {
		return "LogInTime";
	}
	


}
