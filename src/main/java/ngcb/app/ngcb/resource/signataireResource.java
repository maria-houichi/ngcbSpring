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


import ngcb.app.ngcb.model.signataire;
import ngcb.app.ngcb.model.utilisateur;
import ngcb.app.ngcb.repo.signataireRepo;
import ngcb.app.ngcb.service.signataireService;

	@RestController
	@RequestMapping("/signataire")
	
public class signataireResource {

		private final signataireService SignataireService;
		
	public signataireResource(signataireService SignataireService) {
		this.SignataireService = SignataireService;
	
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<signataire>> getAllSignataires(){
		List<signataire> signataires =SignataireService.findAllSignataires();
		return new ResponseEntity<>(signataires, HttpStatus.OK);
	}

	@PostMapping("/add")
	public ResponseEntity<signataire> addSignataire(@RequestBody signataire signataire){
		signataire newSignataire= SignataireService.addSignataire(signataire);
		return new ResponseEntity<>(newSignataire, HttpStatus.CREATED);
		
	} 
	@GetMapping("/fonction")
	public ResponseEntity<List<String>> getFonctions() {
        List<String> fonctions = SignataireService.getFonctions();
        return new ResponseEntity<>(fonctions, HttpStatus.OK);
    }

	@PutMapping("/update")
	public ResponseEntity<signataire>  updateSignataire( @RequestBody signataire signataire ){
		signataire updateSignataire= SignataireService.updateSignataire( signataire );
		return new ResponseEntity<>(updateSignataire, HttpStatus.OK);
		
	}


	@PutMapping("/delete")
	public ResponseEntity<signataire>  deleteSignataire( @RequestBody signataire signataire ){
		signataire updateSignataire= SignataireService.deleteSignataire( signataire );
		return new ResponseEntity<>(updateSignataire, HttpStatus.OK);
		
	}
	@GetMapping("/all/deleted")
	public ResponseEntity<List<signataire>> getAllSignatairesDeleted(){
		List<signataire> signataires =SignataireService.findAllsignatairesdeleted();
		return new ResponseEntity<>(signataires, HttpStatus.OK);
	}




}
