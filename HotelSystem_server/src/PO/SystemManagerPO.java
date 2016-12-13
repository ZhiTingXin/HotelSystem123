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
	
	public SystemManagerPO(){}
	public SystemManagerPO(String managerID, String managerName){
		this.managerID = managerID;
		this.managerName = managerName;
	}
	
	@Id
	public String getId() {
		return managerID;
	}

	public void setId(String managerID) {
		this.managerID = managerID;
	}

	public String getManagerName() {
		return managerName;
	}

	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}

	
}
