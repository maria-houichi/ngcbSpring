package ngcb.app.ngcb.repo;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import ngcb.app.ngcb.model.comptB;
import ngcb.app.ngcb.model.structure;


public interface compteBRepo extends JpaRepository<comptB,Long >{
    Optional<comptB> findComptBById(Long comptB);

    List<comptB> findByStructureCodeStr(int codeStr);

    
    Optional<comptB> findByStructure(structure structure);
}

