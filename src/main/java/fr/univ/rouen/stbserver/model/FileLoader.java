package fr.univ.rouen.stbserver.model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;

public class FileLoader {
	public String loadFile(String path) {
		StringBuilder message = new StringBuilder();
		Resource resource = new DefaultResourceLoader().getResource("classpath:"+path);
		BufferedReader br;
		try {
			br = new BufferedReader(new InputStreamReader(resource.getInputStream()));
			String output;
			while ((output = br.readLine()) != null) {
				message.append(output + "\n");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return message.toString();
		
	}

}
