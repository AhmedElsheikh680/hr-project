	package com.hr.security;
	
	
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.context.annotation.Bean;
	import org.springframework.security.authentication.AuthenticationManager;
	import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
	import org.springframework.security.config.annotation.web.builders.HttpSecurity;
	import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
	import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
	import org.springframework.security.config.http.SessionCreationPolicy;
	import org.springframework.security.core.userdetails.UserDetailsService;
	import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

	@EnableWebSecurity
	public class SecurityConfig extends WebSecurityConfigurerAdapter {
		
		private final String [] PUBLIC_ENDPOINTS = {
				
				"/api/v1/auth/**", "/v2/api-docs", 
				"/configuration/ui", "/swagger-resources", 
				"/configuration/security", "/swagger-ui.html",
				"/webjars/**","/swagger-resources/configuration/ui"
		};
		
		@Autowired
	    UserDetailsService userDetailsService;
		

		@Override
		protected void configure(AuthenticationManagerBuilder auth) throws Exception {
			auth.userDetailsService(userDetailsService);
				}
		
		
		@Override
		protected void configure(HttpSecurity http) throws Exception {
			http
			.cors().and().csrf().disable()
			.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
			.and()
			.authorizeRequests()
			.antMatchers(PUBLIC_ENDPOINTS).permitAll()
			.anyRequest().authenticated()
			.and()
		.addFilterBefore(authFilter(), UsernamePasswordAuthenticationFilter.class);
		}
		
		
		@Bean
		protected AuthenticationManager authenticationManager() throws Exception {
			// TODO Auto-generated method stub
			return super.authenticationManager();
		}
		
		@Bean
		public AuthFilter authFilter () {
			
			return new AuthFilter() ;
		}

	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

//import javax.sql.DataSource;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//	
//	@Autowired
//	private DataSource dataSource;
//	
//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		//In Memory
////		auth.inMemoryAuthentication().withUser("role").password("{noop}123").authorities("ROLE_ADMIN")
////		.and()
////		.withUser("user").password("{noop}123").authorities("USER_ADMIN");
//		
//		auth.jdbcAuthentication().dataSource(dataSource).usersByUsernameQuery("").authoritiesByUsernameQuery("");
//	}
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		// TODO Auto-generated method stub
//		super.configure(http);
//	}
//
//}
