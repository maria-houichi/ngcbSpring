package ngcb.app.ngcb.service;

import java.util.List;

import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import ngcb.app.ngcb.employeNotFoundException;
import ngcb.app.ngcb.utilisateurNotFoundException;
import ngcb.app.ngcb.model.utilisateur;
import ngcb.app.ngcb.repo.utilisateurRepo;
@Service
@Transactional

public class utilisateurService  {
	private final utilisateurRepo UtilisateurRepo;

	public utilisateurService(utilisateurRepo UtilisateurRepo) {
		this.UtilisateurRepo=UtilisateurRepo;
	}
	public utilisateur addUtilisateur (utilisateur utilisateur) {
		
			return UtilisateurRepo.save(utilisateur);} 

	public  List<utilisateur> findAllUtilisateurs(){
		return UtilisateurRepo.findAll();}

	public utilisateur updateUtilisateur(utilisateur utilisateur) {
		return UtilisateurRepo.save(utilisateur);
	}

	public utilisateur findUtilisateurByNom(String nom ) {
		return UtilisateurRepo.findUtilisateurByNom(nom)
				.orElseThrow(()-> new utilisateurNotFoundException("utilisateur by nom "+nom+"was not found "));
	}

	public void désactivéUtilisateur (String nom) {
		UtilisateurRepo.désactivéUtilisateurByNom(nom);
	}
	

	 

}
