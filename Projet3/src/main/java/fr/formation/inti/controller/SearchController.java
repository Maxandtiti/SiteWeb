package fr.formation.inti.controller;

import java.security.Principal;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import fr.formation.inti.entity.Formulaire;
import fr.formation.inti.entity.UserApp;
import fr.formation.inti.repository.UserAppRepository;

@Controller
public class SearchController {
	@Autowired
	private UserAppRepository userRepository;

	@GetMapping("/searchform")
	public String getsearch(@ModelAttribute Formulaire formulaire, Model model, HttpSession session, Principal principal) {
		model.addAttribute("formulaire", formulaire);
		String email = principal.getName();
		UserApp userconnected = userRepository.findByEmail(email);
		session.setAttribute("user", userconnected);
		System.out.println(userconnected);
		return "search";
	}
	
	
	@GetMapping("/login_infos")
	public String getsearchLOGIN(@ModelAttribute Formulaire formulaire,  Model model) {
		model.addAttribute("formulaire", formulaire);
		formulaire.setCity("Tourcoing");
		return "search";
	}
	
	
	@PostMapping("/searchform")
	public String search(@ModelAttribute Formulaire formulaire, Model model) {
		model.addAttribute("formulaire", formulaire);
		return "search";
	}

}
