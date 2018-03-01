package es.tintomax.server;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages={"es.tintomax.server.jpa", "es.tintomax.server.repositories"})
@ComponentScan(basePackages = "es.tintomax")
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
