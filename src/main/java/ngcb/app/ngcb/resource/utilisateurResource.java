package ngcb.app.ngcb.resource;

import java.util.List;

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
	}}


