package personal.starzonecn.example.oauth2.resource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "personal.starzonecn.example")
public class Oauth2ResourceApplication {

	public static void main(String[] args) {
		SpringApplication.run(Oauth2ResourceApplication.class, args);
	}
}

