package com.java8.optional;

import java.util.Optional;

public class OptionalPractice {

	public static void main(String[] args) {

		UserService service = new UserService();

		Optional<User> optionalUser = service.getUserById(1);

//		if (optionalUser.isPresent()) {
//			User user = optionalUser.get();
//			System.out.println("UserId:" +" "+ user.getUserId() + " Username: " + user.getUsername());
//		}
		
//		optionalUser.ifPresent(user->System.out.println("UserId:" +" "+ user.getUserId() + " Username: " + user.getUsername()));
//		optionalUser2.ifPresent(user->System.out.println("UserId:" +" "+ user.getUserId() + " Username: " + user.getUsername()));
		
//		optionalUser.ifPresentOrElse(
//				user -> System.out.println("UserId:" + " " + user.getUserId() + " Username: " + user.getUsername()),
//				()->System.out.println("User Not Found"));
		
//		User user = optionalUser2.orElse(new User(-1, "Default"));
//		System.out.println("UserId:" +" "+ user.getUserId() + " Username: " + user.getUsername());
		
//		User user = optionalUser.orElseGet(()->new User(-1, "Default"));
//		System.out.println("UserId:" +" "+ user.getUserId() + " Username: " + user.getUsername());
		
		User user = optionalUser.orElseThrow();
		System.out.println("UserId:" +" "+ user.getUserId() + " Username: " + user.getUsername());
		

	}

}
