
package ngcb.app.ngcb.model;

import java.io.Serializable;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
@Entity
public class banque implements Serializable {

	private static final long serialVersionUID = 1L;
	 @Id
	  Long codeBanque ;
 @OneToMany(mappedBy="banque")
	  @JsonIgnoreProperties("banque")
	 private Set<agence> agences;  
	  
	  /*@OneToMany(mappedBy="banque")
	  @JsonIgnoreProperties("banque")
	    private Set<comptB> comptesB;*/
	  String lib_banque;
	  String  e_mailB;
	  public banque() {}
	  banque(Long codeBanque, String lib_banque,String e_mailB )
	    {
	        this.codeBanque = codeBanque;
	        this.lib_banque = lib_banque;
	        this.e_mailB = e_mailB;
	    }
	        public Long getcodeBanque() {
		    return codeBanque;
		}

			public void setcodeBanque(Long codeBanque){
		    this.codeBanque = codeBanque;
		}

			public String getLib_banque(){
		    return lib_banque;
		}

		public Set<agence> getAgences() {
				return agences;
			}
			public void setAgences(Set<agence> agences) {
				this.agences = agences;
			}/*	
			public Set<comptB> getComptesB() {
				return comptesB;
			}
			public void setComptesB(Set<comptB> comptesB) {
				this.comptesB = comptesB;
			}*/
			public void setLib_banque(String lib_banque){
		    this.lib_banque = lib_banque;
		}

			public String getE_mailB(){
		    return e_mailB;
		}

			public void setE_mailB(String e_mailB){
		    this.e_mailB = e_mailB;
		}
@Override
			public String toString() {
				return "banque{"+"code banque:"+codeBanque+",lib banque :"+lib_banque+"e_mail banque:"+e_mailB+ "}";
			}

}
