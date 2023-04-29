package ngcb.app.ngcb.resource;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ngcb.app.ngcb.model.banque;
import ngcb.app.ngcb.model.employe;
import ngcb.app.ngcb.model.structure;
import ngcb.app.ngcb.service.banqueService;



@RestController
@RequestMapping("/banque")
public class baqueResource {
	private final banqueService BanqueService;
	
	public baqueResource(banqueService BanqueService) {
		this.BanqueService = BanqueService;
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<banque>> getAllBanques(){
		List<banque> banques =BanqueService.findAllBanques();
		return new ResponseEntity<>(banques, HttpStatus.OK);
	}
	
	@PostMapping("/add")
	public ResponseEntity<banque> addBanque(@RequestBody banque banque){
		banque newBanque= BanqueService.addBanque(banque);
		return new ResponseEntity<>(newBanque, HttpStatus.CREATED);
		
	}
	
	@GetMapping("/find/{codeBanque}")
	public ResponseEntity<banque> getBanqueBy(@PathVariable("codeBanque")Long codeBanque){
		banque banque =BanqueService.findBanqueByCodeBanque(codeBanque);
		return new ResponseEntity<>(banque,HttpStatus.OK );
	}
}
