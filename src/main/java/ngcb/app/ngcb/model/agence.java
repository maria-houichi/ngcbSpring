package ngcb.app.ngcb.model;


import java.io.Serializable;
import java.util.Set;

import org.hibernate.annotations.Cache;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity

public class agence implements Serializable{

	private static final long serialVersionUID = 1L;
@Id

	   Long codeAgence;
@OneToMany(mappedBy="agence")
@JsonIgnoreProperties("agence")
private Set<comptB> comptesB;

@ManyToOne
@JoinColumn(name="codeBanque", nullable=false)
@JsonIgnoreProperties("agences")
private banque banque;
       
	   String  lib_agence;
	   String  adrs ;
	   String e_mail_a;
	   public agence () {}
	   agence(Long codeAgence,String lib_agence,String adrs,String e_mail_a)
	    {
		   
	        this.codeAgence = codeAgence;
	        this.lib_agence = lib_agence;
	        this.adrs = adrs;
	        this.e_mail_a = e_mail_a;
	    }
	   public Long getcodeAgence() {
		    return codeAgence;
		}

			public void setcodeAgence(Long codeAgence) {
		    this.codeAgence = codeAgence;
		}

			public String getLib_agence(){
		    return lib_agence;
		}

			public void setLib_agence(String lib_agence){
		    this.lib_agence = lib_agence;
		}

			public String  getAdrs(){
		    return adrs;
		}

			public void setAdrs(String adrs){
		    this.adrs = adrs;
		}

			
	
		public Set<comptB> getComptesB() {
				return comptesB;
			}
			public void setComptesB(Set<comptB> comptesB) {
				this.comptesB = comptesB;
			}
			public banque getBanque() {
				return banque;
			}
			public void setBanque(banque banque) {
				this.banque = banque;
			}
			public String getE_mail_a() {
				return e_mail_a;
			}
			public void setE_mail_a(String e_mail_a) {
				this.e_mail_a = e_mail_a;
			}
@Override
			public String toString() {
				return "agence{"+"code agence :"+codeAgence +",lib agence:"+lib_agence+"adresse agence:"+adrs+"e_mail agence :"+e_mail_a+ "}";
			}

}
