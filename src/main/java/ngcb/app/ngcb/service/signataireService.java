/**
 * 
 */
package ngcb.app.ngcb.service;

import java.util.List;

import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import ngcb.app.ngcb.model.signataire;
import ngcb.app.ngcb.model.utilisateur;
import ngcb.app.ngcb.repo.signataireRepo;
@Service
@Transactional

public class signataireService {
	
	private signataireRepo SignataireRepo ;
	
	public signataireService(signataireRepo SignataireRepo) 
		{
			this.SignataireRepo=SignataireRepo;
		}
	
	public signataire addSignataire (signataire signataire ) {
		signataire.setActif(true);
		
		return SignataireRepo.save(signataire );} 

	public  List<signataire> findAllSignataires(){
		
		return SignataireRepo.findAllByActifTrue();
		 }


	public signataire  updateSignataire(signataire signataire) {
		return SignataireRepo.save(signataire );
}
	public signataire  deleteSignataire(signataire signataire) {
		signataire.setActif(false);
		return SignataireRepo.save(signataire );
}
public  List<signataire> findAllsignatairesdeleted(){
		
	return SignataireRepo.findAllByActifFalse();
}
	 public List<String> getFonctions() {
	        return SignataireRepo.getFonctions();
	    }


}
