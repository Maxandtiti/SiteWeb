package fr.formation.inti.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import fr.formation.inti.entity.UserApp;
import fr.formation.inti.repository.UserAppRepository;

public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private UserAppRepository userRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserApp user = userRepo.findByEmail(username);
		if (user == null) {
			throw new UsernameNotFoundException("User not found");
		}
		return new CustomUserDetails(user);
	}

	public void createUser(UserDetails user) {
		userRepo.save((UserApp) user);
	}

}
