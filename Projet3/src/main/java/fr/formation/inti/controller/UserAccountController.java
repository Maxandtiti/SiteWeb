package fr.formation.inti.controller;

import java.security.Principal;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import fr.formation.inti.entity.ConfirmationToken;
import fr.formation.inti.entity.MyEvents;
import fr.formation.inti.entity.UserApp;
import fr.formation.inti.repository.ConfirmationTokenRepository;
import fr.formation.inti.repository.MyEventsRepository;
import fr.formation.inti.repository.UserAppRepository;
import fr.formation.inti.service.EmailSenderService;

@Controller
public class UserAccountController {

	@Autowired
	private UserAppRepository userRepository;

	@Autowired
	private ConfirmationTokenRepository confirmationTokenRepository;

	@Autowired
	private EmailSenderService emailSenderService;

	@Autowired
	private MyEventsRepository MyEventsRepo;

	BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

	// Login
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView displayLogin(ModelAndView modelAndView, UserApp user) {
		modelAndView.addObject("user", user);
		modelAndView.setViewName("logIn");
		return modelAndView;
	}

	@RequestMapping(value = "/createEvent", method = RequestMethod.POST)
	public String newEvent(MyEvents myEvents) {
		System.out.println("je suis rentrée dans le formulaire create");
		MyEventsRepo.save(myEvents);
		System.out.println(myEvents);
		return "index";

	}

	@RequestMapping(value = "/createEvent", method = RequestMethod.GET)
	public ModelAndView addNewEvent() {
		System.out.println("je suis dans le formulaire");
		MyEvents event = new MyEvents();
		return new ModelAndView("formulaire", "form", event);

	}

	// Registration
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public ModelAndView displayRegistration(ModelAndView modelAndView, UserApp user) {
		modelAndView.addObject("user", user);
		modelAndView.setViewName("register");
		return modelAndView;
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ModelAndView registerUser(ModelAndView modelAndView, UserApp user) {

		UserApp existingUser = userRepository.findByEmail(user.getEmail());
		if (existingUser != null) {
			modelAndView.addObject("message", "Cet email existe déjà !");
			modelAndView.setViewName("error");
		} else {
			user.setPassword(encoder.encode(user.getPassword()));
			user.setRole("USER");
			userRepository.save(user);

			ConfirmationToken confirmationToken = new ConfirmationToken(user);

			confirmationTokenRepository.save(confirmationToken);

			SimpleMailMessage mailMessage = new SimpleMailMessage();
			mailMessage.setTo(user.getEmail());
			mailMessage.setSubject("Confirmer votre inscription");
			mailMessage.setFrom("eventwebapp212@gmail.com");
			mailMessage.setText("Pour confirmer votre compte, cliquez ici : "
					+ "http://localhost:8080/confirm-account?token=" + confirmationToken.getConfirmationToken());

			emailSenderService.sendEmail(mailMessage);

			modelAndView.addObject("email", user.getEmail());

			modelAndView.setViewName("successfulRegisteration");
		}

		return modelAndView;
	}
	

	
//	A APPROFONDIR
//	
//	@RequestMapping(value = "/register", method = RequestMethod.POST)
//	public ModelAndView registerUser(ModelAndView modelAndView, UserApp user) {
//	    // Check for valid email format
//	    String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
//	    Pattern pattern = Pattern.compile(emailRegex);
//	    Matcher matcher = pattern.matcher(user.getEmail());
//	    if (!matcher.matches()) {
//	        modelAndView.addObject("message", "Email format incorrect");
//	        modelAndView.setViewName("error");
//	    } else {
//	        UserApp existingUser = userRepository.findByEmail(user.getEmail());
//	        if (existingUser != null) {
//	            modelAndView.addObject("message", "Cet email existe déjà !");
//	            modelAndView.setViewName("error");
//	        } else {
//	            user.setPassword(encoder.encode(user.getPassword()));
//	            user.setRole("USER");
//	            userRepository.save(user);
//
//	            ConfirmationToken confirmationToken = new ConfirmationToken(user);
//
//	            confirmationTokenRepository.save(confirmationToken);
//
//	            SimpleMailMessage mailMessage = new SimpleMailMessage();
//	            mailMessage.setTo(user.getEmail());
//	            mailMessage.setSubject("Confirmer votre inscription");
//	            mailMessage.setFrom("eventwebapp212@gmail.com");
//	            mailMessage.setText("Pour confirmer votre compte, cliquez ici : "
//	                    + "http://localhost:8080/confirm-account?token=" + confirmationToken.getConfirmationToken());
//
//	            emailSenderService.sendEmail(mailMessage);
//
//	            modelAndView.addObject("email", user.getEmail());
//
//	            modelAndView.setViewName("successfulRegisteration");
//	        }
//	    }
//
//	    return modelAndView;
//	}

	
	
	
	

	// Confirm registration
	@RequestMapping(value = "/confirm-account", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView confirmUserAccount(ModelAndView modelAndView, @RequestParam("token") String confirmationToken) {
		ConfirmationToken token = confirmationTokenRepository.findByConfirmationToken(confirmationToken);

		if (token != null) {
			UserApp user = userRepository.findByEmail(token.getUser().getEmail());
			user.setEnabled(true);
			userRepository.save(user);
			modelAndView.setViewName("accountVerified");
		} else {
			modelAndView.addObject("message", "Le lien est invalide ou cassé !");
			modelAndView.setViewName("error");
		}

		return modelAndView;
	}

	/**
	 * Display the forgot password page and form
	 */
	@RequestMapping(value = "/forgot-password", method = RequestMethod.GET)
	public ModelAndView displayResetPassword(ModelAndView modelAndView, UserApp user) {
		modelAndView.addObject("user", user);
		modelAndView.setViewName("forgotPassword");
		return modelAndView;
	}

	/**
	 * Receive email of the user, create token and send it via email to the user
	 */
	@RequestMapping(value = "/forgot-password", method = RequestMethod.POST)
	public ModelAndView forgotUserPassword(ModelAndView modelAndView, UserApp user) {
		UserApp existingUser = userRepository.findByEmail(user.getEmail());
		if (existingUser != null) {
			// create token
			ConfirmationToken confirmationToken = new ConfirmationToken(existingUser);

			// save it
			confirmationTokenRepository.save(confirmationToken);

			// create the email
			SimpleMailMessage mailMessage = new SimpleMailMessage();
			mailMessage.setTo(existingUser.getEmail());
			mailMessage.setSubject("Réinitialisation du mot de passe");
			mailMessage.setFrom("eventwebapp212@gmail.com");
			mailMessage
					.setText("Pour terminer la procédure de réinitialisation du mot de passe, veuillez cliquer ici : "
							+ "http://localhost:8080/confirm-reset?token=" + confirmationToken.getConfirmationToken());

			emailSenderService.sendEmail(mailMessage);

			modelAndView.addObject("message",
					"Demande de réinitialisation du mot de passe reçue. Vérifiez votre boîte de réception pour le lien de réinitialisation.");
			modelAndView.setViewName("successForgotPassword");

		} else {
			modelAndView.addObject("message", "Cet email n'existe pas !");
			modelAndView.setViewName("error");
		}

		return modelAndView;
	}

	@RequestMapping(value = "/confirm-reset", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView validateResetToken(ModelAndView modelAndView, @RequestParam("token") String confirmationToken) {
		ConfirmationToken token = confirmationTokenRepository.findByConfirmationToken(confirmationToken);

		if (token != null) {
			UserApp user = userRepository.findByEmail(token.getUser().getEmail());
			user.setEnabled(true);
			userRepository.save(user);
			modelAndView.addObject("user", user);
			modelAndView.addObject("email", user.getEmail());
			modelAndView.setViewName("resetPassword");
		} else {
			modelAndView.addObject("message", "Le lien est invalide ou cassé !");
			modelAndView.setViewName("error");
		}

		return modelAndView;
	}

	/**
	 * Receive the token from the link sent via email and display form to reset
	 * password
	 */
	@RequestMapping(value = "/reset-password", method = RequestMethod.POST)
	public ModelAndView resetUserPassword(ModelAndView modelAndView, UserApp user) {
		// ConfirmationToken token =
		// confirmationTokenRepository.findByConfirmationToken(confirmationToken);

		if (user.getEmail() != null) {
			// use email to find user
			UserApp tokenUser = userRepository.findByEmail(user.getEmail());
			tokenUser.setEnabled(true);
			tokenUser.setPassword(encoder.encode(user.getPassword()));
			// System.out.println(tokenUser.getPassword());
			userRepository.save(tokenUser);
			modelAndView.addObject("message",
					"Le mot de passe a été réinitialisé avec succès. Vous pouvez maintenant vous connecter avec les nouvelles informations d'identification.");
			modelAndView.setViewName("successResetPassword");
		} else {
			modelAndView.addObject("message", "Le lien est invalide ou cassé !");
			modelAndView.setViewName("error");
		}

		return modelAndView;
	}

	@GetMapping(value = "/eventinfo")
	public String userInfo(Model model, Principal principal, UserApp user, HttpSession session) {

		return "eventinfo";
	}

//	public UserAppRepository getUserRepository() {
//		return userRepository;
//	}
//
//	public void setUserRepository(UserAppRepository userRepository) {
//		this.userRepository = userRepository;
//	}
//
//	public ConfirmationTokenRepository getConfirmationTokenRepository() {
//		return confirmationTokenRepository;
//	}
//
//	public void setConfirmationTokenRepository(ConfirmationTokenRepository confirmationTokenRepository) {
//		this.confirmationTokenRepository = confirmationTokenRepository;
//	}
//
//	public EmailSenderService getEmailSenderService() {
//		return emailSenderService;
//	}
//
//	public void setEmailSenderService(EmailSenderService emailSenderService) {
//		this.emailSenderService = emailSenderService;
//	}

}
