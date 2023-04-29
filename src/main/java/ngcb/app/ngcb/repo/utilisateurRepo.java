package ngcb.app.ngcb.repo;
/**
 * 
 */




import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import ngcb.app.ngcb.model.employe;
import ngcb.app.ngcb.model.utilisateur;


public interface utilisateurRepo extends JpaRepository<utilisateur,String> {
	Optional <utilisateur> findUtilisateurByMatricule(String matricule);
}
