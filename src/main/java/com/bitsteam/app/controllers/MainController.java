package com.bitsteam.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.bitsteam.app.models.User;
import com.bitsteam.app.rest.MainRestController;

@Controller
public class MainController {

	@Autowired
	MainRestController apiRest;

	@GetMapping("/")
	public String index(Model model) {

		User user = new User("Nicolás", "Sosa", 23);
		model.addAttribute("usuario", user);

		return "index";
	}

}
