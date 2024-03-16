package com.shivani.config;

import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtProvider {
	
	private SecretKey key = Keys.hmacShaKeyFor(JwtConstant.JWT_SECRET.getBytes());
	
	//during registration and login we get email from this token
	public String generateToken(Authentication auth)
	{
		String jwt = Jwts.builder().setIssuedAt(new Date())
				.setExpiration(new Date(new Date().getTime()+86400000))
				.claim("email", auth.getName())
				.signWith(key).compact();
		return jwt;
	}
	
	//Bearer jwt - we need to extract first 7 chars
	public String getEmailFromJwtToken(String jwt)
	{
		jwt = jwt.substring(7);
		Claims claims = Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJwt(jwt).getBody();
		String email = String.valueOf(claims.get("email"));
		
		return email;
		
	}
	
	

}
