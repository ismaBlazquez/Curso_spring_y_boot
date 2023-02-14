package com.javainuse.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	// authentication
	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("fer")
				.password("fer").roles("USER");
		
		auth.inMemoryAuthentication().withUser("isa")
		.password("isa").roles("ADMIN","USER");
	}

	// authorication
	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.antMatcher("/listEmployees.html").authorizeRequests().anyRequest().hasRole("ADMIN")
				.and().formLogin().loginPage("/login.jsp")
				.failureUrl("/login.jsp?error=1").loginProcessingUrl("/login")
				.permitAll().and().logout()
				.logoutSuccessUrl("/listEmployees.html");

	}

}
