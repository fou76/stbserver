package fr.univrouen.stbserver.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.univ.rouen.stbserver.model.FileLoader;

@RestController

public class IndexController {
	@GetMapping(path = "/", produces = "text/html")
	public String index() {
		return new FileLoader().loadFile("html/index.html");
	}

}
