package ngcb.app.ngcb.resource;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ngcb.app.ngcb.model.comptB;
import ngcb.app.ngcb.model.etat;
import ngcb.app.ngcb.model.signataire;
import ngcb.app.ngcb.model.utilisateur;
import ngcb.app.ngcb.repo.signataireRepo;
import ngcb.app.ngcb.service.signataireService;

	@RestController
	@RequestMapping("signataire")
	@CrossOrigin(origins = "http://localhost:4200")
	
public class signataireResource {

		private final signataireService SignataireService;
		
	public signataireResource(signataireService SignataireService) {
		this.SignataireService = SignataireService;
	
	}
	@PreAuthorize("isAuthenticated()")
	@GetMapping("/all")
	public ResponseEntity<List<signataire>> getAllSignataires(){
		List<signataire> signataires =SignataireService.findAllSignataires();
		return new ResponseEntity<>(signataires, HttpStatus.OK);
	}
	@PreAuthorize("isAuthenticated()")
	@PostMapping("/add")
	public ResponseEntity<signataire> addSignataire(@RequestBody signataire signataire){
		signataire newSignataire= SignataireService.addSignataire(signataire);
		return new ResponseEntity<>(newSignataire, HttpStatus.CREATED);
		
	} 
	@PreAuthorize("isAuthenticated()")
	@GetMapping("/fonction")
	public ResponseEntity<List<String>> getFonctions() {
        List<String> fonctions = SignataireService.getFonctions();
        return new ResponseEntity<>(fonctions, HttpStatus.OK);
    }
	@PreAuthorize("isAuthenticated()")
	@PutMapping("/update")
	public ResponseEntity<signataire>  updateSignataire( @RequestBody signataire signataire ){
		signataire updateSignataire= SignataireService.updateSignataire( signataire );
		return new ResponseEntity<>(updateSignataire, HttpStatus.OK);
		
	}


	@PreAuthorize("isAuthenticated()")
	@GetMapping("/fonction/{fonction}")
    public ResponseEntity<List<signataire>> getSignataireByFonction(@PathVariable("fonction") String fonction) {
        List<signataire> signataire = SignataireService.getSignataireByFonction(fonction);
        if (signataire.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(signataire);
        }
    }

	@PreAuthorize("isAuthenticated()")
	@PutMapping("/delete")
	public ResponseEntity<signataire>  deleteSignataire( @RequestBody signataire signataire ){
		signataire updateSignataire= SignataireService.deleteSignataire( signataire );
		return new ResponseEntity<>(updateSignataire, HttpStatus.OK);
		
	}
	@PreAuthorize("isAuthenticated()")
	@GetMapping("/all/deleted")
	public ResponseEntity<List<signataire>> getAllSignatairesDeleted(){
		List<signataire> signataires =SignataireService.findAllsignatairesdeleted();
		return new ResponseEntity<>(signataires, HttpStatus.OK);
	}




}
