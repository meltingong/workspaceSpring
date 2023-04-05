package com.itwill.security.config;

import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableWebSecurity(debug = true)
public class SecurityConfig {
	UsernamePasswordAuthenticationFilter filter;
}
