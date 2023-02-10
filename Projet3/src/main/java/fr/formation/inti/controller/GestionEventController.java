package fr.formation.inti.controller;

import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fr.formation.inti.entity.MyEvents;
import fr.formation.inti.entity.UserApp;
import fr.formation.inti.repository.MyEventsRepository;
import fr.formation.inti.repository.UserAppRepository;


@Controller
public class GestionEventController {

	
	@Autowired
	private MyEventsRepository myEventsRepository;
	
	@Autowired
	private UserAppRepository userRepository;

	public GestionEventController(MyEventsRepository myEventsRepository) {
		this.myEventsRepository = myEventsRepository;
	}
	
	

	@GetMapping("/mesevenements/{idevent}")
	public String MyeventsGET(@PathVariable Integer idevent, Model model, HttpSession session, UserApp user, MyEvents myEvents)  {	 
//		model.addAttribute("user", myEventsRepository.findByIduser(idevent));
		Optional<UserApp> user1 = userRepository.findById(idevent);
		model.addAttribute("user", myEventsRepository.findByUserApp(user1));
		System.out.println("je suis rentrée dans le formulaire create");
//		System.out.println(model);
	    return "CRUD";
	}
	
	
	
	@GetMapping("/edit/{idevent}")
	public String EditEventGET(@PathVariable Integer idevent, Model model)  {	  
		
	    return "formulaire";
	}
	
	
	
	
	@PostMapping("/mesevenements/delete")
	public String DeleteMyEventPOST(@RequestParam("idmyevents") Integer ID, @RequestParam("idusers") Integer iduser)  {	  
		myEventsRepository.deleteById(ID);
	    return "redirect:/mesevenements/"+iduser;
	}
	
	
	
}
