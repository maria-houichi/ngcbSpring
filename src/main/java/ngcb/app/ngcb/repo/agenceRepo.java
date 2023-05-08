package ngcb.app.ngcb.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import ngcb.app.ngcb.model.agence;
import ngcb.app.ngcb.model.banque;


public interface agenceRepo extends JpaRepository<agence,Long > {
	Optional <agence> findAgenceByCodeAgence(Long codeAgence);
	//List <agence> findAgenceByBanque(Long codeBanque);
	List<agence> findAgenceByBanque(banque banque);

	
}
