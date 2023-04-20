package ngcb.app.ngcb.repo;


import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import ngcb.app.ngcb.model.utilisateur;


public interface utilisateurRepo extends JpaRepository<utilisateur,String> {


		void désactivéUtilisateurByNom(String nom);
		void activéUtilisateurByNom(String nom);
		Optional <utilisateur> findUtilisateurByNom(String nom);
		List<utilisateur> findAll();

		}