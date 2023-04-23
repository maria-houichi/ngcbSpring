package ngcb.app.ngcb.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
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
	 public utilisateur createUser(utilisateur utilisateur) {
	        return UtilisateurRepo.save(utilisateur);
	    }
	    
	    public Optional<utilisateur> getUserByEmail(String mail) {
	        return UtilisateurRepo.findUtilisateurByNom(mail);
	       
	    }
	    
	    public utilisateur findUtilisateurByNom(String nom ) {
			return UtilisateurRepo.findUtilisateurByNom(nom)
					.orElseThrow(()-> new utilisateurNotFoundException("utilisateur by nom "+nom+"was not found "));
		}
	    
	    public utilisateur updateUser(utilisateur utilisateur) {
	        return UtilisateurRepo.save(utilisateur);
	    }
	    
	    public void disableUser(utilisateur utilisateur) {
	    	utilisateur.setEnabled(false);
	    	UtilisateurRepo.save(utilisateur);
	    }
	    
	    public void enableUser(utilisateur utilisateur) {
	    	utilisateur.setEnabled(true);
	    	UtilisateurRepo.save(utilisateur);
	    }
		public  List<utilisateur> findAllUtilisateurs(){
		return UtilisateurRepo.findAll();
		}
		public void desactiverCompte(utilisateur utilisateur) {
			utilisateur.setEnabled(false);
	    	UtilisateurRepo.save(utilisateur);
			
		}
	}


	
	

	 

