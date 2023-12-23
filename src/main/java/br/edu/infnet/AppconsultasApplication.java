package br.edu.infnet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.openfeign.FeignAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
@ImportAutoConfiguration({FeignAutoConfiguration.class})

@EntityScan(basePackages = {"br.edu.infnet.model.domain"})
@EnableJpaRepositories(basePackages = {"br.edu.infnet.repository"})
public class AppconsultasApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppconsultasApplication.class, args);
	}

}
