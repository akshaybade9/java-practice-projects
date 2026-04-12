package com.java8.streamAPI;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class StreamAPIPractice {
	
	public static void main(String[] args) {
		
		Predicate<Integer> evenOrNot = num->num%2==0;
		
		Function<String, Integer> lengthOfString = String::length;
		
		Consumer<String> nameOfEmployee=System.out::println;
		
		Supplier<String> returnStatement = ()->"Akshay";
		
		
		
		var list = new ArrayList<Integer>(Arrays.asList(10,2,3,5,8));
		
		//print all the numbers
		list.stream().forEach(System.out::println);
		list.stream().forEach((num)->System.out.println(num));
		
		
		
		
		//print only even numbers
		list.stream()
		.filter(num->num%2==0)
		.forEach(System.out::println);
		
		
		
		// make square of all numbers and print it.
		list.stream()
		.map((num)->num*num)
		.forEach(System.out::println);
		
		list.stream()
		.map((num)->{
			System.out.println(num);
			return num*num;
			})
		.forEach((num)->System.out.println("foreach"));
		
		
		// make square of only even numbers and print it.
		list.stream()
		.filter(num->num%2==0)
		.map((num)->num*2)
		.forEach(System.out::println);
		
		
		
		
		var employees = new ArrayList<Employee>(Arrays.asList(
				new Employee(1, "Akshay", "Tech"),
				new Employee(2, "Priti", "Testing"),
				new Employee(3, "Abhishek", "Tech"),
				new Employee(4, "Aniket", "Tech"),
				new Employee(5, "Snehal", "CEO")));
		
		
		// print all employees names whose department is Tech
		employees.stream()
		.filter((emp)->emp.getDepartment().equalsIgnoreCase("Tech"))
		.map(Employee::getName)
		.forEach(System.out::println);
		
		
		//collect it into List<String> all the employees whose department is Tech
		List<String> collect = employees.stream()
		.filter((emp)->emp.getDepartment().equalsIgnoreCase("Tech"))
		.map((emp)->emp.getName())
		.collect(Collectors.toList());
		
		//collect it into Set<String> all the employees whose department is Tech
		Set<String> collect2 = employees.stream()
		.filter((emp)->emp.getDepartment().equalsIgnoreCase("Tech"))
		.map((emp)->emp.getName())
		.collect(Collectors.toSet());
		

		//collect it into Map all the employees whose department is Tech
		Map<Object,Object> collect3 = employees.stream()
		.collect(Collectors.toMap(emp->emp.getId(), Employee::getName));

		
		//print List<String> empNames in forEach
		employees.stream()
		.filter((emp)->emp.getDepartment().equalsIgnoreCase("Tech"))
		.map((emp)->emp.getName())
		.collect(Collectors.toList())
		.forEach((empName)->System.out.println(empName));
		
		
		// retrun count of employees
		long count = employees.stream()
		.filter((emp)->emp.getDepartment().equalsIgnoreCase("Tech"))
		.map((emp)->emp.getName())
		.count();
		System.out.println(count);
		
		
		var names = new ArrayList<String>(Arrays.asList("Akshay","Priti","Abhishek","Snehal","Ram"));
		
		
		// findFirst();
		Optional<String> first = names.stream()
		.filter(name->name.startsWith("S"))		
		.findFirst();	
		if(first.isPresent()) {
			System.out.println(first.get());
		}
		
		
		//anyMatch()
		boolean anyMatch = names.stream().anyMatch(name -> name.startsWith("S"));
		System.out.println(anyMatch);
		
		var numbers = new ArrayList<Integer>(Arrays.asList(10,2,3,5,8));
		
		//sorted()
		numbers.stream().sorted().forEach(System.out::println);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

			

	}

}
