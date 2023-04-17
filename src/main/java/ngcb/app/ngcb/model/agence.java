/**
 * 
 */
package ngcb.app.ngcb.model;

/**
 * @author Sos
 *
 */
import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class agence implements Serializable{
	   /**
	 *
	 */
	private static final long serialVersionUID = 1L;
@Id
@GeneratedValue (strategy = GenerationType.AUTO)

	   Long code_agence;
	   String  lib_agence;
	   String  adrs ;
	   String e_mail_a;
	   public agence () {}
	   agence(Long code_agence,String lib_agence,String adrs,String e_mail_a)
	    {
	        this.code_agence = code_agence;
	        this.lib_agence = lib_agence;
	        this.adrs = adrs;
	        this.e_mail_a = e_mail_a;
	    }
	   public Long getCode_agence() {
		    return code_agence;
		}

			public void setCode_agence(Long code_agence) {
		    this.code_agence = code_agence;
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

			public String getE_mailA(){
		    return e_mail_a;
		}

			public void setE_mailA(String e_mail_a){
		    this.e_mail_a =e_mail_a;
		}
@Override
			public String toString() {
				return "agence{"+"code agence :"+code_agence +",lib agence:"+lib_agence+"adresse agence:"+adrs+"e_mail agence :"+e_mail_a+ "}";
			}

}
