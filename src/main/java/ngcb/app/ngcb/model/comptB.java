/**
 * 
 */
package ngcb.app.ngcb.model;

/**
 * @author Sos
 *
 */

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.JoinColumn ;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

@Entity


 public class comptB implements Serializable {

@Autowired

private static final long serialVersionUID = 1L;
@ManyToMany
@JoinTable(
  name = "delegation", 
  joinColumns = @JoinColumn(name = "id"), 
  inverseJoinColumns = @JoinColumn(name = "matricule"))
Set<signataire> signataires;
@Id
@GeneratedValue
 	   Long id ;

@ManyToOne
@JoinColumn(name="codeStr", nullable=false )
@JsonIgnoreProperties("comptesB")
public structure structure;

@ManyToOne
@JoinColumn(name="codeAgence", nullable=false )
@JsonIgnoreProperties("comptesB")
private agence agence;
       Long rib ;
       nature nature ;
	   type type ;
	   LocalDate date_dem;
	   LocalDate date_ouv;
	   public LocalDate getDate_dem() {
		return date_dem;
	}
	public void setDate_dem(LocalDate date_dem) {
		this.date_dem = date_dem;
	}
	LocalDate date_clo ;
	   
	   
	   private etat etat;
	   public comptB () {}
	   comptB (Long id, Long rib ,nature nature ,type type, etat etat ,LocalDate date_dem,LocalDate date_ouv  ,LocalDate date_clo)
	    { this.id=id;
	        this.rib = rib;
	        this.nature = nature;
	        this.type = type;
	        this.etat = etat;
	        this.date_dem=date_dem;
	        this.date_ouv = date_ouv;
	        this.date_clo = date_clo;
	        
	    }
	
	public void setSignataires(Set<signataire> signataires) {
		this.signataires = signataires;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getRib() {
	        return rib;
	    }

	    public void  setRib(Long rib){
	        this.rib = rib;
	    }

	public nature getNature()  {
	    return nature;
	}

		public void setNature(nature nature) {
	    this.nature = nature ;
	}

		public  type getType() {
	    return type;
	}

		public void setType(type type)  {
	    this.type = type ;
	}

	public etat getEtat () {
	    return etat ;
	}

		public  void setEtat (etat etat){
	    this.etat= etat ;
	}

	public LocalDate getDate_ouv()  {
	    return date_ouv;
	}

		public  void setDate_ouv(LocalDate date_ouv){
	    this.date_ouv = date_ouv;
	}

	public LocalDate getDate_clo(){
	    return date_clo;
	}

	public void setDate_clo(LocalDate date_clo) {
		this.date_clo = date_clo;
	}
		
		 public Set<signataire> getSignataires() {
		        return signataires;
		    }
		 
	
	public structure getStructure() {
				return structure;
			}
			public void setStructure(structure structure) {
				this.structure = structure;
			}
		public agence getAgence() {
				return agence;
			}
			public void setAgence(agence agence) {
				this.agence = agence;
			}
@Override
		public String toString() {
			return "compte bancaire{"+"rib:"+rib+"nature:"+nature+"etat:"+etat+"type:"+type+ "date ouverture:"+date_ouv+"date_clo"+date_clo+"}";
		}




}

