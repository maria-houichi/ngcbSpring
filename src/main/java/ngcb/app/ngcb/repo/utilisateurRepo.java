package ngcb.app.ngcb.repo;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ngcb.app.ngcb.model.role;
import ngcb.app.ngcb.model.utilisateur;

public interface utilisateurRepo extends JpaRepository<utilisateur,String> {
//      User findByEmail(String email);
//		void desactiverCompteByNom(String nom);
//		activerCompteByNom(String nom);
		//Optional <utilisateur> findUtilisateurByNom(String nom);
		List<utilisateur> findAll();
	 	List<utilisateur> findAllByActifTrue();
	 	List<utilisateur> findAllByActifFalse();
	 	Optional <utilisateur> findUtilisateurByUserName(String userName);
		List<utilisateur> findByRole(role role);
		List<utilisateur> findByFonction(String fonction);
		@Query("SELECT DISTINCT u.fonction FROM utilisateur u")
		List<String> getFonctions();
		
	 	

		}

