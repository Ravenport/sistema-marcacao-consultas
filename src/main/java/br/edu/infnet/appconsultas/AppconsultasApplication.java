package br.edu.infnet.appconsultas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = {"br.edu.infnet.model.domain"} )
@EnableJpaRepositories(basePackages = {"br.edu.infnet.repository"})
public class AppconsultasApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppconsultasApplication.class, args);
	}

}
