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
public class structure implements Serializable {
    /**
	 *
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)

	Long code_str;
    Long str_parent ;
    String lib_str;
    String type_str;
    public structure () {}
    structure (Long code_str,Long str_parent,String lib_str,String type_str)
    {
        this.code_str = code_str;
        this.str_parent = str_parent;
        this.lib_str = lib_str;
        this.type_str = type_str;
    }
    public Long getCode_str(){
        return code_str;
    }

    	public void  setTCode_str(Long code_str) {
       this.code_str=code_str ;
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

    	public String getype_str() {
        return type_str ;
    }

    	public void setType_str(String type_str) {
        this.type_str = type_str;
    }
@Override
    	public String toString() {
    		return "structure{"+"code structure :"+code_str+",structure parent :"+str_parent+"lib structure"+lib_str+"type structure"+type_str+ "}";
    	}

}
