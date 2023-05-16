package ngcb.app.ngcb.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
@Entity
@Table(name="signataire")



public class signataire  extends employe implements Serializable{


	private static final long serialVersionUID = 1L;
	Boolean actif ;
	@ManyToOne
	@JoinColumn(name="codeStr", nullable=false )
	@JsonIgnoreProperties("signataires")
	private structure structure;
	
public structure getStructure() {
		return structure;
	}
	public void setStructure(structure structure) {
		this.structure = structure;
	}
public signataire() {}
	signataire (String matricule, String nom,String  prenom, String fonction,genre genre, Boolean actif ){
		super(matricule, nom, prenom , fonction , genre);
		 this.actif = actif;
	}
	
	public Boolean getActif() {
	    return this.actif ;
	}

		public void  setActif(Boolean actif){
	    this.actif = actif;
	}
		
		public String toString() {
			super.toString();
			return "signataire{"+ "actif:"+actif +"}";
		}
}

