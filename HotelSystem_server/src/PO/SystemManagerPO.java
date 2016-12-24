package PO;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "systemmanager")
public class SystemManagerPO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String managerID;
	private String managerName;
    private String image;
    
 public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	
	public SystemManagerPO(){}

	public String getManagerName() {
		return managerName;
	}

	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}
	@Id
	public String getManagerID() {
		return managerID;
	}
	public void setManagerID(String managerID) {
		this.managerID = managerID;
	}

	
}
