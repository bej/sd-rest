package de.derjonk.dev;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.hateoas.config.EnableEntityLinks;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@EnableEntityLinks
public class App {
	public static void main(final String[] args) {
		SpringApplication.run(App.class, args);
	}
}
