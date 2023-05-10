package ngcb.app.ngcb.service;

import java.util.List;

import ngcb.app.ngcb.model.structure;

public interface interfaceStructure {

	public List<structure> findAllStr();

	public List<String> findStrChildren(String codeD);
	
	public List<structure> findChildrenStructures(String codeD);

	public structure findById(int codeStr);
	
	public structure findStrByCode(String code);

	public List<structure> findStrByCodes(List<String> codes);

}
