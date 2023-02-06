package fr.formation.inti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fr.formation.inti.entity.UserApp;
import fr.formation.inti.repository.UserAppRepository;

@Controller
public class MyAccountController {

	@Autowired
	private UserAppRepository userRepository;
	

	
	public MyAccountController() {
	}

	


	@ModelAttribute("user")
	public UserApp createUserModel() {
	
		return new UserApp();
	}
	
	
	

	@GetMapping("/moncompte/{idusers}")
	public String updateUserGet(@PathVariable Integer idusers, Model model)  {	  
		model.addAttribute("user", userRepository.findById(idusers).orElse(null));
	    return "moncompte";
	}

		
	@PostMapping("/moncompte")
	public String updateUserPost(@ModelAttribute UserApp user)  {	 
		UserApp utilisateur = userRepository.findById(user.getidusers()).orElse(null);
	
		utilisateur.setfirstName(user.getfirstName());
		utilisateur.setlastName(user.getlastName());
		utilisateur.setAdress(user.getAdress());
		utilisateur.setCity(user.getCity());
		utilisateur.setZipcode(user.getZipcode());
		
		
		userRepository.save(utilisateur);
		System.out.println(user);
	    return "redirect:/moncompte/"+user.getidusers();
	}
	
	
	
	@PostMapping("/updatePassword")
	public String updatePasswordPost(@ModelAttribute UserApp user/*, @RequestParam("oldinputpass") String oldinputpass, Model model*/)  {	 
		UserApp utilisateur = userRepository.findById(user.getidusers()).orElse(null);
	//	String oldpass = utilisateur.getPassword();
		String newpass = user.getPassword();

	//	boolean error;

		utilisateur.setPassword(newpass);
		userRepository.save(utilisateur);
		return "redirect:/moncompte/"+user.getidusers();
		
		
		/*
		if (oldinputpass.equals(oldpass)) {

			return "redirect:/moncompte/"+user.getidusers();
		
		} else {
			
			error = false;

			model.addAttribute("error", error);
			model.addAttribute("errormessage", "Mauvais mot de passe");
			
			
			
			
		}
		*/
		
		
	
		
		
	}
	
	
	
	/*
	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public String editEmpPOST(@Validated @ModelAttribute("emp") Employee employee, BindingResult br, Model model) throws java.text.ParseException  {
			

		empService.saveEmployee(employee);
		logger.warn("Info de l'edit de l'employé : " + employee);
	    return "redirect:/listEmployee";
	
	}
	}
	*/
}
