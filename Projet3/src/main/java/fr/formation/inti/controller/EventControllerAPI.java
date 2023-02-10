package fr.formation.inti.controller;


import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.formation.inti.entity.MyEvents;
import fr.formation.inti.entity.UserApp;
import fr.formation.inti.repository.MyEventsRepository;
import fr.formation.inti.repository.UserAppRepository;



@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/myevents")
public class EventControllerAPI {
	
	
	
	
	@Autowired
	private MyEventsRepository myEventsRepository;
	
	@Autowired
	private UserAppRepository userRepository;
	

	public EventControllerAPI(MyEventsRepository myEventsRepository) {
		super();
		this.myEventsRepository = myEventsRepository;
	}



	/**
	 * Get findAll
	 * @return All MyEvents
	 */


	@GetMapping
	public List<MyEvents> getAll(){
		return myEventsRepository.findAll();
	}
	
	

	/**
	 * Get findById
	 * @param idmyevents
	 * @return One MyEvents
	 */
	
	
	@GetMapping("/{idmyevents}")
	public List<MyEvents> getById(@PathVariable Integer idmyevents, HttpSession session, UserApp user, MyEvents myEvents){
		Optional<UserApp> user1 = userRepository.findById(idmyevents);
		List<MyEvents> list = myEventsRepository.findByUserApp(user1);
		System.out.println(list);
//		return myEventsRepository.findById(idmyevents).orElse(null);
		return myEventsRepository.findByUserApp(user1);
	}
	
	
	/**
	 * Post Save
	 * @param MyEvents
	 * @return save MyEvents
	 */
	
	
	@PostMapping()
	public MyEvents add(@RequestBody MyEvents myevent){
		return myEventsRepository.save(myevent);
	}
	
	
	
	/**
	 * Post Update
	 * @param idmyevents
	 * @param Employee
	 * @return Update MyEvents
	 */
	
	
	@PutMapping("/{idmyevents}")
	public MyEvents update(@PathVariable Integer idmyevents, @RequestBody MyEvents myevent){
		myevent.setIdmyevents(idmyevents);
		return myEventsRepository.save(myevent);
	}
	
	
	
	/**
	 * Post Delete
	 * @param empId
	 * Delete MyEvents
	 */
	
	
	@DeleteMapping("/{idmyevents}")
	public void update(@PathVariable Integer idmyevents){
		myEventsRepository.deleteById(idmyevents);
	}
	
	
}