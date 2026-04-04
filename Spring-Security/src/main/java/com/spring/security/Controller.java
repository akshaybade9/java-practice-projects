package com.spring.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
	
	
	@Autowired
	private UserEntityRepository entityRepository;
	
	@Autowired
	private PasswordEncoder encoder;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private JwtService jwtService;
	
	
	@GetMapping("/hello")
	public String hellowWorld() {
		return"Hello World";
	}
	
	@GetMapping("/hi")
	public String hiwWorld() {
		return"Hi World";
	}
	
	@GetMapping("/user/save")
	public void saveUsernameAndEncodedPassword(@RequestParam String username , @RequestParam String password,@RequestParam Role role) {
		UserEntity entity = new UserEntity();
		entity.setIsActive(true);
		entity.setUsername(username);
		entity.setRole(role);
		entity.setPassword(encoder.encode(password));
		entityRepository.save(entity);
	}
	
	@PostMapping("/user/authenticate")
	public String authenticate(@RequestBody Model model) {
		Authentication authenticate = authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(model.getUsername(), model.getPassword()));
		if(authenticate.isAuthenticated()) {
			String role = authenticate
			.getAuthorities()
			.iterator()
			.next()
			.getAuthority()
			.replace("ROLE_", "");
			return jwtService.generateToekn(model.getUsername(),role); 
		}else {
			return"token generation failed";
		}
		
		
	}
	
	

}
