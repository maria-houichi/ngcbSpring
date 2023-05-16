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
	   @Column(name = "dateDeleg")
	   private Date dateDeleg;
	   @Column(name = "dateAnnul")
	   private Date dateAnnul;
	   @Column(name = "etat")
	   private etatDeleg etat;
	   @Column(name = "estValide")
	   private Boolean estValide;
	   
	   
	   @JoinColumn(name = "compteB" /*insertable = false, updatable = false*/)
	   @ManyToOne
	   @JsonBackReference
	   private comptB comptB;
	   @JoinColumn(name = "signataire"/*, insertable = false, updatable = false*/)
	   @ManyToOne
	   private signataire signataire;
	   
	   
	   public delegation() {
	   }

	public delegation(pk_deleg pkDeleg, Date dateDeleg, Date dateAnnul, etatDeleg etat, Boolean estValide,
			signataire signataire, comptB comptB) {
		
		this.pkDeleg = pkDeleg;
		this.dateDeleg = dateDeleg;
		this.dateAnnul = dateAnnul;
		this.etat = etat;
		this.estValide = estValide;
		this.signataire = signataire;
		this.comptB = comptB;
	}

	

	public pk_deleg getPkDeleg() {
		return pkDeleg;
	}

	public void setPkDeleg(pk_deleg pkDeleg) {
		this.pkDeleg = pkDeleg;
	}

	public Date getdateDeleg() {
		return dateDeleg;
	}

	public void setdateDeleg(Date dateDeleg) {
		this.dateDeleg = dateDeleg;
	}

	public Date getdateAnnul() {
		return dateAnnul;
	}

	public void setdateAnnul(Date dateAnnul) {
		this.dateAnnul = dateAnnul;
	}

	public etatDeleg getEtat() {
		return etat;
	}

	public void setEtat(etatDeleg etat) {
		this.etat = etat;
	}

	public Boolean getestValide() {
		return estValide;
	}

	public void setestValide(Boolean estValide) {
		this.estValide = estValide;
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
		return "delegation [pkDeleg=" + pkDeleg + ", dateDeleg=" + dateDeleg + ", dateAnnul=" + dateAnnul
				+ ", etat=" + etat + ", estValide=" + estValide + ", signataire=" + signataire + ", comptB=" + comptB
				+ "]";
	}
	   
	   
}
