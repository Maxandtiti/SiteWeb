package fr.formation.inti.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.formation.inti.entity.MyEvents;

public interface MyEventsRepository extends JpaRepository<MyEvents, Integer> {
	
//	List <MyEvents> findByIduser(Integer iduser);

}
