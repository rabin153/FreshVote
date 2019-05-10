package com.freshvotes.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsService userDetailsService;

	@Bean
	public PasswordEncoder getPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.
		userDetailsService(userDetailsService)
		.passwordEncoder(getPasswordEncoder());
//		auth.inMemoryAuthentication().
//		passwordEncoder(getPasswordEncoder()).
//		 withUser("admin").password(getPasswordEncoder().encode("admin")).roles("USER");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().
		antMatchers("/").permitAll().
		antMatchers("/login").permitAll()
				//.antMatchers("/dashboard/**")
		.anyRequest()
				.hasRole("USER").and().
				formLogin().loginPage("/login").permitAll()
				.loginProcessingUrl("/user/login").defaultSuccessUrl("/dashboard")
				//.failureUrl("/login")
				.and().logout()
				.logoutUrl("/logout").permitAll();

	}
}
