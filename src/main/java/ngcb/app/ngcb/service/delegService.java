package ngcb.app.ngcb.service;

import java.util.List;

import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;
import ngcb.app.ngcb.model.delegation;
import ngcb.app.ngcb.model.employe;
import ngcb.app.ngcb.repo.delegRepo;

@Service
@Transactional
public class delegService {
	private final delegRepo DelegRepo;
	public delegService(delegRepo DelegRepo) {
		this.DelegRepo=DelegRepo;
	}
	
	public delegation addDeleg (delegation delegation) {
		
		return DelegRepo.save(delegation);} 
	
	public  List<delegation> findAllDelegs(){
		return DelegRepo.findAll();}
}
