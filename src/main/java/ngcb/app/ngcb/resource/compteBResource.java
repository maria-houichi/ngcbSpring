package ngcb.app.ngcb.resource;

import java.util.List;
import java.util.Optional;

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
import ngcb.app.ngcb.model.structure;
import ngcb.app.ngcb.model.utilisateur;
import ngcb.app.ngcb.service.compteBService;


@RestController
@RequestMapping("/compteB")
@CrossOrigin(origins = "http://localhost:4200")

public class compteBResource {
	
	private final compteBService CompteBService;
	
	public compteBResource(compteBService CompteBService) {
		this.CompteBService = CompteBService;
	}
	
	@PreAuthorize("isAuthenticated()")  
	@GetMapping("/all")
	public ResponseEntity<List<comptB>> getAllEmployes(){
		List<comptB> comptBs =CompteBService.findAllCompteBs();
		return new ResponseEntity<>(comptBs, HttpStatus.OK);
	}
	@PreAuthorize("isAuthenticated()")  
	@PostMapping("/add")
	public ResponseEntity<comptB> addCompteB(@RequestBody comptB comptB){
		comptB newComptB= CompteBService.addCompteB(comptB);
		return new ResponseEntity<>(newComptB, HttpStatus.CREATED);
		
	}
	@PreAuthorize("isAuthenticated()")  
	@PutMapping("/update")
	public ResponseEntity<comptB> updateUtilisateur(@RequestBody comptB comptB){
		comptB updateComptB= CompteBService.updateCompteB(comptB);
		return new ResponseEntity<>(updateComptB, HttpStatus.OK);
		
	}
	@PreAuthorize("isAuthenticated()")  
	@GetMapping("/compteby/{codeStr}")
	public ResponseEntity<List<comptB>> getCmptbyStr(@PathVariable("codeStr") int codeStr) {
	    List<comptB> comptes = CompteBService.findeCompteBByStr(codeStr);
	    return new ResponseEntity<>(comptes, HttpStatus.OK);
	}


	@PreAuthorize("isAuthenticated()")  
	@GetMapping("/get/{id}")
	public ResponseEntity<comptB> getCmpt(@PathVariable ("id")Long id){
		comptB ComptB=CompteBService.findeCompteBById(id);
		return new ResponseEntity<>(ComptB, HttpStatus.OK);	
	}
	@PreAuthorize("isAuthenticated()")  
	@PostMapping("/getId")
	public ResponseEntity<Long> getCmptId(@RequestBody comptB comptB){
		Long Id=CompteBService.getIdCompte(comptB);
		return new ResponseEntity<>(Id, HttpStatus.OK);
	}
	

	
		
	}



