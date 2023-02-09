package fr.formation.inti.controller;


import java.util.List;

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

import fr.formation.inti.repository.MyEventsRepository;



@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/myevents")
public class EventController {
	
	
	
	
	@Autowired
	private MyEventsRepository myEventsRepository;
	

	public EventController(MyEventsRepository myEventsRepository) {
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
	public MyEvents getById(@PathVariable Integer idmyevents){
		return myEventsRepository.findById(idmyevents).orElse(null);
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