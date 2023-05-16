
package ngcb.app.ngcb.model;

import java.io.Serializable;
import java.util.Set;

import jakarta.persistence.NamedQueries;
import org.hibernate.annotations.Proxy;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Transient;
import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
@Entity
@Table(name = "STRUCTURE")

@NamedQueries({
    @NamedQuery(name = "structure.findAllStr", query = "SELECT s FROM structure s WHERE s.actif = true"),
    @NamedQuery(name = "structure.findStrChildren", query = "SELECT s.code FROM structure s WHERE s.compoCode like :codeD and s.actif = true "),
    @NamedQuery(name = "structure.findChildrenStructures", query = "SELECT s FROM structure s WHERE s.compoCode like :codeD and s.actif = true"),
    @NamedQuery(name = "structure.findStrByCode", query = "SELECT s FROM structure s WHERE s.code = :code and s.actif = true"),
    @NamedQuery(name = "structure.findStrByCodes", query = "SELECT s FROM structure s WHERE s.code IN :codes and s.actif = true")
})
@Proxy(lazy = false)

public class structure implements Serializable {
	

    private static final long serialVersionUID = 1L;
    @OneToMany(mappedBy="structure")
    @JsonIgnoreProperties("structure")
    private Set<comptB> comptesB;
    @OneToMany(mappedBy="structure")
    @JsonIgnoreProperties("structure")
    private Set<signataire> signataires;
    @Id
    
    @Basic(optional = false)
    @Column(name = "CODESTR")
	private int codeStr;
    @Column(name = "CDG")
	private String cdg;
    @Column (name = "CLEPARENT")
 	private int parentStr;   
    @Column(name = "LIBELLE")
   	private String libStr;
    @Column(name = "TYPE")
   	private String type;
    @Column(name = "CODE")
 	private String code;
    @Column(name= "COMPOSITECODE")
    private String compoCode;
    @Column(name= "ACTIF")
    private Boolean actif;
    @Transient
    structure parent_STR;
   
	public structure() {
	}

	public structure(int codeStr) {
	super();
	this.codeStr = codeStr;
    }

	public int getCodeStr() {
		return codeStr;
	}

	public void setCodeStr(int codeStr) {
		this.codeStr = codeStr;
	}

	public void setParent_STR(structure parent_STR) {
		this.parent_STR = parent_STR;
	}



	public String getCdg() {
		return cdg;
	}

	public void setCdg(String cdg) {
		this.cdg = cdg;
	}

	public int getParentStr() {
		return parentStr;
	}

	public void setParentStr(int parentStr) {
		this.parentStr = parentStr;
	}

	public String getLibStr() {
		return libStr;
	}

	public void setLibStr(String libStr) {
		this.libStr = libStr;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	

	public String getCompoCode() {
		return compoCode;
	}

	public void setCompoCode(String compoCode) {
		this.compoCode = compoCode;
	}

	public Boolean isActif() {
		return actif;
	}

	public void setActif(Boolean actif) {
		this.actif = actif;
	}

	public structure getParent_STR() {
		return parent_STR;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = (int) 1;
		result = prime * result + codeStr;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		structure other = (structure) obj;
		if (codeStr != other.codeStr)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Structure [idStr=" + codeStr + ", cdg=" + cdg + ", parentStr=" + parentStr + ", libStr=" + libStr
				+ ", type=" + type + "]";
	}


	 
}
