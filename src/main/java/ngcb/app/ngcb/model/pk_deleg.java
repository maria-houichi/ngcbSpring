package ngcb.app.ngcb.model;

import java.io.Serializable;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class pk_deleg implements Serializable {
	private static final long serialVersionUID = 1L;
	@Basic(optional = false)
    @Column(name = "matricule")
    private String matricule;
    @Basic(optional = false)
    @Column(name = "id_CompteB")
    private Long id;
    
    public pk_deleg() {
    }
    
    public pk_deleg(String matricule, Long id) {
    	
		this.matricule = matricule;
		this.id = id;
	}
    
    
    
    
	@Override
	public String toString() {
		return "pk_deleg [matricule=" + matricule + ", id=" + id + "]";
	}

	public String getMatricule() {
		return matricule;
	}
	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
    
    
    
    
    
    
}
