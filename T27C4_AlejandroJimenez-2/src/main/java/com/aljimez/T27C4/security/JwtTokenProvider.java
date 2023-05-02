package com.aljimez.T27C4.security;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.util.Date;


public class JwtTokenProvider {

	
	public String generarToken(Authentication auth) {
		Date currDate = new Date();
		String usern = auth.name();

		Date expDate = new Date(currDate.getTime() + Constants.TOKEN_EXPIRATION_TIME);
		
		String token = Jwts.builder().setSubject(usern).setIssuedAt(currDate).setExpiration(expDate)
				.signWith(SignatureAlgorithm.HS512, Constants.SUPER_SECRET_KEY).compact();
		return token;
	}
	
	
	public String obtenerUserN(String token) {
		Claims claims = Jwts.parser().setSigningKey(Constants.SUPER_SECRET_KEY).parseClaimsJws(token).getBody();
		
		return claims.getSubject();
	}
	

	public boolean validarToken(String token) {
	try {
		Jwts.parser().setSigningKey(Constants.SUPER_SECRET_KEY).parseClaimsJws(token);
		return true;
	} catch (Exception e) {
		throw new AuthenticationCredentialsNotFoundException("JWT was expired or incorrect");
	}
	}


	public String getUserNameFromJwt(String token) {
		// TODO Auto-generated method stub
		return null;
	}
}
