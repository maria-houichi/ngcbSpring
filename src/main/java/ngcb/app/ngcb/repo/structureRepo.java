package ngcb.app.ngcb.repo;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import ngcb.app.ngcb.model.structure;

public interface structureRepo extends JpaRepository<structure,Long >  {
	Optional <structure> findStructureByCodeStr(Long codeStr);
}
