package fr.formation.inti.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import fr.formation.inti.entity.Users;

public interface UsersRepository extends JpaRepository<Users, Integer> {
	@Query("SELECT u FROM Users u WHERE u.email = ?1")
	public Users findByEmail(String email);

}
