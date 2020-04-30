package cplayer.recommended.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

import cplayer.userauth.config.JWTFilter;

@SpringBootApplication              //configuration class that declares one or more @Bean methods and also triggers auto-configuration and component scanning
public class RecommendedApplication {
	
	@Bean
	public FilterRegistrationBean jwtFilter() {
		
		FilterRegistrationBean registrationbean = new FilterRegistrationBean();
		registrationbean.setFilter(new JWTFilter());
		registrationbean.addUrlPatterns("/api/*");
		return registrationbean;
		
	}

	public static void main(String[] args) {
		SpringApplication.run(RecommendedApplication.class, args);
	}

}
