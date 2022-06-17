package com.idat.EC2LuisMongeBodega.seguridad;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private UserDetailService service;
		

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {		
		auth.userDetailsService(service).passwordEncoder(encriptado());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {	
		http.authorizeRequests()
		.antMatchers("/usuario/v1/*").access("hasRole('ADMIN')")
		.antMatchers("/producto/v1/*").access("hasRole('ADMIN')")
		.antMatchers("/usuario/v1/listar").access("hasRole('USER')")
		.antMatchers("/producto/v1/listar").access("hasRole('USER')")
		.and()
		.httpBasic()
		.and()
		.csrf().disable();
		super.configure(http);
	}
	
	public PasswordEncoder encriptado() {
		
		return new BCryptPasswordEncoder();
	}
	

}
