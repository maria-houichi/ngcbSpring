package ngcb.app.ngcb.service;

import java.util.List;

import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import ngcb.app.ngcb.model.comptB;
import ngcb.app.ngcb.model.signataire;
import ngcb.app.ngcb.repo.compteBRepo;

@Service
@Transactional
public class compteBService {
private final compteBRepo CompteBRepo;
	
	public compteBService(compteBRepo CompteBRepo) {
		this.CompteBRepo=CompteBRepo;
	}
	
	public  List<comptB> findAllCompteBs(){
		return CompteBRepo.findAll();}
	
	public comptB addCompteB (comptB comptB) {
		return CompteBRepo.save(comptB);} 
	
	  public void ajouterSignataire(comptB comptB) {

//		  comptB.getSignataires().add(signataire);
	       CompteBRepo.save(comptB);
	   }

	


}
