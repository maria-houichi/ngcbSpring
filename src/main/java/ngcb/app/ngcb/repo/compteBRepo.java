package ngcb.app.ngcb.repo;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import ngcb.app.ngcb.model.comptB;
import ngcb.app.ngcb.model.etat;
import ngcb.app.ngcb.model.nature;
import ngcb.app.ngcb.model.structure;
import ngcb.app.ngcb.model.type;


public interface compteBRepo extends JpaRepository<comptB,Long >{
    Optional<comptB> findComptBById(Long comptB);

    List<comptB> findByStructureCodeStr(int codeStr);
    
  //  List<comptB> findByStructureParentStr(int parentStr);
    
    List<comptB> findByType(type type);
    List<comptB> findByNature(nature nature);
    List<comptB> findByEtat(etat etat );
    Optional<comptB> findByStructure(structure structure);


}

