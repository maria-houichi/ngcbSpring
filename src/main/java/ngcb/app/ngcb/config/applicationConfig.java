package ngcb.app.ngcb.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import ngcb.app.ngcb.utilisateurNotFoundException;
import ngcb.app.ngcb.repo.utilisateurRepo;

@Configuration
public class applicationConfig {
	private final utilisateurRepo UtilisateurRepo ;
	
	public applicationConfig(utilisateurRepo utilisateurRepo) {
		super();
		UtilisateurRepo  = utilisateurRepo;
	}
	
@Bean
public UserDetailsService userDetailsService() {
    return username -> UtilisateurRepo.findUtilisateurByUserName(username)
        .orElseThrow(() -> new utilisateurNotFoundException("User not found"));
  }

@Bean
public AuthenticationProvider authenticationProvider() {
  DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
  authProvider.setUserDetailsService(userDetailsService());
  authProvider.setPasswordEncoder(passwordEncoder());
  return authProvider;
}

@Bean
public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
  return config.getAuthenticationManager();
}

@Bean
public PasswordEncoder passwordEncoder() {
  return new BCryptPasswordEncoder();
}


}
