package cplayer.favourites.app;

import org.springframework.boot.SpringApplication;    

//// Spring Boot Application which will be used for the purpose of User Authentication

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

import cplayer.userauth.config.JWTFilter;

@SpringBootApplication
public class FavouritesApplication {
	
	@Bean
	public FilterRegistrationBean jwtFilter() {
		
		FilterRegistrationBean registrationbean = new FilterRegistrationBean();
		registrationbean.setFilter(new JWTFilter());
		registrationbean.addUrlPatterns("/api/*");
		return registrationbean;
		
	}

	public static void main(String[] args) {
		SpringApplication.run(FavouritesApplication.class, args);
	}

}
