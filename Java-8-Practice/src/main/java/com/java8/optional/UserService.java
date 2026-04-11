package com.java8.optional;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class UserService {

	public Optional<User> getUserById(int id) {

		List<User> users = Arrays.asList(new User(1, "Akshay"), new User(2, "Priti"));

		for (User user : users) {
			if (id == user.getUserId()) {
				return Optional.of(user);
			}
		}

		return Optional.empty();
	}

}
