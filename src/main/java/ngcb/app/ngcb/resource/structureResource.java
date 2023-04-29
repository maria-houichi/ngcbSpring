package ngcb.app.ngcb.resource;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ngcb.app.ngcb.model.agence;
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
	
	@GetMapping("/find/{codeStr}")
	public ResponseEntity<structure> getStructureBy(@PathVariable("codeStr")Long codeStr){
		structure structure =StructureService.findStructureByCodeStr(codeStr);
		return new ResponseEntity<>(structure,HttpStatus.OK );
	}

}
