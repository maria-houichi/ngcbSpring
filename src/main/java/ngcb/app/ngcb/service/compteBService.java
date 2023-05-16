package ngcb.app.ngcb.service;

import java.util.List;

import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import ngcb.app.ngcb.employeNotFoundException;
import ngcb.app.ngcb.model.comptB;
import ngcb.app.ngcb.model.employe;
import ngcb.app.ngcb.model.etat;
import ngcb.app.ngcb.model.nature;
import ngcb.app.ngcb.model.signataire;
import ngcb.app.ngcb.model.structure;
import ngcb.app.ngcb.model.type;
import ngcb.app.ngcb.model.utilisateur;
import ngcb.app.ngcb.repo.compteBRepo;
import ngcb.app.ngcb.repo.structureRepo;

@Service
@Transactional
public class compteBService {
private final compteBRepo CompteBRepo;

	
	public compteBService(compteBRepo CompteBRepo) {
		this.CompteBRepo=CompteBRepo;
	}
	
	public  List<comptB> findAllCompteBs(){
		return CompteBRepo.findAll();}
	
	
	
	/*public  List<comptB> findByParentStr(int ParentStr){
		return CompteBRepo.findByParentStr(ParentStr);}*/
	
	public comptB addCompteB (comptB comptB) {
		return CompteBRepo.save(comptB);} 
	

	  public comptB findeCompteBById(Long id ) {
			return  CompteBRepo.findComptBById(id)
					.orElseThrow(()-> new employeNotFoundException("compte by id "+id+"was not found "));
		} 
	  
	  public comptB updateCompteB (comptB comptB) {
			return CompteBRepo.save(comptB);}

	  public List<comptB> findeCompteBByStr(int codeStr) {
		    return CompteBRepo.findByStructureCodeStr(codeStr);
		}

	public List<comptB> getComptesByType(type type) {
	
		return CompteBRepo.findByType(type);
	}
	public List<comptB> getComptesByEtat(etat etat) {
		
		return CompteBRepo.findByEtat(etat);
	}
	public List<comptB> getComptesByNature(nature nature) {
		
		return CompteBRepo.findByNature(nature);
	}





		
		
		

	


}
