package com.billing.security.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import com.billing.security.ApplicationSecurity;

@ComponentScan("com")
@EnableAutoConfiguration
public class Application {

	@Bean
	public WebSecurityConfigurerAdapter webSecurityConfigurerAdapter() {
		return new ApplicationSecurity();
	}

	public static void main(String[] args) {
		SpringApplication application = new SpringApplication(Application.class);
		application.run(args);
	}
}
