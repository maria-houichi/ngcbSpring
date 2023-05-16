package ngcb.app.ngcb.service;

import java.util.List;
import java.util.Optional;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;
import ngcb.app.ngcb.model.role;
import ngcb.app.ngcb.model.signataire;
import ngcb.app.ngcb.model.utilisateur;
import ngcb.app.ngcb.repo.utilisateurRepo;
@Service
@Transactional

public class utilisateurService  {
	private final utilisateurRepo UtilisateurRepo;

	public utilisateurService(utilisateurRepo UtilisateurRepo) {
		this.UtilisateurRepo=UtilisateurRepo;
	}
	public Optional<utilisateur> getUtilisateurCourant() {
        org.springframework.security.core.Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentUserName = authentication.getName();
        return UtilisateurRepo.findUtilisateurByUserName(currentUserName);
    }
	public  List<utilisateur> findAllUtilisateursT(){
		
		return UtilisateurRepo.findAllByActifTrue();
		}
	public  List<utilisateur> findAllUtilisateursF(){
		
		return UtilisateurRepo.findAllByActifFalse();
		}
	
	 public utilisateur createUser(utilisateur utilisateur) {
		  utilisateur.setActif(true);
	        return UtilisateurRepo.save(utilisateur);
	    }
	 public Optional<role> getRoleUtilisateurCourant() {
	        Optional<utilisateur> utilisateurOptional = getUtilisateurCourant();
	        if (utilisateurOptional.isPresent()) {
	            return Optional.ofNullable(utilisateurOptional.get().getRole());
	        }
	        return Optional.empty();
	    }
	    
//	    public Optional<utilisateur> getUserByEmail(String mail) {
//	        return UtilisateurRepo.findUtilisateurByNom(mail);
//	       
//	    }
	    
//	    public utilisateur findUtilisateurByNom(String nom ) {
//			return UtilisateurRepo.findUtilisateurByNom(nom)
//					.orElseThrow(()-> new utilisateurNotFoundException("utilisateur by nom "+nom+"was not found "));
//		}
	    
	    public utilisateur updateUser(utilisateur utilisateur) {
	    
	        return UtilisateurRepo.save(utilisateur);
	    }
	   public utilisateur activéUser(utilisateur utilisateur) {
	    	utilisateur.setActif(true);
	    	
	    	return UtilisateurRepo.save(utilisateur);
	    }
	    
	    public utilisateur désactivéUser(utilisateur utilisateur) {
	    	utilisateur.setActif(false);
	    	
	    	return UtilisateurRepo.save(utilisateur);
	    }
		public  List<utilisateur> getUtilsateurByRole(role role) {
			return  UtilisateurRepo.findByRole(role);
		}
		public List<utilisateur> getUtilisateurByFonction(String fonction) {
			return UtilisateurRepo.findByFonction(fonction);
		}
		public List<String> getFonctions() {
			 return UtilisateurRepo.getFonctions();
		}	 
		


	}


	
	

	 

