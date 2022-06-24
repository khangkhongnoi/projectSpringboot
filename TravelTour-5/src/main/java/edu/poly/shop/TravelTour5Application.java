package edu.poly.shop;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

import edu.poly.shop.config.StorageProperties;
import edu.poly.shop.service.StorageService;
import groovyjarjarantlr4.v4.runtime.misc.Args;
import groovyjarjarpicocli.CommandLine;

@SpringBootApplication
@EnableConfigurationProperties(StorageProperties.class)
public class TravelTour5Application {

	public static void main(String[] args) {
		SpringApplication.run(TravelTour5Application.class, args);
	}
	@Bean
	CommandLineRunner init(StorageService storageService) {
		return (args->{
			storageService.init();
		});
	}
}
