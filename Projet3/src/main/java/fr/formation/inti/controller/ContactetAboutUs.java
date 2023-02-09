package fr.formation.inti.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ContactetAboutUs {




	@GetMapping(value="/contacts")
	public String nousContacter() {
		
		
		return "contacts";
	}
	
	
	@GetMapping(value="/AboutUs")
	public String APropos() {
		
		
		return "about";
	}
	
}
