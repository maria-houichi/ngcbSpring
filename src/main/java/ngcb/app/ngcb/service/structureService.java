package ngcb.app.ngcb.service;


import java.util.List;

import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import ngcb.app.ngcb.employeNotFoundException;
import ngcb.app.ngcb.model.agence;
import ngcb.app.ngcb.model.structure;
import ngcb.app.ngcb.repo.structureRepo;

@Service
@Transactional
public class structureService {
	
private final structureRepo StructureRepo;
	
	public structureService(structureRepo StructureRepo) {
		this.StructureRepo=StructureRepo;
	}

	
	public  List<structure> findAllStructures(){
		return StructureRepo.findAll();}
	
	public structure findStructureByCodeStr(Long codeStr ) {
		return StructureRepo.findStructureByCodeStr(codeStr)
				.orElseThrow(()-> new employeNotFoundException("structure by id "+codeStr+"was not found "));
	}
	
}
