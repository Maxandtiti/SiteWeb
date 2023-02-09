package fr.formation.inti.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import fr.formation.inti.entity.UserApp;

public interface UserAppRepository extends JpaRepository<UserApp, Integer> {

	@Query("SELECT u FROM UserApp u WHERE u.email = ?1")
	public UserApp findByEmail(String email);

	

	
}
