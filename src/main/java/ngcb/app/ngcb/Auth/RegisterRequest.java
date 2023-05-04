package ngcb.app.ngcb.Auth;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ngcb.app.ngcb.model.role;

@Data
@Builder 
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {

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
public String getUserName() {
	return userName;
}
public void setUserName(String userName) {
	this.userName = userName;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
private String nom;
private String prenom;
private String userName;
private String password ;
private role role;

} 
