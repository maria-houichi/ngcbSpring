package ngcb.app.ngcb.resource;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ngcb.app.ngcb.model.structure;
import ngcb.app.ngcb.service.structureService;

@RestController
@RequestMapping("/structure")
public class structureResource {
	
	private final structureService StructureService;
	
	public structureResource(structureService StructureService) {
		this.StructureService = StructureService;
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<structure>> getAllStructures(){
		List<structure> structures = StructureService.findAllStructures();
		return new ResponseEntity<>(structures, HttpStatus.OK);
	}

}
