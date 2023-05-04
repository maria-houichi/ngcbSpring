package ngcb.app.ngcb.config;
import jakarta.servlet.Filter;
import lombok.RequiredArgsConstructor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import static org.springframework.http.HttpMethod.DELETE;
import static org.springframework.http.HttpMethod.GET;
import static org.springframework.http.HttpMethod.POST;
import static org.springframework.http.HttpMethod.PUT;
@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
@EnableMethodSecurity
public class SecurityConfig {

private final  jwtFilter jwtFilter;
private AuthenticationProvider AuthenticationProvider;

public SecurityFilterChain securityFilterCain(HttpSecurity http)throws Exception {
	http 
	 .csrf()
     .disable()
     .authorizeHttpRequests()
     .requestMatchers("/**").permitAll()
      .anyRequest()
      .authenticated()
      .and()
        .sessionManagement()
        .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
      .and()
      .authenticationProvider(AuthenticationProvider)
      .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);

	 return http.build();
}}
