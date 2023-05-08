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


public class AuthenticationService {

	private final utilisateurRepo repository;
	private PasswordEncoder passwordEncoder;
	private final JwtService jwtService;
	private final AuthenticationManager authenticationManager;
	

			public AuthenticationService(utilisateurRepo repository,PasswordEncoder passwordEncoder,JwtService jwtService,AuthenticationManager authenticationManager) {
				this.jwtService=jwtService;
				this.repository=repository;
				this.passwordEncoder=passwordEncoder;
				this.authenticationManager=authenticationManager;
			}
	
	

	public AuthenticationResponse register(RegisterRequest request) {
		
		var user = utilisateur.builder()
				.matricule(request.getMatricule())
		        .userName(request.getUserName())
		        .password(passwordEncoder.encode(request.getPassword()))
		        .role(request.getRole())
		        .fonction(request.getFonction())
		        .genre(request.getGenre())
		        .actif(request.getActif())
		        .nom(request.getNom())
		        .prenom(request.getPrenom())
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
	    System.out.println(user);
	    return AuthenticationResponse.builder()
				.token(jwtToken)
				.build()
				;
	  }

	 
	  }

