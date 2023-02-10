package fr.formation.inti.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import fr.formation.inti.entity.UserApp;
import fr.formation.inti.repository.UserAppRepository;


@Service
public class MyDBAuthenticationService implements UserDetailsService {

	@Autowired
	private UserAppRepository usersRepository;

	// cherche email
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		UserApp u = usersRepository.findByEmail(email);
		if (u == null) {
			throw new UsernameNotFoundException("User " + email + " n'est pas dans la bd");
		}

		System.out.println("Avant attribution role : " + u);

		// charge les détails sur user pendant l'authentification
		// [USER,ADMIN,..]
		List<GrantedAuthority> grantList = new ArrayList<GrantedAuthority>();
		// ROLE_USER, ROLE_ADMIN,..
		// SUPERADMIN = ADMIN ET USER
		if ("SUPERADMIN".equals(u.getRole())) {
			GrantedAuthority authority = new SimpleGrantedAuthority("ROLE_SUPERADMIN");
			grantList.add(authority);
			authority = new SimpleGrantedAuthority("ROLE_ADMIN");
			grantList.add(authority);
		} else if ("ADMIN".equals(u.getRole())) {
			GrantedAuthority authority = new SimpleGrantedAuthority("ROLE_ADMIN");
			grantList.add(authority);
		}
//		}else if (u.getRole().isEmpty() || "USER".equals(u.getRole()) || "".equals(u.getRole())) {
			
		GrantedAuthority authority = new SimpleGrantedAuthority("ROLE_USER");
		grantList.add(authority);
		UserDetails userDetails = (UserDetails) new User(u.getEmail(), //
				u.getPassword(), grantList);

		System.out.println("Apres attrib role" + userDetails.getAuthorities());

		return userDetails;
	}

	}

