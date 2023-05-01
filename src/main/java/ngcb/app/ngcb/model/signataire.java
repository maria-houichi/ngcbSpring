package ngcb.app.ngcb.model;

import java.io.Serializable;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
@Entity
@Table(name="signataire")



public class signataire  extends employe implements Serializable{


	private static final long serialVersionUID = 1L;
	Boolean actif ;
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

