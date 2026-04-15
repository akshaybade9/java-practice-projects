package com.java8.stream.interview.questions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class InterviewQueClass {
	
	
	public static void main(String[] args) {
		
		//1. remove duplicates and sort them in descending order
		var list = new ArrayList<Integer>(Arrays.asList(5, 3, 1, 3, 2, 5, 4));
		List<Integer> sortedByDescending = list.stream().distinct().sorted(Comparator.reverseOrder())
				.collect(Collectors.toList());
		System.out.println(sortedByDescending);
		
		//2. find all the odd numbers and return their squares
		var list2 = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5));
		List<Integer> oddSquares = list2.stream().filter(num->num%2!=0).map(num->num*num).collect(Collectors.toList());
		System.out.println(oddSquares);
		
		//3. get 2nd and 3rd elements from it and return then in a list
		var list3 = new ArrayList<Integer>(Arrays.asList(10,20,30,40,50));
		List<Integer> twoElements = list3.stream().skip(1).limit(2).collect(Collectors.toList());
		System.out.println(twoElements);
		
		//4. find 2nd highest number in a list
		var list4 = new ArrayList<Integer>(Arrays.asList(20, 10, 10, 45, 30, 45, 5, 20));
//		List<Integer> secondHighest = list4.stream().distinct().sorted(Comparator.reverseOrder()).skip(1).limit(1)
//				.collect(Collectors.toList());
		Optional<Integer> first = list4.stream().distinct().sorted(Comparator.reverseOrder()).skip(1).findFirst();
		if(first.isPresent()) { System.out.println(first.get()); }
		
		//5. divide numbers into even and odd
		var list5 = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5));
		Map<Boolean,List<Integer>> dividationMap = list5.stream().collect(Collectors.partitioningBy(num->num%2==0));
		System.out.println(dividationMap);
		
		//find the longest string in the list
		var list6 = new ArrayList<String>(Arrays.asList("Java","SpringBoot","API"));
		String maxLengthString = list6.stream().max(Comparator.comparing(str->str.length())).get();
		System.out.println(maxLengthString);
		
		
		
		
		
	}

}
