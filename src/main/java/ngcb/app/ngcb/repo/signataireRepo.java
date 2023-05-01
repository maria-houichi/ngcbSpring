/**
 * 
 */
package ngcb.app.ngcb.repo;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ngcb.app.ngcb.model.signataire;


public interface signataireRepo extends JpaRepository<signataire,Long> {
	void deleteSignataireByMatricule(String matricule);
	signataire findSignataireByMatricule (String matricule);
	List<signataire> findAllByActifTrue();
	List<signataire> findAllByActifFalse();
	
	@Query("SELECT DISTINCT s.fonction FROM signataire s")
	 List<String> getFonctions();




}



