package ngcb.app.ngcb.config;

import java.io.Console;
import java.io.IOException;
import java.util.logging.LogManager;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import ch.qos.logback.classic.Logger;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

@Component
public class jwtFilter extends OncePerRequestFilter{
private final JwtService jwtService;
private final UserDetailsService userDetailsService;
	
	public jwtFilter(JwtService jwtService, UserDetailsService userDetailsService) {
	super();
	this.jwtService = jwtService;
	this.userDetailsService = userDetailsService;
}

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		// TODO Auto-generated method stub
		final String authHeader = request.getHeader("Authorization");
		final String jwt;
		final String userName;
		if (authHeader == null || !authHeader.startsWith("Bearer ")) {
		filterChain.doFilter(request, response);	
		return ;  
		}
		jwt = authHeader.substring(7);
		userName= jwtService.extractUserName(jwt);
		if(userName!= null && SecurityContextHolder.getContext().getAuthentication()==null) {
			UserDetails userDetails = this.userDetailsService.loadUserByUsername(userName);
			 if (jwtService.isTokenValid(jwt, userDetails) ) {
			        UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
			            userDetails,
			            null,
			            userDetails.getAuthorities()
			        );
			        authToken.setDetails(
			                new WebAuthenticationDetailsSource().buildDetails(request)
			            );
			        SecurityContextHolder.getContext().setAuthentication(authToken);
			        
			}
		}
		filterChain.doFilter(request,response);
	}

}
