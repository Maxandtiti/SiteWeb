package fr.formation.inti.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import fr.formation.inti.entity.Formulaire;

@Controller
public class SearchController {

	@PostMapping("/searchform")
	public String search(@ModelAttribute Formulaire formulaire, Model model, HttpSession session) {
		model.addAttribute("formulaire", formulaire);
		return "search";
	}

}
