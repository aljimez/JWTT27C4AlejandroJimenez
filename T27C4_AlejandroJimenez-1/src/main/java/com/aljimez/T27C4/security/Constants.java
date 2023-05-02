package com.aljimez.T27C4.security;


public class Constants {

	// Spring Security

	public static final String LOGIN_URL = "/login";
	public static final String HEADER_AUTHORIZACION_KEY = "Authorization";
	public static final String TOKEN_BEARER_PREFIX = "Bearer ";
public static final String REGISTR_URL = "/register";
	// JWT

	public static final String ISSUER_INFO = "Alejandro Jiménez Álvarez";
	public static final String SUPER_SECRET_KEY = "heavyroots";
	public static final long TOKEN_EXPIRATION_TIME = 865_000_000; // 10 day

}