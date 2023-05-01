package ngcb.app.ngcb.repo;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import ngcb.app.ngcb.model.comptB;


public interface compteBRepo extends JpaRepository<comptB,Long >{
	Optional <comptB> findComptBById(Long comptB);
}
