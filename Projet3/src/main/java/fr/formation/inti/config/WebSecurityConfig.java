package fr.formation.inti.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
//@EnableWebSecurity = @EnableWebMVCSecurity + Extra features
//applique automatiquement la classe à la global WebSecurity
@EnableWebSecurity
//chargement 1 fois
//stock règle authentif et de sécurité
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	MyDBAuthenticationService myDBAauthenticationService;

	
	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		// For User in database.
		auth.userDetailsService(myDBAauthenticationService).passwordEncoder(getpasswordEncoder());
		System.out.println("WebSecurityConfig_userDetailsService");
	}
	
	@Bean
    public BCryptPasswordEncoder getpasswordEncoder() {
		System.out.println("WebSecurityConfig_BCryptPasswordEncoder");
        return new BCryptPasswordEncoder();
    }
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		System.out.println("WebSecurityConfig_ConfigBegin");
		//cross site request forgery
		//simplifier les interactions entre un client et le serveur
		//mais site vulnérable
		http.csrf().disable();

		// The pages does not require login
		http.authorizeRequests().antMatchers("/", "/welcome", "/login", "/logout").permitAll();

		// /userInfo page requires login as USER or ADMIN.
		// If no login, it will redirect to /login page.
		http.authorizeRequests().antMatchers("/userInfo").access("hasAnyRole('ROLE_USER', 'ROLE_ADMIN')");

		// For ADMIN only.
		http.authorizeRequests().antMatchers("/admin").access("hasRole('ROLE_ADMIN')");

		// When the user has logged in as XX.
		// But access a page that requires role YY,
		// AccessDeniedException will throw.
		http.authorizeRequests().and().exceptionHandling().accessDeniedPage("/403");

		// Config for Login Form
		http.authorizeRequests().and().formLogin()//
				// Submit URL of login page.
				.loginProcessingUrl("/j_spring_security_check") // Submit URL
				.loginPage("/login")//
				.defaultSuccessUrl("/userInfo")//
				.failureUrl("/login?error=true")//
				.usernameParameter("username")//
				.passwordParameter("password")
				// Config for Logout Page
				.and().logout().logoutUrl("/logout").logoutSuccessUrl("/logoutSuccessful");
		System.out.println("WebSecurityConfig_ConfigEnd");
	}
}
