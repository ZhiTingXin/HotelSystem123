package PO;
import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="greID")
public class ClassToGreId implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String Id;
    private String neverChanged;
    public ClassToGreId(){}
    public ClassToGreId(String Id){
    	super();
    	neverChanged = "1";
    	this.Id =Id;
    }
    public String getId() {
		return Id;
	}
	public void setId(String id) {
		Id = id;
	}
	@Id
	public String getNeverChanged() {
		return neverChanged;
	}
	public void setNeverChanged(String neverChanged) {
		this.neverChanged = neverChanged;
	}
	
}
