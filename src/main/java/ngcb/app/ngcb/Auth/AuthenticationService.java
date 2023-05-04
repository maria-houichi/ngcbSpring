package ngcb.app.ngcb.Auth;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import ngcb.app.ngcb.config.JwtService;
import ngcb.app.ngcb.model.utilisateur;
import ngcb.app.ngcb.repo.utilisateurRepo;

@Service
@RequiredArgsConstructor

public class AuthenticationService {

	private final utilisateurRepo repository;
	private PasswordEncoder passwordEncoder;
	private final JwtService jwtService;
	private final AuthenticationManager authenticationManager;

	public AuthenticationResponse register(RegisterRequest request) {
		
		var user = utilisateur.builder()
		        .userName(request.getUserName())
		        .password(passwordEncoder.encode(request.getPassword()))
		        .role(request.getRole())
		        .build();
			       repository.save(user) ;
			       var jwtToken = jwtService.generateToken(user);
		return AuthenticationResponse.builder()
				.token(jwtToken)
				.build()
				;
	}
	

	  public AuthenticationResponse authenticate(AuthenticationRequest request) {
	    authenticationManager.authenticate(
	        new UsernamePasswordAuthenticationToken(
	            request.getUserName(),
	            request.getPassword()
	        )
	    );
	    var user = repository.findUtilisateurByUserName(request.getUserName())
	        .orElseThrow();
	    var jwtToken = jwtService.generateToken(user);
	    return AuthenticationResponse.builder()
				.token(jwtToken)
				.build()
				;
	  }

	 
	  }


