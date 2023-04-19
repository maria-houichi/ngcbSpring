/**
 * 
 */
package ngcb.app.ngcb.model;

import java.io.Serializable;



import org.springframework.beans.factory.annotation.Autowired;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;

@Entity

@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public class employe implements Serializable {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	@Autowired
	
	@Id
	private String matricule;
    private String nom;
    private String prenom;
    private String fonction;
    public genre genre;

    public employe () {}
    public employe ( String matricule  ,String  nom , String  prenom, String fonction  ,genre genre )
    {
        this.matricule = matricule;
        this.nom=nom;
        this.prenom=prenom;
        this.fonction=fonction;
        this.genre = genre;
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
@Override
public String toString() {
	return "employé{"+"matricule:"+matricule+", nom :"+nom+"prenom:"+prenom+"fonction:"+fonction+"genre:"+genre+ "}";
}
}
