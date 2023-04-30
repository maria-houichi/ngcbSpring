/**
 * 
 */
package ngcb.app.ngcb.model;

/**
 * @author Sos
 *
 */
import java.io.Serializable;
import java.util.Set;

import org.hibernate.annotations.Cache;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
@Entity

public class structure implements Serializable {
    /**
	 *
	 */
	private static final long serialVersionUID = 1L;
	@Id
	Long codeStr;
	@OneToMany(mappedBy="structure")
	@JsonIgnoreProperties("structure")
	private Set<comptB> comptesB;
    Long str_parent ;
    String lib_str;
    String type_str;
    public structure () {}
    structure (Long codeStr,Long str_parent,String lib_str,String type_str)
    {
        this.codeStr = codeStr;
        this.str_parent = str_parent;
        this.lib_str = lib_str;
        this.type_str = type_str;
    }
    public Long getcodeStr(){
        return codeStr;
    }
    
    public void setcodeStr(Long codeStr) {
		this.codeStr = codeStr;
	}


    	public Long getStr_parent(){
        return str_parent;
    }

    	public void setStr_parent(Long str_parent){
        this.str_parent = str_parent ;
    }

    	public String getLib_str()  {
        return lib_str;
    }

    	public void setLib_str(String lib_str) {
        this.lib_str = lib_str;
    }

    	public String getType_str() {
    		return type_str;
    	}

    	public void setType_str(String type_str) {
        this.type_str = type_str;
    }
    /*	public Set<comptB> getComptesB() {
    			return comptesB;
    		}
    		public void setComptesB(Set<comptB> comptesB) {
    			this.comptesB = comptesB;
    		}*/
@Override
    	public String toString() {
    		return "structure{"+"code structure :"+codeStr+",structure parent :"+str_parent+"lib structure"+lib_str+"type structure"+type_str+ "}";
    	}

}
