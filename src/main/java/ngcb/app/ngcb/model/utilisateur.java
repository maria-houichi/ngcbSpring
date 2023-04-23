package ngcb.app.ngcb.model;


import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table(name="utilisateur")
public class utilisateur extends employe implements Serializable{
	private static final long serialVersionUID = 1L;
	

	
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private String matricule;
	    private String nom;
	    private String prenom;
	    private String fonction;
	    private String e_mail;
	    private String password;
	  //  @Enumerated(EnumType.STRING)
	    private role role;
	    private etatUser etat;
	    
	    //constructeurs, getters, setters, etc.
	
//	Boolean actif;
	
	public utilisateur() {}
	utilisateur (String matricule, String nom,String  prenom, String fonction,String e_mail ,String password,role role,etatUser etat ){
		super();
		this.matricule=matricule;
		this.nom=nom;
		this.prenom=prenom;
		this.fonction=fonction;
		this.password=password;
		this.e_mail = e_mail;
        this.role = role;
        this.etat=etat;
//        this.actif = actif;
	}


	  

		public String getMatricule() {
		return matricule;
	}
	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getFonction() {
		return fonction;
	}
	public void setFonction(String fonction) {
		this.fonction = fonction;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
		public String getE_mail() {
	    return this.e_mail ;
	}

		public void  setE_mail(String e_mail){
	    this.e_mail = e_mail;
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
			return "utilisateur{"+ "e_mail:"+e_mail+"mot de passe :"+password+"role:"+role+"}";
		}
		public void setEnabled(boolean b) {
			// TODO Auto-generated method stub
			
		}
		public etatUser getEtat() {
			return etat;
		}
		public void setEtat(etatUser etat) {
			this.etat = etat;
		}

}
