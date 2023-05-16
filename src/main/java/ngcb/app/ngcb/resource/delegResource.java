package ngcb.app.ngcb.resource;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ngcb.app.ngcb.model.delegation;
import ngcb.app.ngcb.model.employe;
import ngcb.app.ngcb.service.delegService;
import ngcb.app.ngcb.service.employeService;

@RestController
@RequestMapping("/deleg")
@CrossOrigin(origins = "http://localhost:4200")
public class delegResource {
	
	private final delegService DelegService;
	
	public delegResource(delegService DelegService) {
		this.DelegService = DelegService;
	}
	@PreAuthorize("isAuthenticated()")
	@GetMapping("/all")
	public ResponseEntity<List<delegation>> getAllDelegs(){
		List<delegation> delegs =DelegService.findAllDelegs();
		return new ResponseEntity<>(delegs, HttpStatus.OK);
	}
	@PreAuthorize("isAuthenticated()")
	@PostMapping("/add")
	public ResponseEntity<delegation> addDeleg(@RequestBody   delegation delegation){
		delegation newDeleg= DelegService.addDeleg(delegation);
		return new ResponseEntity<>(newDeleg, HttpStatus.CREATED);
		
	}

}
