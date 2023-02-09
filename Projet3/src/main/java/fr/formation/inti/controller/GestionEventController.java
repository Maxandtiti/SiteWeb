package fr.formation.inti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fr.formation.inti.repository.MyEventsRepository;


@Controller
public class GestionEventController {

	
	@Autowired
	private MyEventsRepository myEventsRepository;

	public GestionEventController(MyEventsRepository myEventsRepository) {
		this.myEventsRepository = myEventsRepository;
	}
	
	

	@GetMapping("/mesevenements/{idevent}")
	public String MyeventsGET(@PathVariable Integer idevent, Model model)  {	  
		model.addAttribute("user", myEventsRepository.findById(idevent).orElse(null));
	    return "CRUD";
	}
	
	
	
	@GetMapping("/edit/{idevent}")
	public String EditEventGET(@PathVariable Integer idevent, Model model)  {	  
		
	    return "formulaire";
	}
	
	
	
	
	@PostMapping("/mesevenements/delete")
	public String DeleteMyEventPOST(@RequestParam("idmyevents") Integer ID)  {	  
		myEventsRepository.deleteById(ID);
	    return "index";
	}
	
	
	
}
