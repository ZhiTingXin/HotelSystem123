package PO;

import VO.SystemManagerVO;

public class SystemManagerPO {
	private String managerID;
	private String managerName;
	
	public SystemManagerPO(){}
	public SystemManagerPO(SystemManagerVO systemManagerVO){
		super();
		this.managerID = systemManagerVO.getId();
		this.managerName = systemManagerVO.getUserName();
	}
	public SystemManagerPO(String managerID, String managerName){
		this.managerID = managerID;
		this.managerName = managerName;
	}
	
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
