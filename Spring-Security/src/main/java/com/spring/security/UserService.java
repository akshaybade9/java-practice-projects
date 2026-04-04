package com.spring.security;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService{

	
	@Autowired
	private UserEntityRepository repo;
	
	public UserEntity getUserFromUsername(String username) {
		return repo.findByUsernameAndIsActive(username, true);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserEntity user=getUserFromUsername(username);
		List<SimpleGrantedAuthority> authorities = new ArrayList<SimpleGrantedAuthority>();
		authorities.add(new SimpleGrantedAuthority(user.getRole().name()));
		user.getRole().getPermissions().forEach(permission ->{
			authorities.add(new SimpleGrantedAuthority(permission.name()));
		});
		return User.builder()
				.username(user.getUsername())
				.password(user.getPassword())
				.authorities(authorities)
				.build();
	}
}
