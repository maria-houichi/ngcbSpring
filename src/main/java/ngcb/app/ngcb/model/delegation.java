package ngcb.app.ngcb.model;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
@Entity
public class delegation implements Serializable{
	 private static final long serialVersionUID = 1L;
	   @EmbeddedId
	   protected pk_deleg pkDeleg;
	   @Column(name = "date_deleg")
	   private Date date_deleg;
	   @Column(name = "date_annul")
	   private Date date_annul;
	   @Column(name = "etat")
	   private String etat;
	   @Column(name = "est_valide")
	   private Boolean est_valide;
	   
	   
	   @JoinColumn(name = "compteB", insertable = false, updatable = false)
	   @ManyToOne
	   @JsonBackReference
	   private comptB comptB;
	   @JoinColumn(name = "signataire", insertable = false, updatable = false)
	   @ManyToOne
	   private signataire signataire;
	   
	   
	   public delegation() {
	   }

	public delegation(pk_deleg pkDeleg, Date date_deleg, Date date_annul, String etat, Boolean est_valide,
			signataire signataire, comptB comptB) {
		
		this.pkDeleg = pkDeleg;
		this.date_deleg = date_deleg;
		this.date_annul = date_annul;
		this.etat = etat;
		this.est_valide = est_valide;
		this.signataire = signataire;
		this.comptB = comptB;
	}

	

	public pk_deleg getPkDeleg() {
		return pkDeleg;
	}

	public void setPkDeleg(pk_deleg pkDeleg) {
		this.pkDeleg = pkDeleg;
	}

	public Date getDate_deleg() {
		return date_deleg;
	}

	public void setDate_deleg(Date date_deleg) {
		this.date_deleg = date_deleg;
	}

	public Date getDate_annul() {
		return date_annul;
	}

	public void setDate_annul(Date date_annul) {
		this.date_annul = date_annul;
	}

	public String getEtat() {
		return etat;
	}

	public void setEtat(String etat) {
		this.etat = etat;
	}

	public Boolean getEst_valide() {
		return est_valide;
	}

	public void setEst_valide(Boolean est_valide) {
		this.est_valide = est_valide;
	}

	public signataire getSignataire() {
		return signataire;
	}

	public void setSignataire(signataire signataire) {
		this.signataire = signataire;
	}

	public comptB getComptB() {
		return comptB;
	}

	public void setComptB(comptB comptB) {
		this.comptB = comptB;
	}
	   
	@Override
	public String toString() {
		return "delegation [pkDeleg=" + pkDeleg + ", date_deleg=" + date_deleg + ", date_annul=" + date_annul
				+ ", etat=" + etat + ", est_valide=" + est_valide + ", signataire=" + signataire + ", comptB=" + comptB
				+ "]";
	}
	   
	   
}
