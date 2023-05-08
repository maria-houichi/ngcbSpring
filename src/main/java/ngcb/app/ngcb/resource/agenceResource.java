package ngcb.app.ngcb.resource;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ngcb.app.ngcb.model.agence;
import ngcb.app.ngcb.model.employe;
import ngcb.app.ngcb.service.agenceService;


@RestController
@RequestMapping("/agence")
@CrossOrigin(origins = "http://localhost:4200")

public class agenceResource {
	private final agenceService AgenceService;
	
	public agenceResource(agenceService AgenceService) {
		this.AgenceService = AgenceService;
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<agence>> getAllAgences(){
		List<agence> agences = AgenceService.findAllAgences();
		return new ResponseEntity<>(agences, HttpStatus.OK);
	}
	
	@PostMapping("/add")
	public ResponseEntity<agence> addAgence(@RequestBody agence agence){
		agence newAgence= AgenceService.addAgence(agence);
		return new ResponseEntity<>(newAgence, HttpStatus.CREATED);
		
	}
	
	@GetMapping("/find/{codeAgence}")
	public ResponseEntity<agence> getAgenceBy(@PathVariable("codeAgence")Long codeAgence){
		agence agence =AgenceService.findAgenceByCodeAgence(codeAgence);
		return new ResponseEntity<>(agence,HttpStatus.OK );
	}

}
