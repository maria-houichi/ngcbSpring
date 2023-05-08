package ngcb.app.ngcb.Auth;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ngcb.app.ngcb.model.genre;
import ngcb.app.ngcb.model.role;

@Data
@Builder 
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {

	  public  String getMatricule()  {
	        return matricule ;
	    }

	    	public  void setMatricule( String matricule) {
	        this.matricule = matricule;
	    }
	    public String getNom()  {
	        return nom ;
	    }

	    	public  void setNom(String nom ) {
	        this.nom = nom;
	    }
	    	 public String getPrenom()   {
	    		    return prenom  ;
	    		}
	    		    public void setPrenom(String prenom  ){
	    		    this.prenom = prenom;
	    		}
	    		    public String getFonction()  {
	    		    return fonction ;
	    		}
	    		    public void setFonction(String fonction ){
	    		    this.fonction = fonction;
	    		}
	    		public genre getGenre()   {
	    		    return genre;
	    		}

	    		public void setGenre(genre genre){
	    		    this.genre = genre;
	    		}

		public String getUserName() {
		return userName;
	}
	public void setuserName(String userName) {
		this.userName = userName;
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

private String matricule;
private String nom;
private String prenom;
private String fonction;
private genre genre;
private String userName;
private String password ;
private role role;
private Boolean actif;

}