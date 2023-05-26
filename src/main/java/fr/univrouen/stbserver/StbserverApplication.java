package fr.univrouen.stbserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan("fr.univ.rouen.stbserver.dao")
@ComponentScan("fr.univrouen.stbserver.controllers") // Assurez-vous d'inclure le package de vos contrôleurs

public class StbserverApplication {

	public static void main(String[] args) {
		SpringApplication.run(StbserverApplication.class, args);
	}

}
