package com.aljimez.T27C4.security;

import static com.aljimez.T27C4.security.Constants.LOGIN_URL;
import static com.aljimez.T27C4.security.Constants.REGISTR_URL;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.authentication.PasswordEncoderParser;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;


@Configuration
@EnableWebSecurity
public class WebSecurity {

	private UserDetailsService userDetailsService;

	private JwtAuthEntryPoint jwtAuthEntryPoint;

	@Autowired
	public WebSecurity(UserDetailsService userDetailsService, JwtAuthEntryPoint jwtAuthEntryPoint) {
		this.userDetailsService = userDetailsService;
		this.jwtAuthEntryPoint = jwtAuthEntryPoint;
	}

	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

	SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {

		httpSecurity.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
		.and()
		.cors()
		.and()
		.csrf()
		.disable().authorizeHttpRequests()
		.requestMatchers(HttpMethod.POST, LOGIN_URL)
		.permitAll()
		.requestMatchers(HttpMethod.POST, REGISTR_URL).permitAll().anyRequest().authenticated().and()
				.addFilterBefore(jwtAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
		return httpSecurity.build();
	}

	@Bean
	 AuthenticationManager authenticationManager(AuthenticationConfiguration auth_config) throws Exception {
		// TODO Auto-generated method stub
		return auth_config.getAuthenticationManager();
	}

	@Bean
	BCryptPasswordEncoder PasswordEncoder() {
		return new BCryptPasswordEncoder();
	}


	@Bean
	JWTAuthenticationFilter jwtAuthenticationFilter() {
// TODO Auto-generated method stub
		return new JWTAuthenticationFilter();
	}

	@Bean
	CorsConfigurationSource corsConfigurationSource() {
		final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", new CorsConfiguration().applyPermitDefaultValues());
		return source;
	}
}
