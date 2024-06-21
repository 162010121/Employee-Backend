package com.emp.backend.securityconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig {

	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();

	}

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		return http.csrf().disable().cors().and().authorizeHttpRequests()
				.antMatchers("/employee/add","/employee/getEmployee/{Id}", "/employee/deleteEmployee/{Id}","/employee/updateEmployee/{Id}","/employee/getAllEmployee")
				.permitAll().
				and().
				authorizeHttpRequests()
				.antMatchers("/employee/**").authenticated().and()
				.build();
	}
	
	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration)
			throws Exception {
		// TODO Auto-generated method stub
		return authenticationConfiguration.getAuthenticationManager();
	}
	
}

