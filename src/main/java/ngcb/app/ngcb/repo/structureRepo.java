package ngcb.app.ngcb.repo;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import ngcb.app.ngcb.model.structure;

public interface structureRepo extends JpaRepository<structure,Integer >  {

public structure findStrByCodeStr(int codeStr);
public List<structure> findAllStr();

	public List<String> findStrChildren(String codeD);
	
	public List<structure> findChildrenStructures(String codeD);

	public structure findStrByCode(String code);

	public List<structure> findStrByCodes(List<String> codes);

	public structure findById(int codeStr);

	}
