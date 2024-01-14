package com.bitsteam.app.rest;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bitsteam.app.models.User;

@RestController
@RequestMapping("/api")
public class MainRestController {
	
	@Value("#{('Nicolás' + ' ' + 'Sosa').toUpperCase()}")
	private String variable1;
	
	@Value("${variable.two}")
	private String variable2;
	
	@Autowired
	private Environment entorno;

	@GetMapping("/persona/{id}")
	public User obtenerPersonas(@PathVariable("id") int index) {
		
		User[] usuarios = {
				new User("Nicolas", "Sosa", 23),
				new User("Angie", "Chipatécua", 23),
				new User("Byron", "Vergara", 23),
				new User("Duvan", "Vargas", 23),
				new User("Sergio", "Blanco", 25) 
				};

		return usuarios[index];
	}
	
	@PostMapping("/crear")
	public Map<String, Object> crearUsuario(@RequestBody User usuario) {
		Map<String, Object> jsonResponse = new HashMap<>();
		
		jsonResponse.put("mensaje", "usuario creado :D");
		jsonResponse.put("data", usuario);
		
		return jsonResponse;
	}
	
	@GetMapping(value = "/variables")
	public Map<String, Object> obtenerVariables(@Value("${variable.three}") String variable3) {
		Map<String, Object> jsonResponse = new HashMap<>();
		
		jsonResponse.put("var1", variable1);
		jsonResponse.put("var2", variable2);
		jsonResponse.put("var3", variable3);
		jsonResponse.put("var2-env", entorno.getProperty("variable.three", "null"));
		
		System.out.println("variable 1: " + jsonResponse.get("var3"));
		
		return jsonResponse;
	}

}
