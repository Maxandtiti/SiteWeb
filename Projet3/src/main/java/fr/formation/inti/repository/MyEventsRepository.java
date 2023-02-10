package fr.formation.inti.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import fr.formation.inti.entity.MyEvents;
import fr.formation.inti.entity.UserApp;

public interface MyEventsRepository extends JpaRepository<MyEvents, Integer> {

//	List <MyEvents> findByIduser(Integer iduser);

	@Query("SELECT u FROM MyEvents u where u.user = ?1")
	List<MyEvents> findByUserApp(Optional<UserApp> user1);

	@Query("SELECT u FROM MyEvents u where u.user = ?1")
	Optional<UserApp> findAll(Optional<UserApp> user1);

}
