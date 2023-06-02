package ngcb.app.ngcb.model;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
@Entity
public class ChatMessage implements Serializable {
    @Id
    @GeneratedValue
    private Long id;
    @ManyToOne
    @JoinColumn(name="matricule", nullable=false)
    @JsonIgnoreProperties("messages")
    private utilisateur utilisateur;
    private String message ;
    private  Boolean vu ;
    
    public ChatMessage() {
	}
    
	public ChatMessage(Long id, utilisateur utilisateur, String message, Boolean vu) {
		this.id = id;
		this.utilisateur = utilisateur;
		this.message = message;
		this.vu = vu;
	}
    
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public utilisateur getUtilisateur() {
		return utilisateur;
	}
	public void setUtilisateur(utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Boolean getvu() {
		return vu;
	}
	public void setvu(Boolean vu) {
		this.vu = vu;
	}

	@Override
	public String toString() {
		return "ChatMessage [id=" + id + ", utilisateur=" + utilisateur + ", message=" + message + ", vu=" + vu
				+ "]";
	}

}
