package ngcb.app.ngcb.resource;

import java.util.List;
import java.util.Optional;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ngcb.app.ngcb.model.role;
import ngcb.app.ngcb.model.signataire;
import ngcb.app.ngcb.model.utilisateur;

import ngcb.app.ngcb.service.utilisateurService;

@RestController
@RequestMapping("/utilisateur")
@CrossOrigin(origins = "http://localhost:4200")
public class utilisateurResource {
	
	private final utilisateurService UtilisateurService;
	
	public utilisateurResource(utilisateurService UtilisateurService) {
		this.UtilisateurService = UtilisateurService;
	}
	@PreAuthorize("isAuthenticated()")  
	@GetMapping("/all")
	public ResponseEntity<List<utilisateur>> getAllUtilisateursActif(){
		List<utilisateur> utilisateurs =UtilisateurService.findAllUtilisateursT();
		return new ResponseEntity<>(utilisateurs, HttpStatus.OK);
	}
	@PreAuthorize("isAuthenticated()")
	@GetMapping("/all/inactif")
	public ResponseEntity<List<utilisateur>> getAllUtilisateurs(){
		List<utilisateur> utilisateurs =UtilisateurService.findAllUtilisateursF();
		return new ResponseEntity<>(utilisateurs, HttpStatus.OK);
	}
	@PreAuthorize("isAuthenticated()")
	@PostMapping("/add")
	public ResponseEntity<utilisateur> addUtilisateur(@RequestBody utilisateur utilisateur){
		utilisateur newUtilisateur= UtilisateurService.createUser(utilisateur);
		return new ResponseEntity<>(newUtilisateur, HttpStatus.CREATED);
		
	}
	@PreAuthorize("isAuthenticated()")
	@PutMapping("/update")
	public ResponseEntity<utilisateur> updateUtilisateur(@RequestBody utilisateur utilisateur){
		utilisateur updateUtilisateur= UtilisateurService.updateUser(utilisateur);
		return new ResponseEntity<>(updateUtilisateur, HttpStatus.OK);
		
	}
	@PreAuthorize("isAuthenticated()")
	@PutMapping("/activer")
	public ResponseEntity<utilisateur> activerCompte(@RequestBody utilisateur utilisateur){
	  utilisateur 	updateUtilisateur =UtilisateurService.activéUser(utilisateur );
		return new ResponseEntity<>(updateUtilisateur, HttpStatus.OK);	
	}
	@PreAuthorize("isAuthenticated()")
	@PutMapping("/desactiver")
	public ResponseEntity<utilisateur> desactiverCompte(@RequestBody utilisateur utilisateur){
	  utilisateur 	updateUtilisateur =UtilisateurService.désactivéUser(utilisateur );
		return new ResponseEntity<>(updateUtilisateur, HttpStatus.OK);	
	} 
	
	@PreAuthorize("isAuthenticated()")
	@GetMapping("/courant")
    public ResponseEntity<utilisateur> getUtilisateurCourant() {
        Optional<utilisateur> utilisateur = UtilisateurService.getUtilisateurCourant();
        if (utilisateur.isPresent()) {
            return ResponseEntity.ok(utilisateur.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    @PreAuthorize("isAuthenticated()")
    @GetMapping("/role")
    public ResponseEntity<String> getUtilisateurRole() {
        Optional<utilisateur> utilisateurCourant = UtilisateurService.getUtilisateurCourant();
        if (utilisateurCourant.isPresent()) {
            String role = utilisateurCourant.get().getRole().toString();
            return ResponseEntity.ok(role);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    @PreAuthorize("isAuthenticated()")
    @GetMapping("/role/{role}")
    public ResponseEntity<List<utilisateur>> getUtilisateurByRole(@PathVariable("role")role role) {
        List<utilisateur> utilisateur = UtilisateurService.getUtilsateurByRole(role);
        if (utilisateur.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(utilisateur);
        }
    }
    @PreAuthorize("isAuthenticated()")
	@GetMapping("/fonction")
	public ResponseEntity<List<String>> getFonctions() {
        List<String> fonctions = UtilisateurService.getFonctions();
        return new ResponseEntity<>(fonctions, HttpStatus.OK);
    }
    
    @PreAuthorize("isAuthenticated()")
    @GetMapping("/fonction/{fonction}")
    public ResponseEntity<List<utilisateur>> getUtilisateurByFonction(@PathVariable("fonction")String fonction) {
        List<utilisateur> utilisateur = UtilisateurService.getUtilisateurByFonction(fonction);
        if (utilisateur.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(utilisateur);
        }
    }


	}


