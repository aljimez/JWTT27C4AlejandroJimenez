package com.aljimez.T27C4.security;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;


import static com.aljimez.T27C4.security.Constants.HEADER_AUTHORIZACION_KEY;
import static  com.aljimez.T27C4.security.Constants.ISSUER_INFO;
import static  com.aljimez.T27C4.security.Constants.SUPER_SECRET_KEY;
import static com.aljimez.T27C4.security.Constants.TOKEN_BEARER_PREFIX;
import static  com.aljimez.T27C4.security.Constants.TOKEN_EXPIRATION_TIME;


import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.filter.OncePerRequestFilter;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import com.aljimez.T27C4.dto.Usuario;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class JWTAuthritionFilter extends OncePerRequestFilter {

	private AuthenticationManager authenticationManager;

	public JWTAuthritionFilter() {
		this.authenticationManager = authenticationManager;
	}

	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException {
		try {
			Usuario credenciales = new ObjectMapper().readValue(request.getInputStream(), Usuario.class);

			return authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
					credenciales.getUsername(), credenciales.getPassword(), new ArrayList<>()));
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
			Authentication auth) throws IOException, ServletException {

		String token = Jwts.builder().setIssuedAt(new Date()).setIssuer(ISSUER_INFO)
				.setSubject(((User)auth.getPrincipal()).getUsername())
				.setExpiration(new Date(System.currentTimeMillis() + TOKEN_EXPIRATION_TIME))
				.signWith(SignatureAlgorithm.HS512, SUPER_SECRET_KEY).compact();
		response.addHeader(HEADER_AUTHORIZACION_KEY, TOKEN_BEARER_PREFIX + " " + token);//devuelve token por cabecera
		response.getWriter().write("{\"token\": \"" + token + "\"}");//devuelve token por body
		System.out.println(response.getHeader(HEADER_AUTHORIZACION_KEY));
	
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}
	
	
	
}