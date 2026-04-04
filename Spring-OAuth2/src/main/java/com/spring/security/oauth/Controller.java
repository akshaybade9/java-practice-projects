package com.spring.security.oauth;

import java.util.HashMap;
import java.util.Map;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

	@GetMapping("hello")
	public String hello() {
		return "Hello World... THis is OAuth2 Security";
	}

	@GetMapping("/hi")
	public String hi() {
		return "Hi World... THis is OAuth2 Security";
	}

	@GetMapping("/me")
	public Map<String, Object> getUser() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		OAuth2User user = (OAuth2User) authentication.getPrincipal();
		Map<String, Object> response = new HashMap<String, Object>();
		response.put("name", user.getAttribute("name"));
		response.put("email", user.getAttribute("email"));
		response.put("picture", user.getAttribute("picture"));
		return response;
	}
}
