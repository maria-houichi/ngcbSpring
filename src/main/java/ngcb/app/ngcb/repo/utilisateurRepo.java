package ngcb.app.ngcb.repo;


import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ngcb.app.ngcb.model.utilisateur;

@Repository
public interface utilisateurRepo extends JpaRepository<utilisateur,String> {

//      User findByEmail(String email);
//		void desactiverCompteByNom(String nom);
//		activerCompteByNom(String nom);
		Optional <utilisateur> findUtilisateurByNom(String nom);
		List<utilisateur> findAll();

		   
		

		

		}