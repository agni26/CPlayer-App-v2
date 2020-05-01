package cplayer.userauth.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

import cplayer.userauth.config.JWTFilter;

// Spring Boot Application which will be used for the purpose of User Authentication

@SpringBootApplication
public class UserApplication {
	
	@Bean
	public FilterRegistrationBean jwtFilter() {
		
		FilterRegistrationBean registrationbean = new FilterRegistrationBean();
		registrationbean.setFilter(new JWTFilter());
		registrationbean.addUrlPatterns("/api/auth/pro/*");
		return registrationbean;
		
	}

	public static void main(String[] args) {
		SpringApplication.run(UserApplication.class, args);
	}

}
