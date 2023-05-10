package ngcb.app.ngcb.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ngcb.app.ngcb.model.structure;
import ngcb.app.ngcb.service.structureService;
@RestController



@RequestMapping("/structure")
@CrossOrigin(origins = "http://localhost:4200")

public class structureResource {

	@Autowired 
	structureService structureService;
	
	@GetMapping("/all")
	public List<structure> findAllProd() {
//		List<structure> str= structureService.findAllStr();
//		for(structure s :str) {
//			if(s.getParentStr()!=0) {
//			s = getStr(s);
//			}
//		}
//		return str;
		return structureService.findAllStr();
	}

	@GetMapping("/children/{codeD}")
	public List<String> findStrChildren(@PathVariable String codeD) {
		codeD = "%"+codeD+"%";
		return structureService.findStrChildren(codeD);
	}
	
	@GetMapping("/childrenStructures/{codeD}")
	public List<structure> findChildrenStructures(@PathVariable String codeD) {
		codeD = "%"+codeD+"%";
		return structureService.findChildrenStructures(codeD);
	}

	public structure getStr(structure str) {
		if(str.getParentStr()==25) {
			//System.out.println("if "+str.getParentStr());
			return str;			
		}else {
			//System.out.println("else"+str.getParentStr());
			 structure prtStr= structureService.findById(str.getParentStr());
			 str.setParent_STR(getStr(prtStr));
			 return str;
		}
	}
	
	@GetMapping("/{idStr}")
	public structure findById(@PathVariable int idStr) {
		structure str= structureService.findById(idStr);
		str=getStr(str);
		return str;
	}
	
	@GetMapping("/codeStr/{code}")
	public structure findStrByCode(@PathVariable String code) {
		structure str= structureService.findStrByCode(code);
		str=getStr(str);
		return str;
	}
	
	
	@PutMapping("/codesStr")
	public List<structure> findStrByCodes(@RequestBody List<String> codes) {
		return structureService.findStrByCodes(codes);
	}

}


//@RestController
//@RequestMapping("/structure")
//public class structureResource {
//	
//	private final structureService StructureService;
//	
//	public structureResource(structureService StructureService) {
//		this.StructureService = StructureService;
//	}
//	
//	@GetMapping("/all")
//	public ResponseEntity<List<structure>> getAllStructures(){
//		List<structure> structures = StructureService.findAllStructures();
//		return new ResponseEntity<>(structures, HttpStatus.OK);
//	}
//	
//	@GetMapping("/find/{codeStr}")
//	public ResponseEntity<structure> getStructureBy(@PathVariable("codeStr")Long codeStr){
//		structure structure =StructureService.findStructureByCodeStr(codeStr);
//		return new ResponseEntity<>(structure,HttpStatus.OK );
//	}
//
//}
