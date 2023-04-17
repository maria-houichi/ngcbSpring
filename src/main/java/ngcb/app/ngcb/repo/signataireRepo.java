/**
 * 
 */
package ngcb.app.ngcb.repo;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ngcb.app.ngcb.model.signataire;


public interface signataireRepo extends JpaRepository<signataire,Long> {
	void deleteSignataireByMatricule(String matricule);
	signataire findSignataireByMatricule (String matricule);
	List<signataire> findAllByActifTrue();
	

}



