package com.spring.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	@Autowired
	private JwtFilter filter;
	
	@Bean
	public SecurityFilterChain basicAuth(HttpSecurity http) throws Exception
	{
		http
		.csrf(csrf->csrf.disable())
		.authorizeHttpRequests(auth -> auth
				.requestMatchers("/user/**")
				.permitAll()
				
			/*	.requestMatchers(HttpMethod.POST, "/rooms")
				.hasRole("ADMIN")
				.requestMatchers(HttpMethod.GET, "/rooms")
				.hasAnyRole("ADMIN","USER","STAFF")
				.requestMatchers(HttpMethod.GET,  "/rooms/**")
				.hasAnyRole("ADMIN","USER")   */
				
			/*	.requestMatchers(HttpMethod.POST, "/rooms")
				.hasAuthority("ROLE_ADMIN")
				.requestMatchers(HttpMethod.GET, "/rooms")
				.hasAnyAuthority("ROLE_ADMIN","ROLE_USER","ROLE_STAFF")
				.requestMatchers(HttpMethod.GET, "/rooms/**")
				.hasAnyAuthority("ROLE_ADMIN","ROLE_USER")   */
				
				.anyRequest().authenticated())
		//.httpBasic(Customizer.withDefaults());
		.addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class);
		
		return http.build();
	}
	

	@Bean
	public AuthenticationManager authenticationManager(UserDetailsService detailsService,PasswordEncoder encoder) {
		DaoAuthenticationProvider  daoAuthenticationProvider = new DaoAuthenticationProvider(detailsService);
		daoAuthenticationProvider.setPasswordEncoder(encoder);
		return new ProviderManager(daoAuthenticationProvider);	
	}
	
	@Bean
	public PasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
	}

}
