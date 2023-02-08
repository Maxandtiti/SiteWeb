package fr.formation.inti.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.formation.inti.entity.MyEvents;
import fr.formation.inti.repository.MyEventsRepository;


@Service
public class MyEventsService {

	@Autowired
	MyEventsRepository myEventsRepo;
	
	private List < MyEvents > myEventslist = new ArrayList < > ();
	
	public void addMyevents(MyEvents myEvents) {
		myEventslist.add(myEvents);
	}
	
	
	
}
