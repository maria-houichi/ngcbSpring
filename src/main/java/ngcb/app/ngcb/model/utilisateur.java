package ngcb.app.ngcb.model;


import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table(name="utilisateur")
public class utilisateur extends employe implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	String matricule;
	String nom;
	String  prenom; String fonction;
	String e_mail;
	String password;
	private String mdp;
	private role role;
	Boolean actif;
	
	public utilisateur() {}
	utilisateur (String matricule, String nom,String  prenom, String fonction,String e_mail ,String password,role role, String mdp,boolean actif ){
		super();
		this.e_mail = e_mail;
        this.mdp = mdp;
        this.role = role;
        this.actif = actif;
	}


	  

		public String getE_mail() {
	    return this.e_mail ;
	}

		public void  setE_mail(String e_mail){
	    this.e_mail = e_mail;
	}

		public String getMdp()  {
	    return mdp;
	}

		public void setMdp(String mdp) {
	    this.mdp= mdp;
	}

		public role getRole(){
	    return role;
	}

		public void setRole(role role) {
	    this.role = role;
	}
		@Override

		public String toString() {
			super.toString();
			return "utilisateur{"+ "e_mail:"+e_mail+"mot de passe :"+mdp+"role:"+role+"}";
		}

}
