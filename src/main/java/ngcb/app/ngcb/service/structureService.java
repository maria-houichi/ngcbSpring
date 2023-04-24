package ngcb.app.ngcb.service;


import java.util.List;

import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
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
}
