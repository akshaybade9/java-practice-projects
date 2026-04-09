package com.java8.functionalInterface;

import java.util.function.Predicate;

public class PredicatePractice {

	
	public static void main(String[] args) {
		
		//1st way
//		Predicate<Integer> p = (num)->{
//			if(num%2==0) {
//				return true; 
//			}else {
//				return false;
//			}
//		};
		
		
		Predicate<Integer> p = num->num%2==0;
		System.out.println(p.test(10));
		
		
	}
	
}
