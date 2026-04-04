package com.spring.security;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;

import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtService {

	
	public static final String SECRET = "f8a9c3d7e6b2a1c4d5e6f7a8b9c0d1e2f3a4b5c6d7e8f9a0b1c2d3e4f5a6b7c8";
	
	
	public String generateToekn(String username, String role) {
		HashMap<String, Object> roles = new HashMap<>();
		roles.put("Role", role); 
		return Jwts.builder()
		.setSubject(username)
		.setIssuedAt(new Date())
		.setExpiration(new Date(System.currentTimeMillis() + 1000*60*30))
		.addClaims(roles)
		.signWith(getSignedKey(),SignatureAlgorithm.HS256)
		.compact();
	}
	
	private Key getSignedKey() {
		return Keys.hmacShaKeyFor(SECRET.getBytes());
	}
	
	public Claims verifySignatureAndExtractAllClaims(String token) {	
		return Jwts.parserBuilder()
				.setSigningKey(getSignedKey())
				.build()
				.parseClaimsJws(token)
				.getBody();	
	}
	
	public String extractUsername(String token) {
		return verifySignatureAndExtractAllClaims(token).getSubject();
	}
	
	public Date getExpiration(String token) {
		return verifySignatureAndExtractAllClaims(token).getExpiration();
	}
	
	public boolean isToekenExpire(String token) {
		return getExpiration(token).before(new Date());
	}
	
	
}
