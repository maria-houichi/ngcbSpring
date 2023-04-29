package ngcb.app.ngcb.repo;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import ngcb.app.ngcb.model.banque;



public interface banqueRepo extends JpaRepository<banque, Long> {
	
	Optional <banque> findBanqueByCodeBanque(Long codeBanque);
}
