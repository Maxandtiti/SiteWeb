package fr.formation.inti.dao;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import fr.formation.inti.entity.UserApp;

@Repository
public class UserAppDao {

	 // Config in WebSecurityConfig
    @Autowired
    private PasswordEncoder passwordEncoder;

    private static final Map<Long, UserApp> USERS_MAP = new HashMap<>();
    
    
}
