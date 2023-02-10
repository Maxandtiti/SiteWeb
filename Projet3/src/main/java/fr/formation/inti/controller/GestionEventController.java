package fr.formation.inti.controller;

import java.text.SimpleDateFormat;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
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
		model.addAttribute("myevent", myEventsRepository.findById(idevent).orElse(null));
	    return "formulaireEDIT";
	}
	
	
	@PostMapping("/editEvent")
	public String EditEventPOST(@RequestParam("idusers") Integer iduser, @ModelAttribute MyEvents event, @RequestParam("idmyevents") Integer idevent)  {	  
		MyEvents monevent = myEventsRepository.findById(idevent).orElse(null);
		
		System.out.println("Sysout de monevent : "+monevent);
		monevent.setTitle(event.getTitle());
		monevent.setPreview(event.getPreview());
		monevent.setLongdescription(event.getLongdescription());
		monevent.setKeywords(event.getKeywords());
		monevent.setAdress_perso(event.getAdress_perso());
		monevent.setAccessibility(event.getAccessibility());
		monevent.setTimes(event.getTimes());
		monevent.setAddress(event.getAddress());
		monevent.setCity(event.getCity());
		monevent.setZipcode(event.getZipcode());
		monevent.setFirstdate_begin(event.getFirstdate_begin());
		monevent.setFirstdate_end(event.getFirstdate_end());
		monevent.setConditions(event.getConditions());
		
		
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssXXX");
		String firstdate_begin = dateFormat.format(monevent.getFirstdate_begin());
		String firstdate_end = dateFormat.format(monevent.getFirstdate_end());

		String detailed_times_string = "[{\"begin\": \"" + firstdate_begin +  "\", \"end\": \"" + firstdate_end + "\"}]";
		
		monevent.setDetailed_times(detailed_times_string);
		
		
		
		
		
		
		Integer id = monevent.getUser().getidusers();
		myEventsRepository.save(monevent);
	    return "redirect:/mesevenements/"+id;
	}
	
	
	
	
	@PostMapping("/mesevenements/delete")
	public String DeleteMyEventPOST(@RequestParam("idmyevents") Integer ID, @RequestParam("idusers") Integer iduser)  {	  
		myEventsRepository.deleteById(ID);
	    return "redirect:/mesevenements/"+iduser;
	}
	
	
	
}
