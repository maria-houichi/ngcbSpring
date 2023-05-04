package ngcb.app.ngcb.model;
//import java.io.Serializable;
import java.util.Collection;

import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Data;
@Data
@Builder
@Entity
@Table(name="utilisateur")
public class utilisateur extends employe implements UserDetails{
	private static final long serialVersionUID = 1L;
	    
	    private String userName;
	    private String password;
	    private role role;
	    Boolean actif;


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

		public String toString() {
			super.toString();
			return "utilisateur{"+ "userName:"+userName+"mot de passe :"+password+"role:"+role+"}";
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
