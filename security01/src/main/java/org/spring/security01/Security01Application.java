package org.spring.security01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class Security01Application {

	public static void main(String[] args) {
		SpringApplication.run(Security01Application.class, args);
	}

}
