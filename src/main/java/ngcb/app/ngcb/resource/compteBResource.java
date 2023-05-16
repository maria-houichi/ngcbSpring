package ngcb.app.ngcb.resource;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
import ngcb.app.ngcb.model.nature;
import ngcb.app.ngcb.model.structure;
import ngcb.app.ngcb.model.type;
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
	
	@GetMapping("/all")
	public ResponseEntity<List<comptB>> getAllEmployes(){
		List<comptB> comptBs =CompteBService.findAllCompteBs();
		return new ResponseEntity<>(comptBs, HttpStatus.OK);
	}
	
	@PostMapping("/add")
	public ResponseEntity<comptB> addCompteB(@RequestBody comptB comptB){
		comptB newComptB= CompteBService.addCompteB(comptB);
		return new ResponseEntity<>(newComptB, HttpStatus.CREATED);
		
	}
	@PutMapping("/update")
	public ResponseEntity<comptB> updateUtilisateur(@RequestBody comptB comptB){
		comptB updateComptB= CompteBService.updateCompteB(comptB);
		return new ResponseEntity<>(updateComptB, HttpStatus.OK);
		
	}
	@GetMapping("/compteby/{codeStr}")
	public ResponseEntity<List<comptB>> getCmptbyStr(@PathVariable("codeStr") int codeStr) {
	    List<comptB> comptes = CompteBService.findeCompteBByStr(codeStr);
	    return new ResponseEntity<>(comptes, HttpStatus.OK);
	} 
	@GetMapping("/type/{type}")
    public ResponseEntity<List<comptB>> getComptesByType(@PathVariable("type") type type) {
        List<comptB> comptes = CompteBService.getComptesByType(type);
        if (comptes.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(comptes);
        }
    }
	@GetMapping("/etat/{etat}")
    public ResponseEntity<List<comptB>> getComptesByEtat(@PathVariable("etat") etat etat) {
        List<comptB> comptes = CompteBService.getComptesByEtat(etat);
        if (comptes.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(comptes);
        }
    }
	@GetMapping("/nature/{nature}")
    public ResponseEntity<List<comptB>> getComptesByNature(@PathVariable("nature") nature nature) {
        List<comptB> comptes = CompteBService.getComptesByNature(nature);
        if (comptes.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(comptes);
        }
    }

	/*@GetMapping("/comptebyParent/{ParentStr}")
	public ResponseEntity<List<comptB>> getCmptbyParent(@PathVariable("ParentStr") int ParentStr) {
	    List<comptB> comptes = CompteBService.findByParentStr(ParentStr);
	    return new ResponseEntity<>(comptes, HttpStatus.OK);
	}
	*/
	@GetMapping("/get/{id}")
	public ResponseEntity<comptB> getCmpt(@PathVariable ("id")Long id){
		comptB ComptB=CompteBService.findeCompteBById(id);
		return new ResponseEntity<>(ComptB, HttpStatus.OK);	
	}
	
		
	}



