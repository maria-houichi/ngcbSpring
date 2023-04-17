/**
 * 
 */
package ngcb.app.ngcb.resource;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ngcb.app.ngcb.model.employe;
import ngcb.app.ngcb.service.employeService;

/**
 * @author Sos
 *
 */
@RestController
@RequestMapping("/employe")
public class employeResource {
private final employeService EmployeService;
public employeResource(employeService EmployeService) {
	this.EmployeService = EmployeService;
}
@GetMapping("/all")
public ResponseEntity<List<employe>> getAllEmployes(){
	List<employe> employes =EmployeService.findAllEmployes();
	return new ResponseEntity<>(employes, HttpStatus.OK);
}

@GetMapping("/find/{matricule}")
public ResponseEntity<employe> getEmployeBy(@PathVariable("matricule")String matricule){
	employe employe =EmployeService.findEmployeByMatricule(matricule);
	return new ResponseEntity<>(employe,HttpStatus.OK );
}

@PostMapping("/add")
public ResponseEntity<employe> addEmploye(@RequestBody employe employe){
	employe newEmploye= EmployeService.addEmploye(employe);
	return new ResponseEntity<>(newEmploye, HttpStatus.CREATED);
	
}

@PutMapping("/update")
public ResponseEntity<employe> updateEmploye(@RequestBody employe employe){
	employe updateEmploye= EmployeService.addEmploye(employe);
	return new ResponseEntity<>(updateEmploye, HttpStatus.OK);
	
}

@DeleteMapping("/delete/{matricule}")
public ResponseEntity<?> deleteEmploye(@PathVariable ("matricule")String matricule){
	EmployeService.deleteEmploye(matricule);
	return new ResponseEntity<>( HttpStatus.OK);	
}
}