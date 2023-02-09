package fr.formation.inti.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import fr.formation.inti.entity.Formulaire;

@Controller
//@RestController
public class MainController {

	
	@GetMapping("/test")
	public String test( Model model) {
		return"test";
	}
	@GetMapping(value={"/","/index"})
	public String index(@ModelAttribute Formulaire formulaire,  Model model) {
		model.addAttribute("formulaire", formulaire);
		return"index";
	}
	

	
	
}
