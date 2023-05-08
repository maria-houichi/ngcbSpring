package ngcb.app.ngcb.service;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;
import ngcb.app.ngcb.model.structure;
import ngcb.app.ngcb.model.utilisateur;
import ngcb.app.ngcb.repo.structureRepo;

@Service
//@Transactional
public class structureService implements interfaceStructure{

	@Autowired(required=true) 
	structureRepo structureRepository;

	@Override
	public List<structure> findAllStr(){

		return structureRepository.findAllStr();
	}
	
	@Override
	public List<String> findStrChildren(String codeD){
		return structureRepository.findStrChildren(codeD);
	}

	@Override
	public List<structure> findChildrenStructures(String codeD){
		return structureRepository.findChildrenStructures(codeD);
	}
	
//	@Override
//	public structure findById(int idStr) {
//		return structureRepository.findById(idStr);
//	}
	
	@Override
	public structure findStrByCode(String code){
		return structureRepository.findStrByCode(code);
	}
	
	@Override
	public List<structure> findStrByCodes(List<String> codes){
		return structureRepository.findStrByCodes(codes);
	}

	@Override
	public structure findById(int idStr) {
		// TODO Auto-generated method stub
		return null;
	}
	 public structure Add(structure structure) {
		 structure.setActif(true);
	        return structureRepository.save(structure);
	    }


}
