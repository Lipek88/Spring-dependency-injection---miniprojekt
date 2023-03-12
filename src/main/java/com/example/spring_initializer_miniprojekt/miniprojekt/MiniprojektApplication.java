package com.example.spring_initializer_miniprojekt.miniprojekt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

//@SpringBootApplication
public class MiniprojektApplication {

	public static void main(String[] args) throws IOException {
		ProductRepositoryCSV productRepositoryCSV = new ProductRepositoryCSV();
		ProductRepositoryJSON productRepositoryJSON = new ProductRepositoryJSON();
//		SpringApplication.run(MiniprojektApplication.class, args);

//		productRepositoryCSV.parse();
		productRepositoryJSON.parse();
	}

}
