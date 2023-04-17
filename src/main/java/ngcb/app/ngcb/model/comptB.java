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

import org.springframework.beans.factory.annotation.Autowired;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity
/**
 * @author Sos
 *
*/
 public class comptB implements Serializable {
	   /**
	 *
	 */
@Autowired

private static final long serialVersionUID = 1L;
@Id
@GeneratedValue (strategy = GenerationType.AUTO)

	   Long rib ;
	   String intitule ;
	   nature nature ;
	   type type ;
	   etat etat;
	   LocalDate date_ouv;
	   LocalDate date_clo ;
	   public comptB () {}
	   comptB (Long rib ,String intitule ,nature nature ,type type, etat etat ,LocalDate date_ouv  ,LocalDate date_clo)
	    {
	        this.rib = rib;
	        this.intitule = intitule;
	        this.nature = nature;
	        this.type = type;
	        this.etat = etat;
	        this.date_ouv = date_ouv;
	        this.date_clo = date_clo;
	    }
	   public Long getRib() {
	        return rib;
	    }

	    public void  setRib(Long rib){
	        this.rib = rib;
	    }

	    public String  getIntitule() {
	    return intitule;
	}

		public  void setIntitule (String intitule) {
	    this.intitule = intitule ;
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

		public void setdate_clo (LocalDate date_clo){
	    this.date_clo = date_clo;
	}
@Override
		public String toString() {
			return "compte bancaire{"+"rib:"+rib+", intitulé :"+intitule+"nature:"+nature+"etat:"+etat+"type:"+type+ "date ouverture:"+date_ouv+"date_clo"+date_clo+"}";
		}


}

