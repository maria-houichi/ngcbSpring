package ngcb.app.ngcb.model;
import java.io.Serializable;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="utilisateur")
public class utilisateur extends employe implements Serializable{
	private static final long serialVersionUID = 1L;
	    
	    private String e_mail;
	    private String password;
	    private role role;
	    Boolean actif;
	
	public utilisateur() {}
	utilisateur (String matricule, String nom,String  prenom, String fonction,String e_mail ,String password,role role,genre genre, Boolean actif ){
		super(matricule,nom,prenom,fonction,genre);
		this.role=role;
        this.actif = actif;
        this.e_mail = e_mail;
        this.password=password;
        
	}



		public String getE_mail() {
		return e_mail;
	}
	public void setE_mail(String e_mail) {
		this.e_mail = e_mail;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Boolean getActif() {
		return actif;
	}
	public void setActif(Boolean actif) {
		this.actif = actif;
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


}
