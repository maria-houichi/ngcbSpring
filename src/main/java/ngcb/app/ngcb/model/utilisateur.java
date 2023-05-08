package ngcb.app.ngcb.model;
//import java.io.Serializable;
import java.util.Collection;

import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Data;
@Data
@Entity
@Builder
@Table(name="utilisateur")
public class utilisateur  implements UserDetails{
	private static final long serialVersionUID = 1L;
	@Id
	private String matricule;
    private String nom;
    private String prenom;
    private String fonction;
    public genre genre;
	    private String userName;
	    private String password;
	    private role role;
	    Boolean actif;
	    
	    
	    public utilisateur () {}
	    public utilisateur ( String matricule  ,String  nom , String  prenom, String fonction  ,genre genre,String userName,String password, role role, Boolean actif )
	    {
	        this.matricule = matricule;
	        this.nom=nom;
	        this.prenom=prenom;
	        this.fonction=fonction;
	        this.genre = genre;
	        this.userName=userName;
	        this.password=password;
	        this.role = role;
	        this.actif = actif;
	    }
	    

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

		public String getuserName() {
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

	
		@Override
		public Collection<? extends GrantedAuthority> getAuthorities() {
			// TODO Auto-generated method stub
			return List.of(new SimpleGrantedAuthority(role.name()));
		}
		@Override
		public String getUsername() {
			// TODO Auto-generated method stub
			return userName;
		}
		@Override
		public boolean isAccountNonExpired() {
			// TODO Auto-generated method stub
			return true;
		}
		@Override
		public boolean isAccountNonLocked() {
			// TODO Auto-generated method stub
			return true;
		}
		@Override
		public boolean isCredentialsNonExpired() {
			// TODO Auto-gene rated method stub
			return true;
		}
		@Override
		public boolean isEnabled() {
			// TODO Auto-generated method stub
			return true;
		}


}
