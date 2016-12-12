package PO;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Id")
public class ClassToGreId {
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
