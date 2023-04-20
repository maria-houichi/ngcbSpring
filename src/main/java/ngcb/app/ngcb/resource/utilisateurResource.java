package ngcb.app.ngcb.resource;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
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
public class utilisateurResource {
	private final utilisateurService UtilisateurService;
	public utilisateurResource(utilisateurService UtilisateurService) {
		this.UtilisateurService = UtilisateurService;
	}
	@GetMapping("/all")
	public ResponseEntity<List<utilisateur>> getAllUtilisateurs(){
		List<utilisateur> utilisateurs =UtilisateurService.findAllUtilisateurs();
		return new ResponseEntity<>(utilisateurs, HttpStatus.OK);
	}

	@GetMapping("/find/{nom}")
	public ResponseEntity<utilisateur> getutilisateurBy(@PathVariable("nom")String nom){
		utilisateur utilisateur =UtilisateurService.findUtilisateurByNom(nom);
		return new ResponseEntity<>(utilisateur,HttpStatus.OK );
	}

	@PostMapping("/add")
	public ResponseEntity<utilisateur> addUtilisateur(@RequestBody utilisateur utilisateur){
		utilisateur newUtilisateur= UtilisateurService.addUtilisateur(utilisateur);
		return new ResponseEntity<>(newUtilisateur, HttpStatus.CREATED);
		
	}

	@PutMapping("/update")
	public ResponseEntity<utilisateur> updateUtilisateur(@RequestBody utilisateur utilisateur){
		utilisateur updateUtilisateur= UtilisateurService.addUtilisateur(utilisateur);
		return new ResponseEntity<>(updateUtilisateur, HttpStatus.OK);
		
	}

	@DeleteMapping("/désactivé/{nom}")
	public ResponseEntity<?> désactivéUtilisateur(@PathVariable ("nom")String nom){
		UtilisateurService.désactivéUtilisateur(nom);
		return new ResponseEntity<>( HttpStatus.OK);	
	}

}
