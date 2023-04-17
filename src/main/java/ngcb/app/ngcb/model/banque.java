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
public class banque implements Serializable {
	  /**
	 *
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)

	Long code_banque ;
	  String lib_banque;
	  String  e_mailB;
	  public banque() {}
	  banque(Long code_banque, String lib_banque,String e_mailB )
	    {
	        this.code_banque = code_banque;
	        this.lib_banque = lib_banque;
	        this.e_mailB = e_mailB;
	    }
	        public Long getCode_banque() {
		    return code_banque;
		}

			public void setCode_banque(Long code_banque){
		    this.code_banque = code_banque;
		}

			public String getLib_banque(){
		    return lib_banque;
		}

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
				return "banque{"+"code banque:"+code_banque+",lib banque :"+lib_banque+"e_mail banque:"+e_mailB+ "}";
			}

}
