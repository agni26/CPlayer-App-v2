package cplayer.recommended.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication              //configuration class that declares one or more @Bean methods and also triggers auto-configuration and component scanning
public class RecommendedApplication {

	public static void main(String[] args) {
		SpringApplication.run(RecommendedApplication.class, args);
	}

}
