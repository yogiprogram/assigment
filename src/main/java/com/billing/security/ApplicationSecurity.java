package com.billing.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.csrf.CsrfFilter;

@Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
public class ApplicationSecurity extends WebSecurityConfigurerAdapter {

	@Autowired
	private CustomAuthenticationEntryPoint authenticationEntryPoint;

	@Autowired
	private CustomAuthenticationFailureHandler authenticationFailureHandler;

	@Autowired
	private CustomAuthenticationSuccessHandler authenticationSuccessHandler;

	@Override
	protected void configure(AuthenticationManagerBuilder builder) throws Exception {
		builder.inMemoryAuthentication()
				.withUser("user").password("user").roles("USER")
				.and().withUser("admin").password("admin").roles("ADMIN");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.httpBasic().and().authorizeRequests().antMatchers("/rest/**").authenticated();
		http.exceptionHandling().authenticationEntryPoint(authenticationEntryPoint);
		http.formLogin().successHandler(authenticationSuccessHandler);
		http.formLogin().failureHandler(authenticationFailureHandler);
		http.logout().logoutSuccessUrl("/") ;
		http.csrf().disable();
		/*// CSRF tokens handling
		http.addFilterAfter(new CsrfTokenResponseHeaderBindingFilter(), CsrfFilter.class);*/
	}
}
